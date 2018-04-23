# 1.1 FFmpeg的定义
FFmpeg是一款`音视频编解码工具`

- FFmpeg提供了多种媒体格式的封装和解封装
- FFmpeg中的"FF"指的是`Fast Forward`
- mpeg指`Moving Picture Experts Group`动态图像专家组

# 1.2 FFmpeg的历史
2000由Fabrice Bellard 开发初级版本, 后由Michael Niedermayer接手搞
2011年3月 出现一个分支Libav

## FFmpeg源码下载地址

- git:source.ffmpeg.org/ffmpeg.git
- http://git.videolan.org/?p=ffmpeg.git
- https://github.com/FFmpeg/FFmpeg

### 目前是3.多了 


# 1.3 FFmpeg的基本组成

- 基本组成: `AVFormat`, `AVCodec`, `AVFilter`, `AVDevice`, `AVUtil`


- AVFormat: 里面实现了绝大多数媒体封装格式, 包括封装和解封装
  - 文件封装格式: MP4, FLV, KV, TS
  - 网络协议封装格式: RMTP, RTSP, MMS, HLS
    - `FFmpeg是否支持某种媒体封装格式, 取决于编译时是否包含了该格式的封装库`
- 编解码模块AVCodec
  - 实现了绝大多数编解码格式, 支持编码, 也支持解码
  - 支持自带的媒体编解码格式: MPEG4, AAC, MJPEG
  - 支持第三方编解码器: 
    -如H.264(AVC)编码,使用x264编码器.  H.265(HEVC)编码,需要x265编码器. 

- FFmpeg的滤镜模块AVFilter
  - AVFilter库提供了一个通用的音频, 视频, 字幕等滤镜处理框架.
  - 滤镜框架可以有多个输入和多个输出


![01-FFmpeg简介-01](image/01-FFmpeg%E7%AE%80%E4%BB%8B-01.png)

例子: 略

- 4.FFmpeg的视频图像转换计算模块`swscale`
  - swscale 提供了搞级别的图像转换API, 例如它允许进行图像缩放, 像素格式转换
    - 常见的将图像从1080p-->720p-->480p,  将YUV420p--->YUYV,  将YUV -->RGB

- 5. FFmpeg的音频转换计算模块`swresample`
  - 高级别的音频重采样API
  - 允许操作音频采样, 音频通道布局转换与布局调整
 


# 1.4 FFmpeg的编解码工具ffmpeg
ffmpeg是FFmpeg源码编译后生成的一个可执行程序.

./ffmpeg -i input.mp4 output.avi

./ffmpeg -i input.mp4 output.dat


# 1.5 FFmpeg的播放器ffplay

ffplay是FFmpeg源码编译后生成的一个可执行程序.
ffplay 提供了音视频显示和播放相关图像信息, 音频的波形信息


# 1.6 FFmpeg的多媒体分析器ffprobe

- ffprobe也是FFmpeg源码编译后生成的一个可执行程序.
- ffprobe是一个非常强大的多媒体分析工具, 可以从媒体文件或者媒体流中获得你想要的了解的的媒体信息, 比如音频的参数, 视频的参数, 媒体容器的参数信息等
- 可以的得到: 音频什么编码格式, 视频什么编码格式, 总时长, 复合码率.....

```

./ffprobe -show_streams output.mp4


```


# 1.7 FFmpeg编译


## Linux 和mac一样
```

git clone https://github.com/FFmpeg/FFmpeg.git




wget http://www.tortall.net/projects/yasm/releases/yasm-1.3.0.tar.gz

tar xf yasm-1.3.0.tar.gz

cd yasm-1.3.0

./configure --prefix=/application/yasm-1.3.0/

make

make install





cd /FFmpeg
./configure --yasmexe=/application/yasm-1.3.0/bin/yasm --prefix=/application/FFmpeg/

make
make install


```




# 1.8 FFmpeg编码支持与定制


```

// FFmpeg不支持的格式, 通过如下命令查看所需要的第三方外部库
./configure --help







// 仅仅支持H.264视频与AAC音频的编码
./configure --yasmexe=/application/yasm-1.3.0/bin/yasm --enable-libx264 --enable-libfdk-aac --enable-gpl --enable-nonfree

```

# 没有libfdk_aac错误(暂时不解决)

```

./configure --yasmexe=/application/yasm-1.3.0/bin/yasm --enable-libx264 --enable-libfdk-aac --enable-gpl --enable-nonfree

**ERROR: libfdk_aac not found**

If you think configure made a mistake, make sure you are using the latest

version from Git. If the latest version fails, report the problem to the

ffmpeg-user@ffmpeg.org mailing list or IRC #ffmpeg on irc.freenode.net.

Include the log file "ffbuild/config.log" produced by configure as this will help

solve the problem.


```
![01-FFmpeg简介-02](image/01-FFmpeg%E7%AE%80%E4%BB%8B-02.png)


`处于./configure --e 这种情况下连续按tab键, 出来可选的选项`


`从2016年开始, FFmpeg资深的AAC编码器质量逐步好转, 至2016年年底, libfaac已经从FFmpeg源代码中剔除.....`


# 关闭一些不需要的编码, 封装与协议等模块, 

```


./configure --yasmexe=/application/yasm-1.3.0/bin/yasm --disable-encoders --disable-decoders --disable-hwaccels --disable-muxers --disable-demuxers --disable-parsers --disable-bsfs --disable-protocols --disable-indevs --disable-devices --disable-filters

install prefix /usr/local

source path  .

C compiler gcc

C library  glibc

ARCH x86 (generic)

big-endian no

runtime cpu detection  yes

standalone assembly  yes

x86 assembler  /application/yasm-1.3.0/bin/yasm

MMX enabled  yes

MMXEXT enabled yes

3DNow! enabled yes

3DNow! extended enabled  yes

SSE enabled  yes

SSSE3 enabled  yes

AESNI enabled  yes

AVX enabled  yes

AVX2 enabled yes

AVX-512 enabled  yes

XOP enabled  yes

FMA3 enabled yes

FMA4 enabled yes

i686 features enabled  yes

CMOV is fast yes

EBX available  yes

EBP available  yes

debug symbols  yes

strip symbols  yes

optimize for size  no

optimizations  yes

static yes

shared no

postprocessing support no

network support  yes

threading support  pthreads

safe bitstream reader  yes

texi2html enabled  no

perl enabled yes

pod2man enabled  yes

makeinfo enabled no

makeinfo supports HTML no

External libraries:

iconv  xlib   zlib

External libraries providing hardware acceleration:

Libraries:

avcodec  avdevice   avfilter   avformat   avutil   swresample   swscale

Programs:

ffmpeg  ffprobe

Enabled decoders:

Enabled encoders:

Enabled hwaccels:

Enabled parsers:

Enabled demuxers:

Enabled muxers:

Enabled protocols:

Enabled filters:

aformat  anull   atrim   format   null   trim

Enabled bsfs:

null

Enabled indevs:

Enabled outdevs:

License: LGPL version 2.1 or later

**WARNING: The --yasmexe option is only provided for compatibility and will be**

** removed in the future. Use --x86asmexe instead.**

libavutil/avconfig.h is unchanged

```

# 关闭所有模块之后, 然后开启自己想要的, H.264, AAC,MP4

```

./configure --yasmexe=/application/yasm-1.3.0/bin/yasm --disable-filters --disable-encoders --disable-decoders --disable-hwaccels --disable-muxers --disable-demuxers --disable-parsers --disable-bsfs --disable-protocols --disable-indevs --disable-devices --enable-libx264 --enable-gpl --enable-nonfree --enable-muxer=mp4 --enable-aac



// 但是提示我找不到AAC
Unknown option "--enable-aac".
See ./configure --help for available options.

```


# FFmpeg 支持的编码器

`./configure --list-encoders`

![01-FFmpeg简介-03](image/01-FFmpeg%E7%AE%80%E4%BB%8B-03.png)


```

**➜** **FFmpeg**  **git:(****master****)** ./configure --list-encoders

a64multi  comfortnoise   hevc_qsv   libwebp_anim   pam   pcm_u32le   targa

a64multi5  dca   hevc_v4l2m2m   libx262   pbm   pcm_u8   text

aac  dnxhd   hevc_vaapi   libx264   pcm_alaw   pcx   tiff

aac_at  dpx   hevc_videotoolbox   libx264rgb   pcm_alaw_at   pgm   truehd

ac3  dvbsub   huffyuv   libx265   pcm_f32be   pgmyuv   tta

ac3_fixed  dvdsub   ilbc_at   libxavs   pcm_f32le   png   utvideo

adpcm_adx  dvvideo   jpeg2000   libxvid   pcm_f64be   ppm   v210

adpcm_g722  eac3   jpegls   ljpeg   pcm_f64le   prores   v308

adpcm_g726  ffv1   libaom_av1   magicyuv   pcm_mulaw   prores_aw   v408

adpcm_g726le  ffvhuff   libcodec2   mjpeg   pcm_mulaw_at   prores_ks   v410

adpcm_ima_qt  fits   libfdk_aac   mjpeg_qsv   pcm_s16be   qtrle   vc2

adpcm_ima_wav  flac   libgsm   mjpeg_vaapi   pcm_s16be_planar   r10k   vorbis

adpcm_ms  flashsv   libgsm_ms   mlp   pcm_s16le   r210   vp8_v4l2m2m

adpcm_swf  flashsv2   libilbc   movtext   pcm_s16le_planar   ra_144   vp8_vaapi

adpcm_yamaha  flv   libkvazaar   mp2   pcm_s24be   rawvideo   vp9_vaapi

alac  g723_1   libmp3lame   mp2fixed   pcm_s24daud   roq   wavpack

alac_at  gif   libopencore_amrnb   mpeg1video   pcm_s24le   roq_dpcm   webvtt

alias_pix  h261   libopenh264   mpeg2_qsv   pcm_s24le_planar   rv10   wmav1

amv  h263   libopenjpeg   mpeg2_vaapi   pcm_s32be   rv20   wmav2

apng  h263_v4l2m2m   libopus   mpeg2video   pcm_s32le   s302m   wmv1

aptx  h263p   libshine   mpeg4   pcm_s32le_planar   sbc   wmv2

aptx_hd  h264_amf   libspeex   mpeg4_v4l2m2m   pcm_s64be   sgi   wrapped_avframe

ass  h264_nvenc   libtheora   msmpeg4v2   pcm_s64le   snow   xbm

asv1  h264_omx   libtwolame   msmpeg4v3   pcm_s8   sonic   xface

asv2  h264_qsv   libvo_amrwbenc   msvideo1   pcm_s8_planar   sonic_ls   xsub

avrp  h264_v4l2m2m   libvorbis   nellymoser   pcm_u16be   srt   xwd

avui  h264_vaapi   libvpx_vp8   nvenc   pcm_u16le   ssa   y41p

ayuv  h264_videotoolbox   libvpx_vp9   nvenc_h264   pcm_u24be   subrip   yuv4

bmp  hap   libwavpack   nvenc_hevc   pcm_u24le   sunrast   zlib

cinepak  hevc_amf   libwebp   opus   pcm_u32be   svq1   zmbv

cljr  hevc_nvenc


```

# 查看FFmpeg解码器支持

`./configure --list-decoders`
![01-FFmpeg简介-04](image/01-FFmpeg%E7%AE%80%E4%BB%8B-04.png)


# 查看FFmpeg支持的封装格式


![01-FFmpeg简介-05](image/01-FFmpeg%E7%AE%80%E4%BB%8B-05.png)


```

./configure --list-muxers

```

# 查看FFmpeg支持的解封装

解封装Demuxer, 又称解复用

`./configure --list-demuxers`
![01-FFmpeg简介-06](image/01-FFmpeg%E7%AE%80%E4%BB%8B-06.png)


# 查看FFmpeg支持的通信协议

![01-FFmpeg简介-08](image/01-FFmpeg%E7%AE%80%E4%BB%8B-08.png)

`./configure --list-protocols`



# 小结