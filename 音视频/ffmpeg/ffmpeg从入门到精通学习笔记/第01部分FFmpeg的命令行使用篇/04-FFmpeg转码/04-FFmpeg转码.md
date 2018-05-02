# 第四章 FFmpeg 转码


# 4.1 FFmpeg 软编码H.264与H.265


- FLV, MP4, HLS(M3U8), MKV, TS等格式都支持 H.264...
- FFmpeg本身并不支持H.264, 是由FFMpeg第三方模块对其进行支持
  - x264 编码器, 常用
  - OpenH264 编码器, 

官方文档
`http://trac.ffmpeg.org/wiki/CompilationGuide`





## 4.1.0 从新安装FFmpeg

这一章我们要用x264 , fdkaac, ffmpeg本身是并不支持, 是以第三方模块支持的, 所以我们得重新编译一个支持的. 

FFmpeg最终我们要装在 `/application/FFmpeg`下面, 注意看`/application/FFmpeg`在下面出现的地方.


首先这里是`centos`哈, 你先登录, 然后创建一个文件夹我这里叫, `/wt`, 然后 `cd /wt`
### 1.必要工具安装   
`yum install autoconf automake bzip2 cmake freetype-devel gcc gcc-c++ git libtool make mercurial pkgconfig zlib-devel -y`

### 2下载FFmpeg源码: 
`git clone https://github.com/FFmpeg/FFmpeg.git`

下载完进入源码文件夹:
`cd FFmpeg`

### 3. 编译FFmpeg必要的汇编工具yasm
现在这步是紧接着上面来的.

下载源码:
`curl -O -L http://www.tortall.net/projects/yasm/releases/yasm-1.3.0.tar.gz`
解压
`tar xzvf yasm-1.3.0.tar.gz`
进入`yasm`编译`yasm`
`cd yasm-1.3.0`
`./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin`
`make`
`make install`



### 4. x264 要的nasm. 
没有会报错
```

Found no assembler

Minimum version is nasm-2.13

If you really want to compile without asm, configure with --disable-asm.

```

紧接着上面第三步哈
`cd /wt/FFmpeg`

`curl -O -L http://www.nasm.us/pub/nasm/releasebuilds/2.13.02/nasm-2.13.02.tar.bz2`

`tar xjvf nasm-2.13.02.tar.bz2`
`cd nasm-2.13.02`
`./autogen.sh`
`./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin`
`make`
`make install`



最后做一个软链接不然还是会报错
`ln -s /application/FFmpeg/bin/nasm /usr/sbin/nasm`
### 5. 装libx264
`cd /wt/FFmpeg`


`git clone --depth 1 http://git.videolan.org/git/x264`
`cd x264`

```

PKG_CONFIG_PATH=/application/FFmpeg/ffmpeg_build/lib/pkgconfig ./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin --enable-static


```
`make`
`make install`


### 6. 装 libfdk_aac

`cd /wt/FFmpeg`
`git clone https://github.com/mstorsjo/fdk-aac`
`cd fdk-aac`
`autoreconf -fiv`
`./configure --prefix=/application/FFmpeg/ffmpeg_build --disable-shared`
`make`
`make install`


### 7.编译FFmpeg

```

cd /wt/FFmpeg

curl -O -L https://ffmpeg.org/releases/ffmpeg-snapshot.tar.bz2
tar xjvf ffmpeg-snapshot.tar.bz2
cd ffmpeg
PATH="/application/FFmpeg/bin:$PATH" PKG_CONFIG_PATH="/application/FFmpeg/ffmpeg_build/lib/pkgconfig" ./configure \
  --prefix="/application/FFmpeg/ffmpeg_build" \
  --pkg-config-flags="--static" \
  --extra-cflags="-I/application/FFmpeg/ffmpeg_build/include" \
  --extra-ldflags="-L/application/FFmpeg/ffmpeg_build/lib" \
  --extra-libs=-lpthread \
  --extra-libs=-lm \
  --bindir="/application/FFmpeg/bin" \
  --enable-gpl \
  --enable-libfdk_aac \
  --enable-libfreetype \
  --enable-libx264 \
  --enable-libmp3lame \
  --enable-nonfree
make
make install
hash -r



```




## 4.1.1 x264编码参数简介

看看x264, 支持的像素格式
```


ffmpeg -h encoder=libx264

ffmpeg version N-90893-gcae6f80 Copyright (c) 2000-2018 the FFmpeg developers

 built with gcc 4.4.7 (GCC) 20120313 (Red Hat 4.4.7-18)

 configuration: --prefix=/root/ffmpeg_build --pkg-config-flags=--static --extra-cflags=-I/root/ffmpeg_build/include --extra-ldflags=-L/root/ffmpeg_build/lib --extra-libs=-lpthread --extra-libs=-lm --bindir=/root/bin --enable-gpl --enable-libfdk_aac --enable-libx264 --enable-nonfree

 libavutil 56\. 17.100 / 56\. 17.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 21.100 / 7\. 21.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

 libpostproc 55. 2.100 / 55. 2.100

Encoder libx264 [libx264 H.264 / AVC / MPEG-4 AVC / MPEG-4 part 10]:

 General capabilities: delay threads

 Threading capabilities: auto

 Supported pixel formats: yuv420p yuvj420p yuv422p yuvj422p yuv444p yuvj444p nv12 nv16 nv21 yuv420p10le yuv422p10le yuv444p10le nv20le

libx264 AVOptions:

 -preset <string>  E..V..... Set the encoding preset (cf. x264 --fullhelp) (default "medium")

 -tune <string>  E..V..... Tune the encoding params (cf. x264 --fullhelp)

 -profile  <string>  E..V..... Set profile restrictions (cf. x264 --fullhelp)

 -fastfirstpass  <boolean> E..V..... Use fast settings when encoding first pass (default true)

 -level  <string>  E..V..... Specify level (as defined by Annex A)

 -passlogfile  <string>  E..V..... Filename for 2 pass stats

 -wpredp <string>  E..V..... Weighted prediction for P-frames

 -a53cc  <boolean> E..V..... Use A53 Closed Captions (if available) (default true)

 -x264opts <string>  E..V..... x264 options

 -crf  <float> E..V..... Select the quality for constant quality mode (from -1 to FLT_MAX) (default -1)

 -crf_max  <float> E..V..... In CRF mode, prevents VBV from lowering quality beyond this point. (from -1 to FLT_MAX) (default -1)

 -qp <int> E..V..... Constant quantization parameter rate control method (from -1 to INT_MAX) (default -1)

 -aq-mode  <int> E..V..... AQ method (from -1 to INT_MAX) (default -1)

 none  E..V.....

 variance  E..V..... Variance AQ (complexity mask)

 autovariance  E..V..... Auto-variance AQ

 autovariance-biased E..V..... Auto-variance AQ with bias to dark scenes

 -aq-strength  <float> E..V..... AQ strength. Reduces blocking and blurring in flat and textured areas. (from -1 to FLT_MAX) (default -1)

 -psy  <boolean> E..V..... Use psychovisual optimizations. (default auto)

 -psy-rd <string>  E..V..... Strength of psychovisual optimization, in <psy-rd>:<psy-trellis> format.

 -rc-lookahead <int> E..V..... Number of frames to look ahead for frametype and ratecontrol (from -1 to INT_MAX) (default -1)

 -weightb  <boolean> E..V..... Weighted prediction for B-frames. (default auto)

 -weightp  <int> E..V..... Weighted prediction analysis method. (from -1 to INT_MAX) (default -1)

 none  E..V.....

 simple  E..V.....

 smart E..V.....

 -ssim <boolean> E..V..... Calculate and print SSIM stats. (default auto)

 -intra-refresh  <boolean> E..V..... Use Periodic Intra Refresh instead of IDR frames. (default auto)

 -bluray-compat  <boolean> E..V..... Bluray compatibility workarounds. (default auto)

 -b-bias <int> E..V..... Influences how often B-frames are used (from INT_MIN to INT_MAX) (default INT_MIN)

 -b-pyramid  <int> E..V..... Keep some B-frames as references. (from -1 to INT_MAX) (default -1)

 none  E..V.....

 strict  E..V..... Strictly hierarchical pyramid

 normal  E..V..... Non-strict (not Blu-ray compatible)

 -mixed-refs <boolean> E..V..... One reference per partition, as opposed to one reference per macroblock (default auto)

 -8x8dct <boolean> E..V..... High profile 8x8 transform. (default auto)

 -fast-pskip <boolean> E..V..... (default auto)

 -aud  <boolean> E..V..... Use access unit delimiters. (default auto)

 -mbtree <boolean> E..V..... Use macroblock tree ratecontrol. (default auto)

 -deblock  <string>  E..V..... Loop filter parameters, in <alpha:beta> form.

 -cplxblur <float> E..V..... Reduce fluctuations in QP (before curve compression) (from -1 to FLT_MAX) (default -1)

 -partitions <string>  E..V..... A comma-separated list of partitions to consider. Possible values: p8x8, p4x4, b8x8, i8x8, i4x4, none, all

 -direct-pred  <int> E..V..... Direct MV prediction mode (from -1 to INT_MAX) (default -1)

 none  E..V.....

 spatial E..V.....

 temporal  E..V.....

 auto  E..V.....

 -slice-max-size <int> E..V..... Limit the size of each slice in bytes (from -1 to INT_MAX) (default -1)

 -stats  <string>  E..V..... Filename for 2 pass stats

 -nal-hrd  <int> E..V..... Signal HRD information (requires vbv-bufsize; cbr not allowed in .mp4) (from -1 to INT_MAX) (default -1)

 none  E..V.....

 vbr E..V.....

 cbr E..V.....

 -avcintra-class <int> E..V..... AVC-Intra class 50/100/200 (from -1 to 200) (default -1)

 -me_method  <int> E..V..... Set motion estimation method (from -1 to 4) (default -1)

 dia E..V.....

 hex E..V.....

 umh E..V.....

 esa E..V.....

 tesa  E..V.....

 -motion-est <int> E..V..... Set motion estimation method (from -1 to 4) (default -1)

 dia E..V.....

 hex E..V.....

 umh E..V.....

 esa E..V.....

 tesa  E..V.....

 -forced-idr <boolean> E..V..... If forcing keyframes, force them as IDR frames. (default false)

 -coder  <int> E..V..... Coder type (from -1 to 1) (default default)

 default E..V.....

 cavlc E..V.....

 cabac E..V.....

 vlc E..V.....

 ac  E..V.....

 -b_strategy <int> E..V..... Strategy to choose between I/P/B-frames (from -1 to 2) (default -1)

 -chromaoffset <int> E..V..... QP difference between chroma and luma (from INT_MIN to INT_MAX) (default -1)

 -sc_threshold <int> E..V..... Scene change threshold (from INT_MIN to INT_MAX) (default -1)

 -noise_reduction  <int> E..V..... Noise reduction (from INT_MIN to INT_MAX) (default -1)

 -x264-params  <string>  E..V..... Override the x264 configuration using a :-separated list of key=value parameters


```


![04-FFmpeg转码-01-x264-03](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-03.png)
![04-FFmpeg转码-01-x264-04](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-04.png)

得到`yuv420p yuvj420p yuv422p yuvj422p yuv444p yuvj444p nv12 nv16 nv21 yuv420p10le yuv422p10le yuv444p10le nv20le` 这些


![04-FFmpeg转码-01-x264-01](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-01.png)
![04-FFmpeg转码-01-x264-02](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-02.png)


## 4.1.1 H.264编码举例

### 1. 编码器预设参数设置 `preset`


可以使用`x264 --full help`  查看preset设置的详细说明.
![04-FFmpeg转码-01-x264-05](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-05.png)


- ultrafast: 最快的编码方式

```

--no-8x8dct --aq-mode 0 --b-adapt 0

 --bframes 0 --no-cabac --no-deblock

 --no-mbtree --me dia --no-mixed-refs

 --partitions none --rc-lookahead 0 --ref 1

 --scenecut 0 --subme 0 --trellis 0

 --no-weightb --weightp 0


```
- superfast: 超级快的编码方式

```

--no-mbtree --me dia --no-mixed-refs

 --partitions i8x8,i4x4 --rc-lookahead 0

 --ref 1 --subme 1 --trellis 0 --weightp 1

```
- veryfast: 非常快速编码方式

```

--no-mixed-refs --rc-lookahead 10

 --ref 1 --subme 2 --trellis 0 --weightp 1


```
- faster: 稍微快速编码方式

```

--no-mixed-refs --rc-lookahead 20

 --ref 2 --subme 4 --weightp 1


```
- fast: 快速编码方式

```

--rc-lookahead 30 --ref 2 --subme 6

 --weightp 1


```
- medium: 折中编码方式, 参数全部为默认
- slow: 慢的编码方式

```

--direct auto --rc-lookahead 50 --ref 5

 --subme 8 --trellis 2


```


- slower: 更慢编码方式


```

--b-adapt 2 --direct auto --me umh

 --partitions all --rc-lookahead 60

 --ref 8 --subme 9 --trellis 2


```
- veryslow: 非常慢编码方式

```

--b-adapt 2 --bframes 8 --direct auto

 --me umh --merange 24 --partitions all

 --ref 16 --subme 10 --trellis 2

 --rc-lookahead 60


```
- placebo: 最慢的编码方式

```

--bframes 16 --b-adapt 2 --direct auto

 --slow-firstpass --no-fast-pskip

 --me tesa --merange 24 --partitions all

 --rc-lookahead 60 --ref 16 --subme 11

 --trellis 2


```



#### ultrafast: 

`ffmpeg -i qq.mp4 -vcodec libx264 -preset ultrafast -b:v 2000k ultrafast.mp4`


`frame= 1799 fps= 85 q=33.0 Lsize=  16465kB time=00:01:00.00 bitrate=2248.0kbits/s dup=30 drop=0 speed=2.85x`


![04-FFmpeg转码-01-x264-06](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-06.png)



#### medium:
` ffmpeg -i qq.mp4 -vcodec libx264 -preset medium -b:v 2000k medium.mp4`


`frame= 1799 fps= 22 q=31.0 Lsize=  16434kB time=00:01:00.00 bitrate=2243.8kbits/s dup=30 drop=0 speed=0.743x`

![04-FFmpeg转码-01-x264-07](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-07.png)


设置medium后, 转码速度为0.743, 速度下降了, 画质上升了.....




### 2. H.264 编码优化参数tune

` x264 --full help`

![04-FFmpeg转码-01-x264-tune-01](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-tune-01.png)


- zerolatency:

 --bframes 0 --force-cfr --no-mbtree

 --sync-lookahead 0 --sliced-threads

 --rc-lookahead 0


在使用FFmpeg 与x264 进行H.264直播编码并进行推流时,  只用tune参数的`zerolatency`将会提升效率., 因为其降低了因编码导致的延迟


### 3. H.264的profile 与 level 设置

![04-FFmpeg转码-01-x264-09](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-09.png)





- baseline:

 --no-8x8dct --bframes 0 --no-cabac

 --cqm flat --weightp 0

 No interlaced.

 No lossless.

 - main:

 --no-8x8dct --cqm flat

 No lossless.

 - high:

 No lossless.

 - high10:

 No lossless.

 Support for bit depth 8-10.

 - high422:

 No lossless.

 Support for bit depth 8-10.

 Support for 4:2:0/4:2:2 chroma subsampling.

 - high444:

 Support for bit depth 8-10.

 Support for 4:2:0/4:2:2/4:4:4 chroma subsampling.




这里的proflie(档次) 与 level (等级)的设置与H.264标准文档 ISO-14496-Part10 中描述的Profile , level 的信息基本相同,  x264编码器支持Baseline, Extented(仿佛`x264 --full help`,的时候没看到), Main, Hight, Hight10, High422, Hight444 共7种profile参数设置, 根据profile的不同, 编码出来的视频的很多参数也有所不同, 

![04-FFmpeg转码-01-x264-10](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-10.png)



但是level设置则与标准的ISO-14496-Part10参考中的Annex A中描述的表格完全相同. 


![04-FFmpeg转码-01-x264-11](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-11.png)
![04-FFmpeg转码-01-x264-12](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-12.png)



baseline 级别 的没有B帧, 其他都有. 生成一个baseline和一个high的看看

生成baseline

	`ffmpeg -i uc.mp4 -vcodec libx264 -profile:v baseline -level 3.1 -s 352x288 -an -y -t 10 output_baseline.ts`



生成high
`ffmpeg -i uc.mp4 -vcodec libx264 -profile:v high -level 3.1 -s 352x288 -an -y -t 10 output_high.ts`


看看两个B帧情况

```

**➜** **video** ffprobe -v quiet -show_frames -select_streams v output_baseline.ts | grep "pict_type=B"|wc -l

0

**➜** **video** ffprobe -v quiet -show_frames -select_streams v output_high.ts | grep "pict_type=B"|wc -l

204

**➜** **video**


```


说: `流媒体采用baseline编码比包含p帧的其他要可靠些. 事实上iOS采集到的视频就是只有I帧和p帧的, 之前公司的摄像头采集到的数据也是.`


### 4. 控制场景切换关键帧插入参数 sc_threshold

- `在FFmpeg中, 通过命令行的-g 参数设置以帧数间隔为GOP的长度`
- 场景切换时(一个画面进入另一个画面时) 会强行插入一个关键帧, 这时GOP的间隔将会重新开始, 重新开始就乱了, 我们不喜欢这样.............我们得阻止它, 我们用`sc_threshold`



没有使用`sc_threshold`

`ffmpeg -i uc.mp4 -c:v libx264 -g 50 -t 50 gop50.mp4`
![04-FFmpeg转码-01-x264-14](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-14.png)


使用了`sc_threshold`

`ffmpeg -i uc.mp4 -c:v libx264 -g 50 -sc_threshold 0 -t 50 -y scgop50.mp4`
![04-FFmpeg转码-01-x264-15](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-15.png)



### 5. 设置x264 内部参数 x264opts

`x264opts` 可以通过这个参数设置x264内部私有参数, 设置I帧,B帧,P帧的顺序以及规律..

- 1. 不要B帧

`ffmpeg -i uc.mp4 -c:v libx264 -x264opts "bframes=0" -g 50 -sc_threshold 0 -t 50 -y nobscgop50.mp4`
![04-FFmpeg转码-01-x264-16](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-16.png)


- 每2个P帧之间存放3个B帧:

`ffmpeg -i uc.mp4 -c:v libx264 -x264opts "bframes=3:b-adapt=0" -g 50 -sc_threshold 0 -t 50 -y 2p3bscgop50.mp4`

![04-FFmpeg转码-01-x264-17](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-17.png)

`视频中的B帧越多, 同等码率时清晰度将会越高, 但是B帧越多, 编码与解码时所带来的复杂度也就越高, 所以合理地使用B帧非常重要, 尤其是进行清晰度与码率衡量时.`


### 6.CBR 恒定码率设置参数 nal-hrd

- VBR: 可变码率, 在互联网上的视频`VBR`居多
- CBR: 恒定码率
- 指定视频的编码码率: 	`-b:v`. 这是设定的码率是`平均码率`
- 指定最大,最小码率: `-b:v`,  `maxrate`,  `minrate`, 一起设置.
- 控制编码时的波动, 设置编码时buffer的大小:  `-bufsize`, buffer的设置不是越小越好.


没有设置相关码率参数的:

![04-FFmpeg转码-01-x264-18](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-18.png)


设置

`ffmpeg -i uc.mp4 -c:v libx264 -x264opts "bframes=10:b-adapt=0" -b:v 1000k -maxrate 1000k -minrate 1000k -bufsize 50k -nal-hrd cbr -g 50 -sc_threshold 0 -t 50 -y cbr.mp4`

- 设置B帧的个数, 并且是: 每两个P帧之间包含10个B帧
- 设置视频码率为 1000kbit/s
- 设置最大码率为 1000kbit/s
- 设置最小码率为 1000kbit/s
- 设置编码的buffer 大小为50KB
- 设置H.264的编码HRD信号形式为CBR
- 设置每50帧一个GOP
- 设置场景切换不强行插入关键帧


![04-FFmpeg转码-01-x264-19](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-19.png)

![04-FFmpeg转码-01-x264-20](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-20.png)



# 4.2 FFmpeg 硬编解码

## 4.2.1 Nvidia GPU 硬编解码 ----略
## 4.2.2  Intel QSV 硬编解码----略
## 4.2.3  树莓派硬编解码----略
## 4.2.4 OS x 系统硬编解码

- 在苹果电脑的OS X系统下, 通常硬编码采用` h264_videotoolbox` , 硬解码采用`h264_vda `
- h264_videotoolbox硬编码只支持 	`VBR/ABR`, 不支持`CBR`

`./ffmpeg -h encoder=h264_videotoolbox`查看Videotoolbox支持的参数


```

 ./ffmpeg -h encoder=h264_videotoolbox

ffmpeg version N-90810-g153e920892 Copyright (c) 2000-2018 the FFmpeg developers

 built with Apple LLVM version 9.1.0 (clang-902.0.39.1)

 configuration: --yasmexe=/Users/codew/Desktop/code4-av/yasm/yasmB/yasm-1.3.0/bin/yasm --enable-ffplay --prefix=/Users/codew/Desktop/code4-av/ffmpegBinNew

 libavutil 56\. 15.100 / 56\. 15.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 19.100 / 7\. 19.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

Encoder h264_videotoolbox [VideoToolbox H.264 Encoder]:

 General capabilities: delay

 Threading capabilities: none

 Supported pixel formats: videotoolbox_vld nv12 yuv420p

h264_videotoolbox AVOptions:

 -profile  <int> E..V..... Profile (from 0 to 4) (default 0)

 baseline  E..V..... Baseline Profile

 main  E..V..... Main Profile

 high  E..V..... High Profile

 -level  <int> E..V..... Level (from 0 to 52) (default 0)

 1.3 E..V..... Level 1.3, only available with Baseline Profile

 3.0 E..V..... Level 3.0

 3.1 E..V..... Level 3.1

 3.2 E..V..... Level 3.2

 4.0 E..V..... Level 4.0

 4.1 E..V..... Level 4.1

 4.2 E..V..... Level 4.2

 5.0 E..V..... Level 5.0

 5.1 E..V..... Level 5.1

 5.2 E..V..... Level 5.2

 -coder  <int> E..V..... Entropy coding (from 0 to 2) (default 0)

 cavlc E..V..... CAVLC entropy coding

 vlc E..V..... CAVLC entropy coding

 cabac E..V..... CABAC entropy coding

 ac  E..V..... CABAC entropy coding

 -a53cc  <boolean> E..V..... Use A53 Closed Captions (if available) (default true)

 -allow_sw <boolean> E..V..... Allow software encoding (default false)

 -realtime <boolean> E..V..... Hint that encoding should happen in real-time if not faster (e.g. capturing from camera). (default false)

 -frames_before  <boolean> E..V..... Other frames will come before the frames in this session. This helps smooth concatenation issues. (default false)

 -frames_after <boolean> E..V..... Other frames will come after the frames in this session. This helps smooth concatenation issues. (default false)


```
![04-FFmpeg转码-01-x264-21](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-21.png)

![04-FFmpeg转码-01-x264-22](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-22.png)


### 查看解码支持像素的色彩格式
`./ffmpeg -h decoder=h264_vda`


`./ffmpeg -vcodec h264_vda -i dashMP4.mp4 -vcodec h264_videotoolbox -b:v 2000k outputccl.mp4`








# 4.3 FFmpeg 输出MP3
 

那啥你需要安装`libmp3lame`到FFmpeg,.......
我装好了......
去官网看吧:`http://trac.ffmpeg.org/wiki/CompilationGuide/Centos`






## 4.3.1 MP3编码参数介绍

`ffmpeg -h encoder=libmp3lame`
![04-FFmpeg转码-01-x264-23](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-23.png)


![04-FFmpeg转码-01-x264-24](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-24.png)



## 4.3.2 MP3编码质量设置

我这里的这个mp4里面的音频就是MP3, 所以相当于抠出来mp3.

抽取mp4中的MP3出来, 相当于是把mp4转成mp3,  mp4文件里面不是mp3的也会转成MP3
`ffmpeg -i mp3Video.mp4 -acodec libmp3lame mv3.mp3`




- 调整mp3的码率


`ffmpeg -i aac.mp3 -acodec libmp3lame -q:a 8 qa8.mp3`
执行完上面的命令后, 将生成的qa8.mp3的码率区间设置在70kbit/s 至 105kbit/s之间....,  参照下图 
![04-FFmpeg转码-01-x264-25](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-25.png)



比较两个mp3`ffprobe -show_format qa8.mp3`,   `ffprobe -show_format aac.mp3`, 发现两个一个128, 一个变成了46.
 

```

ffprobe -show_format qa8.mp3                      

ffprobe version N-90893-gcae6f80 Copyright (c) 2007-2018 the FFmpeg developers

 built with gcc 4.4.7 (GCC) 20120313 (Red Hat 4.4.7-18)

 configuration: --prefix=/root/ffmpeg_build --pkg-config-flags=--static --extra-cflags=-I/root/ffmpeg_build/include --extra-ldflags=-L/root/ffmpeg_build/lib --extra-libs=-lpthread --extra-libs=-lm --bindir=/root/bin --enable-gpl --enable-libfdk_aac --enable-libfreetype --enable-libmp3lame --enable-libx264 --enable-nonfree

 libavutil 56\. 17.100 / 56\. 17.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 21.100 / 7\. 21.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

 libpostproc 55. 2.100 / 55. 2.100

Input #0, mp3, from 'qa8.mp3':

 Metadata:

 major_brand  : isom

 minor_version  : 512

 compatible_brands: isomiso2mp41

 encoder  : Lavf58.13.100

 Duration: 00:00:40.07, start: 0.025057, bitrate: 46 kb/s

 Stream #0:0: Audio: mp3, 44100 Hz, stereo, fltp, 46 kb/s

 Metadata:

 encoder  : Lavc58.19

[FORMAT]

filename=qa8.mp3

nb_streams=1

nb_programs=0

format_name=mp3

format_long_name=MP2/3 (MPEG audio layer 2/3)

start_time=0.025057

duration=40.071837

size=235384

bit_rate=46992

probe_score=51

TAG:major_brand=isom

TAG:minor_version=512

TAG:compatible_brands=isomiso2mp41

TAG:encoder=Lavf58.13.100

[/FORMAT]

**➜** **video** ffprobe -show_format aac.mp3

ffprobe version N-90893-gcae6f80 Copyright (c) 2007-2018 the FFmpeg developers

 built with gcc 4.4.7 (GCC) 20120313 (Red Hat 4.4.7-18)

 configuration: --prefix=/root/ffmpeg_build --pkg-config-flags=--static --extra-cflags=-I/root/ffmpeg_build/include --extra-ldflags=-L/root/ffmpeg_build/lib --extra-libs=-lpthread --extra-libs=-lm --bindir=/root/bin --enable-gpl --enable-libfdk_aac --enable-libfreetype --enable-libmp3lame --enable-libx264 --enable-nonfree

 libavutil 56\. 17.100 / 56\. 17.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 21.100 / 7\. 21.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

 libpostproc 55. 2.100 / 55. 2.100

Input #0, mp3, from 'aac.mp3':

 Metadata:

 major_brand  : isom

 minor_version  : 512

 compatible_brands: isomiso2mp41

 encoder  : Lavf58.13.100

 Duration: 00:00:40.07, start: 0.025057, bitrate: 128 kb/s

 Stream #0:0: Audio: mp3, 44100 Hz, stereo, fltp, 128 kb/s

 Metadata:

 encoder  : Lavc58.19

[FORMAT]

filename=aac.mp3

nb_streams=1

nb_programs=0

format_name=mp3

format_long_name=MP2/3 (MPEG audio layer 2/3)

start_time=0.025057

duration=40.071837

size=641501

bit_rate=128070

probe_score=51

TAG:major_brand=isom

TAG:minor_version=512

TAG:compatible_brands=isomiso2mp41

TAG:encoder=Lavf58.13.100

[/FORMAT]


```

本来是70-105 kbit/s
书上说那个表只是作为一个参考, 并不一定准确....





### 设置平均码率CBR



`ffmpeg -i aac.mp3 -acodec libmp3lame -b:a 64k cbr2.mp3`

`ffprobe -show_format cbr2.mp3`

```

ffprobe -show_format cbr2.mp3

ffprobe version N-90893-gcae6f80 Copyright (c) 2007-2018 the FFmpeg developers

 built with gcc 4.4.7 (GCC) 20120313 (Red Hat 4.4.7-18)

 configuration: --prefix=/root/ffmpeg_build --pkg-config-flags=--static --extra-cflags=-I/root/ffmpeg_build/include --extra-ldflags=-L/root/ffmpeg_build/lib --extra-libs=-lpthread --extra-libs=-lm --bindir=/root/bin --enable-gpl --enable-libfdk_aac --enable-libfreetype --enable-libmp3lame --enable-libx264 --enable-nonfree

 libavutil 56\. 17.100 / 56\. 17.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 21.100 / 7\. 21.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

 libpostproc 55. 2.100 / 55. 2.100

Input #0, mp3, from 'cbr2.mp3':

 Metadata:

 major_brand  : isom

 minor_version  : 512

 compatible_brands: isomiso2mp41

 encoder  : Lavf58.13.100

 Duration: 00:00:40.07, start: 0.025057, bitrate: 64 kb/s

 Stream #0:0: Audio: mp3, 44100 Hz, stereo, fltp, 64 kb/s

 Metadata:

 encoder  : Lavc58.19

[FORMAT]

filename=cbr2.mp3

nb_streams=1

nb_programs=0

format_name=mp3

format_long_name=MP2/3 (MPEG audio layer 2/3)

start_time=0.025057

duration=40.071837

size=320926

bit_rate=64070

probe_score=51

TAG:major_brand=isom

TAG:minor_version=512

TAG:compatible_brands=isomiso2mp41

TAG:encoder=Lavf58.13.100

[/FORMAT]



```





## 4.3.3 平均码率编码参数ABR

ABR是VBR与CBR的混合产物, 表示`平均码率编码.`, 使用ABR参数之后,  编码速度将会比VBR高,  但是质量会比VBR的编码稍微逊色一些,  比CBR编码好一些, 在 FFmpeg中可以使用参数, 	`-ahr`来控制MP3编码为ABR编码方式....


`ffmpeg -i aac.mp3 -acodec libmp3lame -b:a 64k -abr 1 abrtest.mp3`


```

ffmpeg -i aac.mp3 -acodec libmp3lame -b:a 64k -abr 1 abrtest.mp3

ffmpeg version N-90893-gcae6f80 Copyright (c) 2000-2018 the FFmpeg developers

 built with gcc 4.4.7 (GCC) 20120313 (Red Hat 4.4.7-18)

 configuration: --prefix=/root/ffmpeg_build --pkg-config-flags=--static --extra-cflags=-I/root/ffmpeg_build/include --extra-ldflags=-L/root/ffmpeg_build/lib --extra-libs=-lpthread --extra-libs=-lm --bindir=/root/bin --enable-gpl --enable-libfdk_aac --enable-libfreetype --enable-libmp3lame --enable-libx264 --enable-nonfree

 libavutil 56\. 17.100 / 56\. 17.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 21.100 / 7\. 21.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

 libpostproc 55. 2.100 / 55. 2.100

Input #0, mp3, from 'aac.mp3':

 Metadata:

 major_brand  : isom

 minor_version  : 512

 compatible_brands: isomiso2mp41

 encoder  : Lavf58.13.100

 Duration: 00:00:40.07, start: 0.025057, bitrate: 128 kb/s

 Stream #0:0: Audio: mp3, 44100 Hz, stereo, fltp, 128 kb/s

 Metadata:

 encoder  : Lavc58.19

Stream mapping:

 Stream #0:0 -> #0:0 (mp3 (mp3float) -> mp3 (libmp3lame))

Press [q] to stop, [?] for help

Output #0, mp3, to 'abrtest.mp3':

 Metadata:

 major_brand  : isom

 minor_version  : 512

 compatible_brands: isomiso2mp41

 TSSE : Lavf58.13.100

 Stream #0:0: Audio: mp3 (libmp3lame), 44100 Hz, stereo, fltp, 64 kb/s

 Metadata:

 encoder  : Lavc58.19.100 libmp3lame

size=  315kB time=00:00:40.04 bitrate= 64.4kbits/s speed=44.1x    

video:0kB audio:314kB subtitle:0kB other streams:0kB global headers:0kB muxing overhead: 0.109355%


```



# 4.4  FFmpeg 输出AAC

## AAC的q:a 和mp3的不同,  这个q的有效范围在 0.1-2之间



## 4.4.1 FFmpeg 中的AAC编码器使用



`ffmpeg -i aacVideo.mp4 -c:a aac -b:a 160k aacVideoSound.aac`
![04-FFmpeg转码-01-x264-26](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-26.png)



使用`-q:a`设置AAC的输出质量
`ffmpeg -i aacVideoSound.aac -c:a aac -q:a 2 aacQAtest.m4a`



## 4.4.1 FDKAAC 第三方库的AAC编码codec 库


### 1. 恒定码率 (CBR)模式


- 将一个mp4中的aac扣出来, 转成一个恒定码率为64kbit/s的aac, 
- `b:a`和mp3的参数是一样的. 就是CBR的意思

`ffmpeg -i aacVideo.mp4 -c:a libfdk_aac -b:a 64k fdkaac64k.m4a`



将一个音频为mp3的mp4, 转换成恒定码率aac的mp4,  码率为384kbit/s,

`ffmpeg -i mp3Video.mp4 -c:v copy -c:a libfdk_aac -b:a 384k mp3VToCBRAACVideo.mp4`



### 2. 动态码率(VBR)模式

- 使用VBR可以有更好的音频质量
- 使用libfdk_aac进行VBR模式的AAC编码时, 可以设置4个等级


![04-FFmpeg转码-01-x264-27](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-27.png)

- 第一列为VBR的类型
- 第二列为每通道编码后的码率
- 第三列中三种AAC编码信息
  - LC: Low Complexity AAC, 这种编码相对来说体积比较大, 质量稍差
  - HE: High-Efficiency AAC, 这种编码相对来说体积较小, 质量较好
  - HEv2: Hight-Efficiency AAC version 2, 体积小, 质量优



#### AAC 编码LC, HE,  HEv2推荐参数


![04-FFmpeg转码-01-x264-28](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-28.png)
![04-FFmpeg转码-01-x264-29](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-29.png)


用fdkaac将mp3转成一个aac

	`ffmpeg -i mv3.mp3 -c:a libfdk_aac -vbr 3 output.m4a`


 







## 4.4.1 高质量AAC设置

### 1.HE-AAC 音频编码设置

	
`ffmpeg -i mv3.mp3 -c:a libfdk_aac -profile:a aac_he -b:a 64k heAAC.m4a`	
![04-FFmpeg转码-01-x264-30](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-30.png)
 


### 2.HEv2-AAC 音频编码设置

		
![04-FFmpeg转码-01-x264-31](image/04-FFmpeg%E8%BD%AC%E7%A0%81-01-x264-31.png)
`ffmpeg -i mv3.mp3 -c:a libfdk_aac -profile:a aac_he_v2 -b:a 32k HEv2-AAC.m4a`

## 4.4.1 AAC音频质量对比


### libfdk_aac音频编码质量最优
### FFmpeg内置AAC编码次于, libfdk_aac, 优于libfaac
### libfaac在FFmpeg内置AAC编码为实验品时除了libfdk_aac之外

