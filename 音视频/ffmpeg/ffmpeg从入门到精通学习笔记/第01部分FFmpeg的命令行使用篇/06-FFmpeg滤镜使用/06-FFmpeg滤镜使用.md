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



# 6.4 FFmpeg视频多宫格处理






# 6.5 FFmpeg音频流滤镜操作

## 1. 双声道合并单声道
## 2. 双声道提取
## 3.双声道转双音频流
## 4.单声道转双声道
## 5. 两个音频源合并双声道
## 6. 多个音频合并为多声道



# 6.6 FFmpeg音频音量探测

## 1. 音频音量获得
## 2. 绘制音频波形




# 6.7 FFmpeg为视频加字幕

## 1.ASS字幕流写入视频流
## 2. ASS字幕写入封装容器


# 6.8 FFmpeg视频抠图合并



# 6.9 FFmpeg 3D视频处理

## 1. stereo3d 处理3D视频
## 2. 3D图像转换举例



# 6.10 FFmpeg定时视频截图

## 1. vframe参数截取一张图片

## 2. fps 滤镜定时获得图片


# 6.11 FFmpeg生成测试元数据

## 1. FFmpeg生成音频测试流
## 2. FFmpeg 生成视频测试流


# 6.12 FFmpeg对音视频倍速处理

## 1. atempo 音频倍速处理
## 2. setpts视频倍速处理