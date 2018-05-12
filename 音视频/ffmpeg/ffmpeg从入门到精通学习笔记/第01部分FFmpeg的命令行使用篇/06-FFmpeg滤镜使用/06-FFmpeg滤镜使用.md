# 第六章 FFmpeg滤镜使用


# 6.1 FFmpeg 滤镜Filter描述格式

这一节说的是FFmpeg滤镜的基本语法与基本的内置变量

Filter基本格式


## 1. FFmpeg滤镜Filter的参数排列方式

`[输入流或标记名]滤镜参数[临时标记名];[输入流或标记名]滤镜参数[临时标记名]`

输出两个文件, 一个视频input.mp4, 一个图片logo.png, 将logo进行缩放, 然后放在视频的左上角

`ffmpeg -i input.mp4 -i logo.png -filter_complex "[1:v]scale=176:144[logo];[0:v][logo]overlay=x=0:y=0" output.mp4`

- `[1:v]scale=176:144[logo];`  设置图片大小
- `[0:v][logo]overlay=x=0:y=0` 设置位置




## 2. FFmpeg滤镜Filter时间内置变量


![06-FFmpeg滤镜使用-01](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-01.png)


# 6.2 FFmpeg为视频加水印

## 1. 文字水印


![06-FFmpeg滤镜使用-02](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-02.png)


### drawtext滤镜使用举例

- 将文字的水印加载视频的左上角

`ffmpeg -i input.mp4 -vf "drawtext=fontsize=100:fontfile=FreeSerif.ttf:text='hello world':x=20:y=20" drawtext1.mp4`


- 接着上面给文字加颜色

`ffmpeg -i input.mp4 -vf "drawtext=fontsize=23:fontfile=FreeSerif.ttf:text='hello world':x=20:y=20:fontcolor=red" drawtext5boxcolor.mp4`


- 给水印增加一个框

`ffmpeg -i input.mp4 -vf "drawtext=fontsize=23:fontfile=FreeSerif.ttf:text='hello world':x=20:y=20:fontcolor=red:box=1:boxcolor=black" drawtext5boxcolor.mp4`


- 水印添加本地时间

`ffmpeg -re -i input.mp4 -vf "drawtext=fontsize=23:fontfile=FreeSerif.ttf:text='%{localtime\:%Y\-%m\-%d %H-%M-%S}':x=20:y=20:fontcolor=red:box=1:boxcolor=black" drawtext6time.mp4`


- 如果文字里有:, 用\转义
`ffmpeg -re -i input.mp4 -vf "drawtext=fontsize=23:fontfile=FreeSerif.ttf:text='by\: wutong':x=20:y=20:fontcolor=red" drawtext闪.mp4`


- 每三秒闪一下文字
`ffmpeg -re -i input.mp4 -vf "drawtext=fontsize=23:fontfile=FreeSerif.ttf:text='by\: wutong':x=20:y=20:fontcolor=red:box=1:boxcolor=black:enable=lt(mod(t\,3)\,1)" drawtext闪.mp4`

- 中文字符
`ffmpeg -re -i input.mp4 -vf "drawtext=fontsize=23:fontfile=/Library/Fonts/Songti.ttc:text='出自\: 吴铜':x=20:y=20:fontcolor=red" drawtext8-中文.mp4`








## 2. 图片水印


![06-FFmpeg滤镜使用-03](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-03.png)

在FFmpeg中加入图片水印有两种方式:
- 通过Movie指定水印文件路径
- 通过filter读取输入文件的流并指定为水印

下面会重点介绍如何读取movie图片文件作为水印

- 坐标x30,y10
`ffmpeg -i input.mp4 -vf "movie=logo.png[wm]; [in][wm]overlay=30:10[out]" movie1.mp4`


- 图片半透明, 根据colorkey设置的颜色值,相似度,混合度与原片混合为半透明水印.
  - 色值:black
  - 相似度:1.0
  - 混合度:1.0


`ffmpeg -i input.mp4 -vf "movie=logo.png, colorkey=black:1.0:1.0 [wm]; [in][wm]overlay=30:10 [out]" movieAndColorkey.mp4`


# 6.3 FFmpeg生成画中画

多个视频

![06-FFmpeg滤镜使用-04](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-04.png)



`ffmpeg -re -i input.mp4 -vf "movie=sub.mp4,scale=200x200[test]; [in][test]overlay[out]" -vcodec libx264 overlaytest1.mp4`


- 生成一个flv的话中画

`ffmpeg -re -i input.mp4 -vf "movie=sub.mp4,scale=200x200[test]; [in][test]overlay=x=main_w-200:y=main_h-200 [out]" -vcodec libx264 overlaytest2.flv`

这条命令除了显示在overlay画面中, 子视频将会定位在主画面的最右边减去子视频的宽度, 最下边减去子视频的高度位置,


- 让画中画动起来

使用overlay还可以配合正则表达式进行跑马灯式画中画处理, 动态改变子画面的x坐标与y坐标即可

`ffmpeg -re -i input.mp4 -vf "movie=sub.mp4,scale=200x200[test]; [in][test]overlay=x='if(gte(t,2), -w+(t-2)*20, NAN)' :y=0 [out]" -vcodec libx264 overlaytest3.mp4`


子视频从左侧渐渐向右移动 

# 6.4 FFmpeg视频多宫格处理



```


ffmpeg -re -i 1.mp4 -re -i 2.mp4 -re -i 3.mp4 -re -i 4.mp4 -filter_complex "nullsrc=size=640x480 [base]; [0:v] setpts=PTS-STARTPTS, scale=320x240 [upperleft];[1:v] setpts=PTS-STARTPTS, scale=320x240 [upperright]; [2:v] setpts=PTS-STARTPTS, scale=320x240 [lowerleft]; [3:v] setpts=PTS-STARTPTS, scale=320x240 [lowerright]; [base][upperleft] overlay=shortest=1[tmp1]; [tmp1][upperright] overlay=shortest=1:x=320 [tmp2]; [tmp2][lowerleft]overlay=shortest=1:y=240 [tmp3]; [tmp3][lowerright] overlay=shortest=1:x=320:y=240" -c:v libx264 voerlay5.mp4


```

执行完命令行之后, 即可以通过nullsrc创建一个overlay 画布, 画布的大小为宽640像素, 搞480像素, 使用`[0:v][1:v][2:v][3:v]` 将输入的4个视频流去除, 分别进行缩放处理, 处理为宽320, 高240的视频, 然后基于nullsrc生成的画布进行视频平铺, 平铺的整体情况如图


![06-FFmpeg滤镜使用-05](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-05.png)




# 6.5 FFmpeg音频流滤镜操作

FFmpeg可以对音频做些啥?
`拆分声道`, `合并多声道为单声道`, `调整声道布局`, `调整音频采样频率`
有哪些滤镜了?
`amix`,  `amerge`, `pan`, `channelsplit`, `volume`, `volumedetect`

## 1. 双声道合并单声道

## 看看FFmpeg对音频的声道布局支持情况 ffmpeg -layouts

- 双声道(stereo)==>单声道(mono)

`ffmpeg -i 2_stereo.aac -ac 1 2_mono.aac`




## 2. 双声道提取


`ffmpeg -i 2_stereo.aac -map_channel 0.0.0 left.aac -map_channel 0.0.1 right.aac`

`ffmpeg -i 2_stereo.aac -filter_complex "[0:0]pan=1c|c0=c0[left];[0:0]pan=1c|c0=c1[right]" -map "[left]" left2.aac -map "[right]" right2.aac`



## 3.双声道转双音频流

将双声道音频提取出来转为一个音频文件两个音频流, 每个音频流为一个声道

`ffmpeg -i qt.aac -filter_complex channelsplit=channel_layout=stereo qt.mka`



![06-FFmpeg滤镜使用-06](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-06.png)
![06-FFmpeg滤镜使用-07](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-07.png)

### 大多数播放器默认情况下,只会播放第一个Stream

## 4.单声道转双声道

`ffmpeg -i 1_mono.aac -ac 2 1_stereo.m4a`
mono布局====>stereo布局


`ffmpeg -i 1_mono.aac -filter_complex "[0:a][0:a]amerge=inputs=2[aout]" -map "[aout]" 1stereo.m4a`


通过这两种只是布局变成了双声道stereo, 是假的双声道, 音频质量并不会好

## 5. 两个音频源合并双声道

`ffmpeg -i qleft.aac -i 1_mono.aac -filter_complex "[0:a][1:a]amerge=inputs=2[aout]" -map "[aout]" mmmuxer.aac`


- 转成aac的音频
`ffmpeg -i qleft.aac -i 1_mono.aac -filter_complex "[0:a][1:a]amerge=inputs=2[aout]" -map "[aout]" -acodec aac mmmuxer2.mka`


## 6. 多个音频合并为多声道

`ffmpeg -i 1.aac -i 2.aac -i 3.aac -i 4.aac -i 5.aac -i 6.aac -filter_complex "[0:a][1:a][2:a][3:a][4:a][5:a]amerge=inputs=6[aout]" -map "[aout]" -acodec aac auto.aac`




# 6.6 FFmpeg音频音量探测

## 1. 音频音量获得

`ffmpeg -i 1.aac -filter_complex volumedetect -c:v copy -f null ./`


![06-FFmpeg滤镜使用-08](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-08.png)
mean_volume: 音频的平均大小, -16.6dB



## 2. 绘制音频波形


`ffmpeg -i 1.aac -filter_complex "showwavespic=s=640x120" -frames:v 1 output.png`


![06-FFmpeg滤镜使用-09](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-09.png)


- 看所有声道

`ffmpeg -i auto.aac -filter_complex "showwavespic=s=640x240:split_channels=1" -frames:v 1 channels1.png`


![06-FFmpeg滤镜使用-10](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-10.png)



# 6.7 FFmpeg为视频加字幕



## 坑点, 你得从新编译哟, 如果你没有将ass启用的话, ......20分钟又没了.....

```


/**

--yasmexe=/Users/codew/Desktop/code4-av/yasm/yasmB/yasm-1.3.0/bin/yasm
--enable-ffplay
--enable-gpl
--enable-libfdk_aac
--enable-libmp3lame
--enable-nonfree
--enable-libfreetype
--enable-libx264
--enable-libfreetype
--enable-libfontconfig
--prefix=/Users/codew/Desktop/code4-av/ffmpeg_x264_fdkaac_ffplayer_drawtext
--enable-libass
*/



./configure --yasmexe=/Users/codew/Desktop/code4-av/yasm/yasmB/yasm-1.3.0/bin/yasm --enable-ffplay --enable-gpl --enable-libfdk_aac --enable-libmp3lame --enable-nonfree --enable-libfreetype --enable-libx264 --enable-libfontconfig --enable-libass --prefix=/Users/codew/Desktop/code4-av/ffmpeg_ass_x264_fdkaac_ffplayer_drawtext



make
make install



```

ASS字幕流 测试拿走不谢
```


﻿[Script Info]
Title: Default ASS file
ScriptType: v4.00+
WrapStyle: 2
Collisions: Normal
PlayResX: 960
PlayResY: 720
ScaledBorderAndShadow: yes
Video Zoom Percent: 1

[V4+ Styles]
Format: Name, Fontname, Fontsize, PrimaryColour, SecondaryColour, OutlineColour, BackColour, Bold, Italic, Underline, StrikeOut, ScaleX, ScaleY, Spacing, Angle, BorderStyle, Outline, Shadow, Alignment, MarginL, MarginR, MarginV, Encoding
Style: Default,微软雅黑,20,&H00FFFFFF,&H00FFFFFF,&H28533B3B,&H500E0A00,0,0,0,0,100.0,100.0,0.0,0.0,1,3.5546875,3.0,2,10,10,5,1
Style: left_down,微软雅黑,20,&H00FFFFFF,&H00FFFFFF,&H28533B3B,&H500E0A00,0,0,0,0,100.0,100.0,0.0,0.0,1,3.5546875,3.0,1,10,10,5,1
Style: right_down,微软雅黑,20,&H00FFFFFF,&H00FFFFFF,&H28533B3B,&H500E0A00,0,0,0,0,100.0,100.0,0.0,0.0,1,3.5546875,3.0,3,10,10,5,1
Style: left_up,微软雅黑,20,&H00FFFFFF,&H00FFFFFF,&H28533B3B,&H500E0A00,0,0,0,0,100.0,100.0,0.0,0.0,1,3.5546875,3.0,7,10,10,5,1
Style: right_up,微软雅黑,20,&H00FFFFFF,&H00FFFFFF,&H28533B3B,&H500E0A00,0,0,0,0,100.0,100.0,0.0,0.0,1,3.5546875,3.0,9,10,10,5,1

[Events]
Format: Layer, Start, End, Style, Name, MarginL, MarginR, MarginV, Effect, Text
Dialogue: 2,0:00:00.00,9:00:00.00,left_down,,0,0,0,,这里是左下角\N随便说点啥,意思一下\N希望我们的音视频技术越来越好啊...
Dialogue: 2,0:00:00.00,9:00:00.00,right_down,,0,0,0,,最右下角的文字
Dialogue: 2,0:00:00.00,9:00:00.00,left_up,,0,0,0,,这里是左上角的文字\N我测试一下换行~\N真的换行了\N去我的网页看看?www.codertomwu.com
Dialogue: 2,0:00:00.00,9:00:00.00,right_up,,0,0,0,,这里就是右上角了~\N说点啥了, 做一行就爱一行啊,开心最重要


```


## 1.ASS字幕流写入视频流


`ffmpeg -i 4.mp4 -vf ass=ass.ass -f flv assTest.flv`




## 2. ASS字幕写入封装容器

前面是加入视频编码中

这里是在视频封装容器中增加字幕流, 需要封装容器格式支持字幕流

FFmpeg将ass字幕流写入MKV封装容器中

`ffmpeg -i 4.mp4 -i test.ass -acodec copy -vcodec copy -scodec copy assmk.mkv`
上面的命令并不适合mp4, 也就是说mp4不支持字幕流?

字幕流+视频流+音频流
![06-FFmpeg滤镜使用-11](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-11.png)
![06-FFmpeg滤镜使用-12](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-12.png)




将第一个输入文件的第一个流和第二个流与第二个文件的第一个流写入assmk3.mkv
`ffmpeg -i 4.mp4 -i test.ass -map 0:0 -map 0:1 -map 1:0 -acodec copy -vcodec copy -scodec copy assmk3.mkv`

将第一个输入文件的第一个流和第二个流与第二个文件的第三个流写入assmk3.mkv, 将assmk.mkv里的ass抠出来安装到assmk4.mkv里面去
`ffmpeg -i 4.mp4 -i assmk.mkv -map 0:0 -map 0:1 -map 1:2 -acodec copy -vcodec copy -scodec copy assmk4.mkv`

ffmpeg -i assmk.mkv -scodec copy assCo.ass
# 6.8 FFmpeg视频抠图合并


![06-FFmpeg滤镜使用-13](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-13.png)


` ffmpeg -i input.mp4 -i green_bck.mp4 -filter_complex "[1:v]chromakey=Green:0.1:0.2[ckout];[0:v][ckout]overlay[out]" -map "[out]" output.mp4`


`FFmpeg中除了有chromakey滤镜之外, 还有一个colorkey参数, chromakey滤镜主要处理YUV数据, 所以一般来说做绿幕处理更有优势; 而colorkey处理纯色均可以, 因为colorkey处理主要以RGB数据为主`

# 6.9 FFmpeg 3D视频处理

## 1. stereo3d 处理3D视频
## 2. 3D图像转换举例



`ffplay -vf "stereo3d=sbsl:aybd" y.mp4`

执行后会将原片的左右排列效果合并为`黄蓝`合并排列效果, 视频播放起来将会有立体感


如果使用红蓝眼镜观看视频, 可以使用`红蓝`输出参数
`ffplay -vf "stereo3d=sbsl:aybg" y.mp4`



# 6.10 FFmpeg定时视频截图

## 1. vframe参数截取一张图片

定位到40秒的地方截个图
`ffmpeg -i y.mp4 -ss 00:00:40 -vframes 1 out.png`


## 2. fps 滤镜定时获得图片

- 每隔一秒生成一张PNG图片
`ffmpeg -i y.mp4 -vf fps=1 out%d.png`
`ffmpeg -i http://206.189.128.41:1100/gg/ccn.mp4 -vf fps=1 out%d.png`

- 每隔一分钟生成一张图片

` ffmpeg -i y.mp4 -vf fps=1/60 out%d.jpg`

- 每隔10分钟生产一张BMP图片

`ffmpeg -i y.mp4 -vf fps=1/600 out%d.bmp`


### 上面三种都是以时间的, 下面是安装关键帧

`ffmpeg -i y.mp4 -vf "select='eq(pict_type,PICT_TYPE_I)'" -vsync vfr thumb%04d.png`

# 6.11 FFmpeg生成测试元数据

## 1. FFmpeg生成音频测试流

// 实际上下面两条测试失败, mac, centos, 
`ffmpeg -re -f lavfi -i abuffer=sample_rate=44100:sample_fmt=s16p:channel_layout=stereo -acodec aac -y output.aac`

`ffmpeg -re -f lavfi "aevalsrc=sin(420*2*PI*t)|cos(430*2*PI*t):c=FC|BC" -acodec aac output.aac`


## 2. FFmpeg 生成视频测试流

`ffmpeg -re -f lavfi -i testsrc=duration=5.3:size=qcif:rate=25 -vcodec libx264 -r:v 25 output2.mp4`


![06-FFmpeg滤镜使用-14](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-14.png)

FFmpeg会根据testsrc生成长度为5.3秒的,图像大小为QCIF分辨率,帧率为25fps的视频图像数据, 并编码成H.264


- testsrc2生成一个MP4
`ffmpeg -re -f lavfi -i testsrc2=duration=5.3:size=qcif:rate=25 -vcodec libx264 -r:v 25 output2.mp4`


![06-FFmpeg滤镜使用-15](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-15.png)



- 生成一个纯色mp4
`ffmpeg -re -f lavfi -i color=c=red@0.2:s=qcif:r=25 -vcodec libx264 -r:v 25 output6.mp4`
这个也不会自己停止的

![06-FFmpeg滤镜使用-17](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-17.png)


- 生成一个雪花视频, 他自己不会停止的, 命令执行后个10几秒就可以停止他
`ffmpeg -re -f lavfi -i "nullsrc=s=256x256, geq=random(1)*255:128:128" -vcodec libx264 -r:v 25 output5.mp4`
![06-FFmpeg滤镜使用-16](image/06-FFmpeg%E6%BB%A4%E9%95%9C%E4%BD%BF%E7%94%A8-16.png)


# 6.12 FFmpeg对音视频倍速处理

## 1. atempo 音频倍速处理
## 2. setpts视频倍速处理