FFmpeg中常用的工具: `ffmpeg`, `ffprobe`, `ffplay`, 他们分别对应编解码, 内容分析, 和播放器


# 2.1 ffmpeg常用命令


## 2.1.1帮助查看

`./ffmpeg --help`


![02-FFmpeg工具使用基础-01](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-01.png)

ffmpeg常见的命令大概分为如下几个部分
- ffmpeg 信息查询部分
- 公共操作参数部分
- 文件主要操作参数部分
- 视频操作参数部分
- 音频操作参数部分
- 字母操作参数部分

`usage: ffmpeg [options] [[infile options] -i infile]... {[outfile options] outfile}...`


```

usage: ffmpeg [options] [[infile options] -i infile]... {[outfile options] outfile}...

Getting help:

 -h -- print basic options

 -h long -- print more options

 -h full -- print all options (including all format and codec specific options, very long)

 -h type=name -- print all options for the named decoder/encoder/demuxer/muxer/filter/bsf

 See man ffmpeg for detailed description of the options.

Print help / information / capabilities:

-L show license

-h topic show help

-? topic show help

-help topic  show help

--help topic show help

-version show version

-buildconf show build configuration

-formats show available formats

-muxers  show available muxers

-demuxers  show available demuxers

-devices show available devices

-codecs  show available codecs

-decoders  show available decoders

-encoders  show available encoders

-bsfs  show available bit stream filters

-protocols show available protocols

-filters show available filters

-pix_fmts  show available pixel formats

-layouts show standard channel layouts

-sample_fmts show available audio sample formats

-colors  show available color names

-sources device  list sources of the input device

-sinks device  list sinks of the output device

-hwaccels  show available HW acceleration methods


```


### ffmpeg --help long 查看高级参数
###  ./ffmpeg --help all 查看全部帮助
### ./ffmpeg -L 查看支持的license协议
###  ./ffmpeg -version

![02-FFmpeg工具使用基础-02](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-02.png)

### ./ffmpeg -formats 查看支持的视频文件格式

使用ffmpeg的时候, 有时可能会遇到无法解析的视频文件或者无法生成视频文件, 用这个命令查看

![02-FFmpeg工具使用基础-03](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-03.png)

- 第一列是多媒体文件封装格式的Demuxing支持与Muxing支持
- 第二列是多媒体文件格式
- 第三列是文件格式的详细说明


###  ./ffmpeg -codecs 查看支持的编解码格式(All)

- ./ffmpeg -encoders 查看支持的编码格式
- ./ffmpeg -decoders 查看解码


***ffmpeg -decoders***

![02-FFmpeg工具使用基础-05](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-05.png)


- 第一列包含6个字段, 
  - 第1表示此编码器为音频、视频还是字幕, 
  - 第2表示帧级别的多线程支持, 
  - 第3表示分片级别的多线程, 
  - 第4表示该编码为试验版本, 
  - 第5表示draw horiz band模式支持, 
  - 第6表示直接渲染模式支持
- 第二列是编码格式
- 第三列是编码格式的详细说明



***./ffmpeg -encoders***

![02-FFmpeg工具使用基础-06](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-06.png)

- 第一列包含6个字段, 
  - 第1表示此编码器为音频、视频还是字幕, 
  - 第2表示帧级别的多线程支持, 
  - 第3表示分片级别的多线程, 
  - 第4表示该编码为试验版本, 
  - 第5表示draw horiz band模式支持, 
  - 第6表示直接渲染模式支持
- 第二列是编码格式
- 第三列是编码格式的详细说明

### ./ffmpeg -filters 查看支持的滤镜

![02-FFmpeg工具使用基础-07](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-07.png)

- 第一列三个字段, 第一个字段是时间轴支持, 第二个字段是分片线程处理支持, 第三是命令支持
- 第二列是滤镜名
- 第三列是转换方式, 如音频转音频, 视频转视频, 创建音频, 创建视频等操作
- 第四列是滤镜作用说明


### ./ffmpeg --help full

通过`./ffmpeg --help full`, 可以查看ffmpeg支持的所有封装格式(`demuxer`, `muxer`), 编解码器(`encoders`, `decoders`) 和滤镜处理器(`filers`)

### ./ffmpeg -h xxx=xxx 具体支持的类型

#### 1.查看FLV`封装`器的参数支持 (`ffmpeg -h muxer=flv`)

![02-FFmpeg工具使用基础-08](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-08.png)

FVL的muxer的信息包含两大部分, 具体如下
  - 第一部分为FLV封装的`默认配置描述`, 如扩展名, MIME类型, 默认的视频编码格式, 默认的音频编码格式 
  - 第二部分为FLV封装时可以支持的配置参数及相关说明


#### 2.查看flv`解封装`器的参数支持: `./ffmpeg -h demuxer=flv`

![02-FFmpeg工具使用基础-09](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-09.png)

FVL的demuxer的信息包含两大部分, 具体如下
  - 第一部分为FLV解封装默认的扩展名文件
  - 第二部分为FLV解封装设置的参数及相关说明

#### 3.查看H.264(AVC)的`编码`参数支持:  ./ffmpeg -h encoder=h264

![02-FFmpeg工具使用基础-10](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-11.png)
H.264编码参数包含两大部分
  - 第一部分为H.264所支持的基本编码方式, 支持的多线程编码方式(列入帧级别多线程编码或Slice级别多线程编码), 编码器所支持的像素的色彩格式.

  - 第二部为编码的具体配置参数及相关说明.




#### 4. 查看H.264(AVC), 的解码参数支持: ./ffmpeg -h decoder=h264

![02-FFmpeg工具使用基础-12](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-12.png)

H.264解码参数也包两大部分

- 第一部分为解码H.264时可以采用的常规支持, 多线程方式支持(帧级别多线程解码或者Slice级别多线程解码)
- 第二部分为解码H.264时可以采用的解码参数及相关说明

#### 5.查看colorkey滤镜的参数支持: ./ffmpeg -h filter=colorkey

![02-FFmpeg工具使用基础-13](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-13.png)

colorkey 滤镜参数查看信息包含两大部分
- colorkey所支持的彩色格式信息, colorkey 所支持的多线程处理方法, 输入或输出支持
- colorkey所支持的参数及说明




## 2.1.1 的封装转换

封装转换在`AVFormat`模块中, 通过libavformat库进行Mux和Demux操作.
`多媒体文件的格式有很多种, 这些格式中的很多参数在Mux与Demux的操作参数中是共用的`
如下

![02-FFmpeg工具使用基础-14](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-14.png)



| Ffmpeg AVFormatContext 主要参数帮助 |
| 参数 | 类型 | 说明 |
|---|---|---|
| avioflags | 标记 | format的缓冲设置, 默认为0, 就是有缓冲 |
| direct | 无缓冲状态 |
| probesize | 整数 | 在进行媒体数据处理前获得文件内容大小, 可用在预读取文件头时提高速度, 也可以设置足够大的值来读取到足够多的音视频数据信息 |
| fflags | 标记 |  |
| fflags | flush_packets | 立即将packets数据刷新写入文件中 |
| fflags | genpts | 输出时按照正常规则产生pts |
| fflags | nofillin | 不填写可以精确计算缺失的值 |
| fflags | igndts | 忽略dts |
| fflags | discardcorrupt | 丢弃损坏的帧 |
| fflags | sortdts | 尝试以dts的顺序为准输出 |
| fflags | keepside | 不合并数据 |
| fflags | fastseek | 快速seek(定位)操作, 但是不够精确 |
| fflags | latm | 设置 RTP MP4_LATM生效 |
| fflags | nobuffer | 直接读取或写出, 不存入buffer, 用于在直播采集时降低延迟 |
| fflags | bitexact | 不写入随机或者不稳定的数据 |
| fflags | seek2any | 整数 | 支持随意位置seek, 这个seek不以keyframe为参考 |
| analyzeduration | 整数 | 指定解析媒体所需要花销的时间, 这里设置的值越高, 解析越准确, 如果在直播中为了降低延迟, 这个值可以设置得低一些 |
| codec_whitelist | 列表 | 设置可以解析的codec的白名单 |
| format_whitelist | 列表 | 设置可以解析的format的白名单 |
| output_ts_offset | 整数 | 设置输出文件的起始时间 |

上面这些都是通用的封装,解封装操作时使用的参数. 后面会说具体用



 
## 2.1.2 的转码参数

ffmpeg编解码部分的功能主要是通过模块`AVCodec `来完成的, 通过`libavcodec`库进行Encode与Decode操作
多媒体编码格式公共参数如下



![02-FFmpeg工具使用基础-15](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-15.png)

| 参数 | 类型 | 说明 |
|---|---|---|
| b | 整数 | 设置音频与视频码率, 可以认为是音视频加起来的码率, 默认为200kbit/s, 使用这个参数可以根据b:v设置视频码率, b:a设置音频码率 |
| ab | 整数 | 设置音频的码率, 默认是128kbit/s |
| g | 整数 | 设置视频GOP(关键帧间隔)大小, 默认是12帧一个GOP |
| ar | 整数 | 设置音频采样率, 默认是0 |
| ac | 整数 | 设置音频通道数, 默认为0 |
| bf | 整数 | 设置连续编码为B帧的个数, 默认为0 |
| maxrate | 整数 | 最大码率设置, 与bufsize一同使用即可, 默认为0 |
| minrate | 整数 | 最小码率设置, 配合maxrate与bufsize可以设置为CBR模式, 平时很少用,默认为0 |
| bufsize | 整数 | 设置控制码率的buffer的大小, 默认为0 |
| keyint_min | 整数 | 设置关键帧最小间隔, 默认为25 |
| sc_threshold | 整数 | 设置场景切换支持,默认0 |
| me_threshold | 整数 | 设置运动估计阈值, 默认为0 |
| mb_threshold | 整数 | 设置宏块阈值, 默认为0 |
| proflie | 整数 | 设置音视频的proflie, 默认为-99 |
| level | 整数 | 设置音视频的level, 默认为-99 |
| timecode_frame_start | 整数 | 设置GOP帧的开始时间, 需要在non-drop-frame默认情况下使用 |
| channel_layout | 整数 | 设置音频通道的布局格式 |
| threads | 整数 | 设置编解码工作的线程数 |


## 2.1.3 的基本转码原理

转码的主要原理图
![02-FFmpeg工具使用基础-16](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-16.png)

转码举例: `/application/FFmpeg/bin/ffmpeg -i pacif.mkv -vcodec mpeg4 -b:v 200k -r 15 -an output.mp4`

![02-FFmpeg工具使用基础-18](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-18.png)

![02-FFmpeg工具使用基础-17](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-17.png)

```
Stream mapping:
 Stream #0:0 -> #0:0 (h264 (native) -> mpeg4 (native))


Stream #0:5: Video: mjpeg, yuvj444p(pc, bt470bg/unknown/unknown), 1067x600, 90k tbr, 90k tbn, 90k tbc


Stream #0:0: Video: h264 (High), yuv420p(tv, bt709, progressive), 1280x536, SAR 1:1 DAR 160:67, 29.97 fps, 29.97 tbr, 1k tbn, 59.94 tbc (default)

Stream #0:1(eng): Audio: aac (LC), 48000 Hz, stereo, fltp (default)
```

- 转封装格式从MKV格式转换为Mp4
- 视频编码从h264转换成MPEG4格式
- 视频码率从原来的90kbit/s转换为200kbit/s
- 视频帧率从原来的29.97fps转换为15fps
- 转码后的文件中不包括视频(-an参数)



# 2.2 ffprobe常用命令

ffprobe 常用参数比较多, 用`ffprobe --help` 看看


![02-FFmpeg工具使用基础-19](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-19.png)

usage: ffprobe [OPTIONS] [INPUT_PILE]

日志输出的信息即是ffprobe 常用参数, 也是ffprobe的基础参数.
```
可以查看log
查看每一个音频数据包信息或者视频数据包信息
查看节目信息
查看流信息
查看每一个流有多少帧以及每一个流有多少个音视频包
查看视频像素点的格式


```

## 例子1. 查看多媒体数据包信息: ./ffprobe -show_packets output.mp4


![02-FFmpeg工具使用基础-20](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-20.png)

```

[PACKET]

codec_type=video

stream_index=0

pts=5120

pts_time=0.333333

dts=5120

dts_time=0.333333

duration=1024

duration_time=0.066667

convergence_duration=N/A

convergence_duration_time=N/A

size=493

pos=128879

flags=__

[/PACKET]

```

![02-FFmpeg工具使用基础-21](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-21.png)
| 字段 | 说明 |
|---|---|---|
| codec_type | 多媒体类型, 如视频包, 音频包等 |
| stream_index | 多媒体的stream索引 |
| pts | 多媒体的显示时间值 |
| pts_time | 根据不同格式计算过后的多媒体的显示时间 |
| dts | 多媒体解码时间值 |
| dts_time | 根据不同格式计算过后的多媒体解码时间 |
| duration | 多媒体包占用的时间值 |
| duration_time | 根据不同格式计算过后的多媒体包占用的时间值 |
| size | 多媒体包的大小 |
| pos | 多媒体包所在的文件偏移位置 |
| flags | 多媒体包标记, 如关键包与非关键包的标记 |



## 例子2, 组合参数查看包中具体数据:./ffprobe -show_data -show_packets output.mp4


![02-FFmpeg工具使用基础-22](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-22.png)



## 例子3: 查看多媒体封装格式:./ffprobe -show_format output.mp4

mp4
![02-FFmpeg工具使用基础-23](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-23.png)

format_name=mov,mp4,m4a,3gp,3g2,mj2

`mov,mp4,m4a,3gp,3g2,mj2`这几种封装格式在ffmpeg中所识别的标签基本相同


mkv
![02-FFmpeg工具使用基础-24](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-24.png)
![02-FFmpeg工具使用基础-25](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-25.png)


![02-FFmpeg工具使用基础-26](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-26.png)


| 字段 | 说明 |
|---|---|---|
| fliename | 文件名 |
| nb_streams | 媒体中包含的流的个数 |
| nb_programs | 节目数(相关概念2.3详解) |
| format_name | 使用的封装模块的名称 |
| format_long_name | 封装的完整名称 |
| start_time | 媒体文件的起始时间 |
| duration | 媒体文件的总时间长度 |
| size | 媒体文件的大小 |
| bit_rate | 媒体文件的码率 |


`帧信息`
## 例子4: 查看视频文件的帧信息./ffprobe -show_frames output.mp4
	
```

[FRAME]

media_type=video

stream_index=0

key_frame=0

pkt_pts=102036480

pkt_pts_time=6643.000000

pkt_dts=102036480

pkt_dts_time=6643.000000

best_effort_timestamp=102036480

best_effort_timestamp_time=6643.000000

pkt_duration=1029

pkt_duration_time=0.066992

pkt_pos=471040267

pkt_size=351

width=1280

height=536

pix_fmt=yuv420p

sample_aspect_ratio=1:1

pict_type=P

coded_picture_number=99645

display_picture_number=0

interlaced_frame=0

top_field_first=0

repeat_pict=0

color_range=unknown

color_space=unknown

color_primaries=unknown

color_transfer=unknown

chroma_location=left

[SIDE_DATA]

side_data_type=QP table data

[/SIDE_DATA]

[SIDE_DATA]

side_data_type=QP table properties

[/SIDE_DATA]

[/FRAME]


```


| frame 字段说明 |
| 属性 | 说明 | 值 |
|---|---|---|
| media_type | 帧的类型(视频,音频, 字幕等) | video |
| stream_index | 帧所在的索引区域 | 0 |
| key_frame | 是否为关键帧 | 0 |
| pkt_pts | frame包的pts | 102036480 |
| pkt_pts_time | frame包的 pts的时间显示 | 6643.000000 |
| pkt_dts | frame包的 dts | 102036480 |
| pkt_dts_time | frame包的 dts 的时间显示 | 6643.000000 |
| pkt_duration | frame包的 时长 | 1029 |
| pkt_duration_time | frame包的 时长时间显示 | 0.066992 |
| pkt_pos | frame包的 所在文件的偏移位置 | 471040267 |
| width | 帧显示的宽度 | 1280 |
| height | 帧显示的高度 | 536 |
| pix_fmt | 帧的图像色彩格式 | yuv420p |
| pict_type | 帧类型 | P |


`流信息`
## 例子5: 看多媒体文件中的`流信息`, 流的信息将使用STREAM标签括起来:./ffprobe -show_streams output.mp4


```

./ffprobe -show_streams output.mp4

ffprobe version N-90810-g153e920 Copyright (c) 2007-2018 the FFmpeg developers

 built with gcc 4.4.7 (GCC) 20120313 (Red Hat 4.4.7-18)

 configuration: --yasmexe=/application/yasm-1.3.0/bin/yasm --prefix=/application/FFmpeg/

 libavutil 56\. 15.100 / 56\. 15.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 19.100 / 7\. 19.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

Input #0, mov,mp4,m4a,3gp,3g2,mj2, from 'output.mp4':

 Metadata:

 major_brand  : isom

 minor_version  : 512

 compatible_brands: isomiso2mp41

 title  : Pacific.Rim.2.Uprising.2018.720p.KORSUB.HDRip.x264.AAC2.0-STUTTERSHIT

 encoder  : Lavf58.13.100

 Duration: 01:50:43.07, start: 0.000000, bitrate: 567 kb/s

 Stream #0:0(und): Video: mpeg4 (Simple Profile) (mp4v / 0x7634706D), yuv420p, 1280x536 [SAR 1:1 DAR 160:67], 567 kb/s, 15 fps, 15 tbr, 15360 tbn, 15 tbc (default)

 Metadata:

 handler_name : VideoHandler

[STREAM]

index=0

codec_name=mpeg4

codec_long_name=MPEG-4 part 2

profile=Simple Profile

codec_type=video

codec_time_base=1/15

codec_tag_string=mp4v

codec_tag=0x7634706d

width=1280

height=536

coded_width=1280

coded_height=536

has_b_frames=0

sample_aspect_ratio=1:1

display_aspect_ratio=160:67

pix_fmt=yuv420p

level=1

color_range=unknown

color_space=unknown

color_transfer=unknown

color_primaries=unknown

chroma_location=left

field_order=unknown

timecode=N/A

refs=1

quarter_sample=false

divx_packed=false

id=N/A

r_frame_rate=15/1

avg_frame_rate=15/1

time_base=1/15360

start_pts=0

start_time=0.000000

duration_ts=102037509

duration=6643.066992

bit_rate=567256

max_bit_rate=567256

bits_per_raw_sample=N/A

nb_frames=99646

nb_read_frames=N/A

nb_read_packets=N/A

DISPOSITION:default=1

DISPOSITION:dub=0

DISPOSITION:original=0

DISPOSITION:comment=0

DISPOSITION:lyrics=0

DISPOSITION:karaoke=0

DISPOSITION:forced=0

DISPOSITION:hearing_impaired=0

DISPOSITION:visual_impaired=0

DISPOSITION:clean_effects=0

DISPOSITION:attached_pic=0

DISPOSITION:timed_thumbnails=0

TAG:language=und

TAG:handler_name=VideoHandler

[/STREAM]


```




| 属性 | 说明 | 值 |
|---|---|---|
| index | 流所在的索引区域 | 0 |
| codec_name | 编码名 | mpeg4 |
| codec_long_name | 编码全名 | MPEG-4 part 2 |
| profile | 编码的profile | Simple Profile |
| level | 编码的level | 1/15 |
| has_b_frames | 包含B帧信息 | 0 |
| codec_type | 编码类型 | video |
| codec_time_base | 编码的时间戳计算基础单位 | 1/15 |
| pix_fmt | 图像显示的色彩格式 | yuv420p |
| coded_width | 图像的宽度 | 1280 |
| coded_height | 图像的高度 | 536 |
| codec_tag_string | 编码的标签数据 | mp4v |



### stream 字段其他说明

```

r_frame_rate=15/1

avg_frame_rate=15/1

time_base=1/15360

bit_rate=567256

max_bit_rate=567256

nb_frames=99646
```


| 属性 | 说明 | 值 |
|---|---|---|
| r_frame_rate | 实际帧率 | 15/1 |
| avg_frame_rate | 平均帧数 | 15/1 |
| time_base | 时间基数(用来进行timestamp 计算) | 1/15360 |
| bit_rate | 码率 | 567256 |
| max_bit_rate | 最大码率 | 567256 |
| nb_frames | 帧数 | 99646 |






## XML格式输出show_streams: ./ffprobe -of xml -show_streams output.mp4

```

./ffprobe -of xml -show_streams output.mp4

ffprobe version N-90810-g153e920 Copyright (c) 2007-2018 the FFmpeg developers

 built with gcc 4.4.7 (GCC) 20120313 (Red Hat 4.4.7-18)

 configuration: --yasmexe=/application/yasm-1.3.0/bin/yasm --prefix=/application/FFmpeg/

 libavutil 56\. 15.100 / 56\. 15.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 19.100 / 7\. 19.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

<?xml version="1.0" encoding="UTF-8"?>

<ffprobe>

Input #0, mov,mp4,m4a,3gp,3g2,mj2, from 'output.mp4':

 Metadata:

 major_brand  : isom

 minor_version  : 512

 compatible_brands: isomiso2mp41

 title  : Pacific.Rim.2.Uprising.2018.720p.KORSUB.HDRip.x264.AAC2.0-STUTTERSHIT

 encoder  : Lavf58.13.100

 Duration: 01:50:43.07, start: 0.000000, bitrate: 567 kb/s

 Stream #0:0(und): Video: mpeg4 (Simple Profile) (mp4v / 0x7634706D), yuv420p, 1280x536 [SAR 1:1 DAR 160:67], 567 kb/s, 15 fps, 15 tbr, 15360 tbn, 15 tbc (default)

 Metadata:

 handler_name : VideoHandler

 <streams>

 <stream index="0" codec_name="mpeg4" codec_long_name="MPEG-4 part 2" profile="Simple Profile" codec_type="video" codec_time_base="1/15" codec_tag_string="mp4v" codec_tag="0x7634706d" width="1280" height="536" coded_width="1280" coded_height="536" has_b_frames="0" sample_aspect_ratio="1:1" display_aspect_ratio="160:67" pix_fmt="yuv420p" level="1" chroma_location="left" refs="1" quarter_sample="false" divx_packed="false" r_frame_rate="15/1" avg_frame_rate="15/1" time_base="1/15360" start_pts="0" start_time="0.000000" duration_ts="102037509" duration="6643.066992" bit_rate="567256" max_bit_rate="567256" nb_frames="99646">

 <disposition default="1" dub="0" original="0" comment="0" lyrics="0" karaoke="0" forced="0" hearing_impaired="0" visual_impaired="0" clean_effects="0" attached_pic="0" timed_thumbnails="0"/>

 <tag key="language" value="und"/>

 <tag key="handler_name" value="VideoHandler"/>

 </stream>

 </streams>

</ffprobe>


```


## INI 格式输出: ./ffprobe -of ini -show_streams output.mp4


```

./ffprobe -of ini -show_streams output.mp4

ffprobe version N-90810-g153e920 Copyright (c) 2007-2018 the FFmpeg developers

 built with gcc 4.4.7 (GCC) 20120313 (Red Hat 4.4.7-18)

 configuration: --yasmexe=/application/yasm-1.3.0/bin/yasm --prefix=/application/FFmpeg/

 libavutil 56\. 15.100 / 56\. 15.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 19.100 / 7\. 19.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

# ffprobe output

Input #0, mov,mp4,m4a,3gp,3g2,mj2, from 'output.mp4':

 Metadata:

 major_brand  : isom

 minor_version  : 512

 compatible_brands: isomiso2mp41

 title  : Pacific.Rim.2.Uprising.2018.720p.KORSUB.HDRip.x264.AAC2.0-STUTTERSHIT

 encoder  : Lavf58.13.100

 Duration: 01:50:43.07, start: 0.000000, bitrate: 567 kb/s

 Stream #0:0(und): Video: mpeg4 (Simple Profile) (mp4v / 0x7634706D), yuv420p, 1280x536 [SAR 1:1 DAR 160:67], 567 kb/s, 15 fps, 15 tbr, 15360 tbn, 15 tbc (default)

 Metadata:

 handler_name : VideoHandler

[streams.stream.0]

index=0

codec_name=mpeg4

codec_long_name=MPEG-4 part 2

profile=Simple Profile

codec_type=video

codec_time_base=1/15

codec_tag_string=mp4v

codec_tag=0x7634706d

width=1280

height=536

coded_width=1280

coded_height=536

has_b_frames=0

sample_aspect_ratio=1\:1

display_aspect_ratio=160\:67

pix_fmt=yuv420p

level=1

color_range=unknown

color_space=unknown

color_transfer=unknown

color_primaries=unknown

chroma_location=left

field_order=unknown

timecode=N/A

refs=1

quarter_sample=false

divx_packed=false

id=N/A

r_frame_rate=15/1

avg_frame_rate=15/1

time_base=1/15360

start_pts=0

start_time=0.000000

duration_ts=102037509

duration=6643.066992

bit_rate=567256

max_bit_rate=567256

bits_per_raw_sample=N/A

nb_frames=99646

nb_read_frames=N/A

nb_read_packets=N/A

[streams.stream.0.disposition]

default=1

dub=0

original=0

comment=0

lyrics=0

karaoke=0

forced=0

hearing_impaired=0

visual_impaired=0

clean_effects=0

attached_pic=0

timed_thumbnails=0

[streams.stream.0.tags]

language=und

handler_name=VideoHandler

```

## FLAT 格式输出:./ffprobe -of flat -show_streams output.mp4

```

./ffprobe -of flat -show_streams output.mp4

ffprobe version N-90810-g153e920 Copyright (c) 2007-2018 the FFmpeg developers

 built with gcc 4.4.7 (GCC) 20120313 (Red Hat 4.4.7-18)

 configuration: --yasmexe=/application/yasm-1.3.0/bin/yasm --prefix=/application/FFmpeg/

 libavutil 56\. 15.100 / 56\. 15.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 19.100 / 7\. 19.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

Input #0, mov,mp4,m4a,3gp,3g2,mj2, from 'output.mp4':

 Metadata:

 major_brand  : isom

 minor_version  : 512

 compatible_brands: isomiso2mp41

 title  : Pacific.Rim.2.Uprising.2018.720p.KORSUB.HDRip.x264.AAC2.0-STUTTERSHIT

 encoder  : Lavf58.13.100

 Duration: 01:50:43.07, start: 0.000000, bitrate: 567 kb/s

 Stream #0:0(und): Video: mpeg4 (Simple Profile) (mp4v / 0x7634706D), yuv420p, 1280x536 [SAR 1:1 DAR 160:67], 567 kb/s, 15 fps, 15 tbr, 15360 tbn, 15 tbc (default)

 Metadata:

 handler_name : VideoHandler

streams.stream.0.index=0

streams.stream.0.codec_name="mpeg4"

streams.stream.0.codec_long_name="MPEG-4 part 2"

streams.stream.0.profile="Simple Profile"

streams.stream.0.codec_type="video"

streams.stream.0.codec_time_base="1/15"

streams.stream.0.codec_tag_string="mp4v"

streams.stream.0.codec_tag="0x7634706d"

streams.stream.0.width=1280

streams.stream.0.height=536

streams.stream.0.coded_width=1280

streams.stream.0.coded_height=536

streams.stream.0.has_b_frames=0

streams.stream.0.sample_aspect_ratio="1:1"

streams.stream.0.display_aspect_ratio="160:67"

streams.stream.0.pix_fmt="yuv420p"

streams.stream.0.level=1

streams.stream.0.color_range="unknown"

streams.stream.0.color_space="unknown"

streams.stream.0.color_transfer="unknown"

streams.stream.0.color_primaries="unknown"

streams.stream.0.chroma_location="left"

streams.stream.0.field_order="unknown"

streams.stream.0.timecode="N/A"

streams.stream.0.refs=1

streams.stream.0.quarter_sample="false"

streams.stream.0.divx_packed="false"

streams.stream.0.id="N/A"

streams.stream.0.r_frame_rate="15/1"

streams.stream.0.avg_frame_rate="15/1"

streams.stream.0.time_base="1/15360"

streams.stream.0.start_pts=0

streams.stream.0.start_time="0.000000"

streams.stream.0.duration_ts=102037509

streams.stream.0.duration="6643.066992"

streams.stream.0.bit_rate="567256"

streams.stream.0.max_bit_rate="567256"

streams.stream.0.bits_per_raw_sample="N/A"

streams.stream.0.nb_frames="99646"

streams.stream.0.nb_read_frames="N/A"

streams.stream.0.nb_read_packets="N/A"

streams.stream.0.disposition.default=1

streams.stream.0.disposition.dub=0

streams.stream.0.disposition.original=0

streams.stream.0.disposition.comment=0

streams.stream.0.disposition.lyrics=0

streams.stream.0.disposition.karaoke=0

streams.stream.0.disposition.forced=0

streams.stream.0.disposition.hearing_impaired=0

streams.stream.0.disposition.visual_impaired=0

streams.stream.0.disposition.clean_effects=0

streams.stream.0.disposition.attached_pic=0

streams.stream.0.disposition.timed_thumbnails=0

streams.stream.0.tags.language="und"

streams.stream.0.tags.handler_name="VideoHandler"


```
## JSON格式输出: ./ffprobe -of json -show_streams output.mp4


```

 ./ffprobe -of json -show_streams output.mp4

ffprobe version N-90810-g153e920 Copyright (c) 2007-2018 the FFmpeg developers

 built with gcc 4.4.7 (GCC) 20120313 (Red Hat 4.4.7-18)

 configuration: --yasmexe=/application/yasm-1.3.0/bin/yasm --prefix=/application/FFmpeg/

 libavutil 56\. 15.100 / 56\. 15.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 19.100 / 7\. 19.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

{

Input #0, mov,mp4,m4a,3gp,3g2,mj2, from 'output.mp4':

 Metadata:

 major_brand  : isom

 minor_version  : 512

 compatible_brands: isomiso2mp41

 title  : Pacific.Rim.2.Uprising.2018.720p.KORSUB.HDRip.x264.AAC2.0-STUTTERSHIT

 encoder  : Lavf58.13.100

 Duration: 01:50:43.07, start: 0.000000, bitrate: 567 kb/s

 Stream #0:0(und): Video: mpeg4 (Simple Profile) (mp4v / 0x7634706D), yuv420p, 1280x536 [SAR 1:1 DAR 160:67], 567 kb/s, 15 fps, 15 tbr, 15360 tbn, 15 tbc (default)

 Metadata:

 handler_name : VideoHandler

 "streams": [

 {

 "index": 0,

 "codec_name": "mpeg4",

 "codec_long_name": "MPEG-4 part 2",

 "profile": "Simple Profile",

 "codec_type": "video",

 "codec_time_base": "1/15",

 "codec_tag_string": "mp4v",

 "codec_tag": "0x7634706d",

 "width": 1280,

 "height": 536,

 "coded_width": 1280,

 "coded_height": 536,

 "has_b_frames": 0,

 "sample_aspect_ratio": "1:1",

 "display_aspect_ratio": "160:67",

 "pix_fmt": "yuv420p",

 "level": 1,

 "chroma_location": "left",

 "refs": 1,

 "quarter_sample": "false",

 "divx_packed": "false",

 "r_frame_rate": "15/1",

 "avg_frame_rate": "15/1",

 "time_base": "1/15360",

 "start_pts": 0,

 "start_time": "0.000000",

 "duration_ts": 102037509,

 "duration": "6643.066992",

 "bit_rate": "567256",

 "max_bit_rate": "567256",

 "nb_frames": "99646",

 "disposition": {

 "default": 1,

 "dub": 0,

 "original": 0,

 "comment": 0,

 "lyrics": 0,

 "karaoke": 0,

 "forced": 0,

 "hearing_impaired": 0,

 "visual_impaired": 0,

 "clean_effects": 0,

 "attached_pic": 0,

 "timed_thumbnails": 0

 },

 "tags": {

 "language": "und",

 "handler_name": "VideoHandler"

 }

 }

 ]

}


```
# CSV格式输出

```

 ./ffprobe -of csv -show_streams output.mp4

ffprobe version N-90810-g153e920 Copyright (c) 2007-2018 the FFmpeg developers

 built with gcc 4.4.7 (GCC) 20120313 (Red Hat 4.4.7-18)

 configuration: --yasmexe=/application/yasm-1.3.0/bin/yasm --prefix=/application/FFmpeg/

 libavutil 56\. 15.100 / 56\. 15.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 19.100 / 7\. 19.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

Input #0, mov,mp4,m4a,3gp,3g2,mj2, from 'output.mp4':

 Metadata:

 major_brand  : isom

 minor_version  : 512

 compatible_brands: isomiso2mp41

 title  : Pacific.Rim.2.Uprising.2018.720p.KORSUB.HDRip.x264.AAC2.0-STUTTERSHIT

 encoder  : Lavf58.13.100

 Duration: 01:50:43.07, start: 0.000000, bitrate: 567 kb/s

 Stream #0:0(und): Video: mpeg4 (Simple Profile) (mp4v / 0x7634706D), yuv420p, 1280x536 [SAR 1:1 DAR 160:67], 567 kb/s, 15 fps, 15 tbr, 15360 tbn, 15 tbc (default)

 Metadata:

 handler_name : VideoHandler

stream,0,mpeg4,MPEG-4 part 2,Simple Profile,video,1/15,mp4v,0x7634706d,1280,536,1280,536,0,1:1,160:67,yuv420p,1,unknown,unknown,unknown,unknown,left,unknown,N/A,1,false,false,N/A,15/1,15/1,1/15360,0,0.000000,102037509,6643.066992,567256,567256,N/A,99646,N/A,N/A,1,0,0,0,0,0,0,0,0,0,0,0,und,VideoHandler


```


## 使用select_streams配合show_frames, 查看视频(v), 音频(a), 字幕(s), 的信息
`./ffprobe -show_frames -select_streams v -of xml output.mp4`

输出的frame 信息全部为视频相关的信息


```


**➜** **bin** ./ffprobe -show_frames -select_streams v -of xml output.mp4

ffprobe version N-90810-g153e920 Copyright (c) 2007-2018 the FFmpeg developers

 built with gcc 4.4.7 (GCC) 20120313 (Red Hat 4.4.7-18)

 configuration: --yasmexe=/application/yasm-1.3.0/bin/yasm --prefix=/application/FFmpeg/

 libavutil 56\. 15.100 / 56\. 15.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 19.100 / 7\. 19.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

<?xml version="1.0" encoding="UTF-8"?>

<ffprobe>

Input #0, mov,mp4,m4a,3gp,3g2,mj2, from 'output.mp4':

 Metadata:

 major_brand  : isom

 minor_version  : 512

 compatible_brands: isomiso2mp41

 title  : Pacific.Rim.2.Uprising.2018.720p.KORSUB.HDRip.x264.AAC2.0-STUTTERSHIT

 encoder  : Lavf58.13.100

 Duration: 01:50:43.07, start: 0.000000, bitrate: 567 kb/s

 Stream #0:0(und): Video: mpeg4 (Simple Profile) (mp4v / 0x7634706D), yuv420p, 1280x536 [SAR 1:1 DAR 160:67], 567 kb/s, 15 fps, 15 tbr, 15360 tbn, 15 tbc (default)

 Metadata:

 handler_name : VideoHandler

 <frames>

 <frame media_type="video" stream_index="0" key_frame="1" pkt_pts="0" pkt_pts_time="0.000000" pkt_dts="0" pkt_dts_time="0.000000" best_effort_timestamp="0" best_effort_timestamp_time="0.000000" pkt_duration="1024" pkt_duration_time="0.066667" pkt_pos="44" pkt_size="65630" width="1280" height="536" pix_fmt="yuv420p" sample_aspect_ratio="1:1" pict_type="I" coded_picture_number="0" display_picture_number="0" interlaced_frame="0" top_field_first="0" repeat_pict="0" chroma_location="left">

 <side_data_list>

 <side_data side_data_type="QP table data"/>

 <side_data side_data_type="QP table properties"/>

 </side_data_list>

 </frame>

 <frame media_type="video" stream_index="0" key_frame="0" pkt_pts="1024" pkt_pts_time="0.066667" pkt_dts="1024" pkt_dts_time="0.066667" best_effort_timestamp="1024" best_effort_timestamp_time="0.066667" pkt_duration="1024" pkt_duration_time="0.066667" pkt_pos="65674" pkt_size="56482" width="1280" height="536" pix_fmt="yuv420p" sample_aspect_ratio="1:1" pict_type="P" coded_picture_number="1" display_picture_number="0" interlaced_frame="0" top_field_first="0" repeat_pict="0" chroma_location="left">

 <side_data_list>

 <side_data side_data_type="QP table data"/>

 <side_data side_data_type="QP table properties"/>

 </side_data_list>

 </frame>


```

# 2.3 ffplay常用命令

一般编译是没有ffplay, 需要安装SDL

## 1.安装SDL MAC

```


cd /FFmpeg(源码文件夹)
vim configure // 看看ffplay_deps是SDL几, 然后下几, 我这里是2, 所以我下2.0.8




https://www.libsdl.org/

下载:https://www.libsdl.org/release/SDL2-2.0.8.zip


./configure

make

make install


```



## 2.编译ffmpeg生成ffplay

```
cd /FFmpeg(源码文件夹)

修改config.h中的宏定义#define CONFIG_FFPLAY 0，将值改为1.

vim config.h

./configure --yasmexe=/Users/codew/Desktop/code4-av/yasm/yasmB/yasm-1.3.0/bin/yasm --enable-ffplay --prefix=/Users/codew/Desktop/code4-av/ffmpegBinNew

make 

make install


```



## 2.3.1 ffplay常用参数


### 1. 查看帮助

![02-FFmpeg工具使用基础-27](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-27.png)


![02-FFmpeg工具使用基础-28](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-28.png)


| 参数 | 说明 |
|---|---|---|
| x | 强制设置视频显示窗口的宽度 |
| y | 强制设置视频显示窗口的高度 |
| s | 设置视频显示的宽度 |
| fs | 强制全屏显示 |
| an | 屏蔽音频 |
| vn | 屏蔽视频 |
| sn | 屏蔽字幕 |
| ss | 根据设置的秒进行定位拖动 |
| t | 设置播放视频/音频的长度 |
| bytes | 设置定位拖动的策略,0不可拖动,1可拖动,-1自动 |
| nodisp | 关闭图形化显示窗口 |
| f | 强制使用设置的格式进行解析 |
| window_title | 设置显示窗口的标题 |
| af | 设置音频的滤镜 |
| codec | 强制使用设置的codec进行编码 |
| autorotate | 自动旋转视频 |


### 2.第30秒钟开始播放,播放10秒钟: ./ffplay -ss 30 -t 10 12.avi 

### 3.设置播放窗口标题: ./ffplay -ss 30 -t 5 -window_title "Hellow FFplay" 12.avi

### 4. 打开网络直播流: ./ffplay -window_title "网络直播流测试" rtmp://up.v.test.com/live/stream


## 2.3.2 ffplay高级参数

| 参数 | 说明 |
|---|---|---|
| ast | 设置将要播放的音频流 |
| vst | 设置将要播放的视频流 |
| sst | 设置将要播放的字幕流 |
| stats | 输出多媒体播放状态 |
| fast | 非标准化规范的多媒体兼容优化 |
| sync | 音视频同步设置可根据音频时间, 视频时间或者外部扩展时间进行参考 |
| autoexit | 多媒体播放完毕之后自动退出ffplay, ffplay默认播放完毕之后是不退出的 |
| exitonkeydown | 当有按键按下事件产生时退出ffplay |
| exitonmousedown | 当有鼠标按键事件产生时退出ffplay |
| loop | 设置多媒体文件循环播放次数 |
| framedrop | 当CPU资源占用过高时, 自动丢帧 |
| infbuf | 设置无极限的播放器buffer, 这个选项常见于实时流媒体播放场景 |
| vf | 视频滤镜设置 |
| acodec | 强制使用设置的音频解码器 |
| vcodec | 强制使用设置的视频解码器 |
| scodec | 强制使用设置的字幕解码器 |

### 1. 从20秒开始播放, 放10秒, 完事后关闭退出ffplay, 窗口标题"Hellow Word": time ./ffplay -window_title "Hellow World" -ss 20 -t 10 -autoexit 1.rmvb


### 2.强制用h264解码器去解码rmvb报错: ./ffplay -vcodec h264 1.rmvb

```

./ffplay -vcodec h264 1.rmvb 

ffplay version N-90810-g153e920892 Copyright (c) 2003-2018 the FFmpeg developers

 built with Apple LLVM version 9.1.0 (clang-902.0.39.1)

 configuration: --yasmexe=/Users/codew/Desktop/code4-av/yasm/yasmB/yasm-1.3.0/bin/yasm --enable-ffplay --prefix=/Users/codew/Desktop/code4-av/ffmpegBinNew

 libavutil 56\. 15.100 / 56\. 15.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 19.100 / 7\. 19.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

[rm @ 0x7f877b83ce00] Invalid stream index 2 for index at pos 143426190

Input #0, rm, from '1.rmvb':

 Metadata:

 Audiences  : Easy RealMedia Tool's Audience;

 audioMode  : music

 Creation Date  : 1/1/2006 22:09:26

 Description  : This File is Created by Easy RealMedia Tools@!

 Email  : rick@redcheek.net

 Generated By : Easy RealMedia Tools V1.8x

 HomeWeb  : http://redcheek.net

 Keywords :

 Modification Date: 1/1/2006 22:09:26

 videoMode  : normal

 title  : ?ټҽ?̳_??????Ʒ????01_?󽭶?ȥ???????졪[2006.02.12]

 author : ???????л???xiaolu ??????YYTvO

 copyright  : CCTV10 (C) 2006

 Duration: 00:42:30.48, start: 0.000000, bitrate: 449 kb/s

 Stream #0:0: Audio: cook (cook / 0x6B6F6F63), 44100 Hz, stereo, fltp, 44 kb/s

 Stream #0:1: Video: rv40 (RV40 / 0x30345652), yuv420p, 480x360, 400 kb/s, 24 fps, 24 tbr, 1k tbn, 1k tbc

2018-04-24 23:46:28.375 ffplay[42585:669179] *** Assertion failure in -[SDLWindow setTitle:], /BuildRoot/Library/Caches/com.apple.xbs/Sources/AppKit/AppKit-1561.40.112/AppKit.subproj/NSWindow.m:2643

2018-04-24 23:46:28.382 ffplay[42585:669179] *** Terminating app due to uncaught exception 'NSInternalInconsistencyException', reason: 'Invalid parameter not satisfying: aString != nil'

*** First throw call stack:

(

0  CoreFoundation 0x00007fff44cee32b __exceptionPreprocess + 171

1  libobjc.A.dylib  0x00007fff6c368c76 objc_exception_throw + 48

2  CoreFoundation 0x00007fff44cf40c2 +[NSException raise:format:arguments:] + 98

3  Foundation 0x00007fff46e10340 -[NSAssertionHandler handleFailureInMethod:object:file:lineNumber:description:] + 193

4  AppKit 0x00007fff4228363b -[NSWindow setTitle:] + 199

5  libSDL2-2.0.0.dylib  0x0000000107f19a2e Cocoa_SetWindowTitle + 110

6  ffplay 0x00000001062fea8e main + 33934

)

libc++abi.dylib: terminating with uncaught exception of type NSException

[1] 42585 abort ./ffplay -vcodec h264 1.rmvb

```



### 3.多个Program情况
当视频流中出现多个Program时, 播放Program与常规的播放方式有所不同, 需要指定对应的流, 可以通过vst, ast, sst参数来指定, 

首先查看streams信息
```



./ffprobe -show_streams Titanic.ts

ffprobe version N-90810-g153e920892 Copyright (c) 2007-2018 the FFmpeg developers

 built with Apple LLVM version 9.1.0 (clang-902.0.39.1)

 configuration: --yasmexe=/Users/codew/Desktop/code4-av/yasm/yasmB/yasm-1.3.0/bin/yasm --enable-ffplay --prefix=/Users/codew/Desktop/code4-av/ffmpegBinNew

 libavutil 56\. 15.100 / 56\. 15.100

 libavcodec  58\. 19.100 / 58\. 19.100

 libavformat 58\. 13.100 / 58\. 13.100

 libavdevice 58. 4.100 / 58. 4.100

 libavfilter  7\. 19.100 / 7\. 19.100

 libswscale 5. 2.100 / 5. 2.100

 libswresample  3. 2.100 / 3. 2.100

Input #0, mpegts, from 'Titanic.ts':

 Duration: 00:00:48.03, start: 1.463400, bitrate: 589 kb/s

 Program 1

 Metadata:

 service_name : Service01

 service_provider: FFmpeg

 Stream #0:0[0x100]: Video: h264 (High) ([27][0][0][0] / 0x001B), yuv420p(progressive), 640x272 [SAR 1:1 DAR 40:17], 23.98 fps, 23.98 tbr, 90k tbn, 47.95 tbc

 Stream #0:1[0x101]: Audio: mp3 ([3][0][0][0] / 0x0003), 48000 Hz, stereo, fltp, 128 kb/s




```
Stream #0:0[0x100]: Video:  ===========-vst
 Stream #0:1[0x101]: Audio: =============-ast
如果有多个Program可以选其中一个播放

`./ffplay -vst 0 -ast 1 Titanic.ts`


### 4. 做一个字幕玩玩

字幕

```

1
00:00:01.000 --> 00:00:30.000
test 1,test 1

2
00:00:30.001 --> 00:00:60.000
Hello test 2,test 2

3
00:01:01.000 --> 00:01:10.000
Hi ni hao,test 3

2
00:01:11.000 --> 00:01:30.000
chi le mei


```

前提我们要有subtitles这滤镜
` ./ffplay -window_title "Hellow FFplay" -vf "subtitles=test.srt" 12.avi`


## 2.3.3 ffplay的数据可视化分析


### 1. 查看音频波形: ./ffplay -showmode 1 107.mp3


![02-FFmpeg工具使用基础-29](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-29.png)



### 2.体验解码器是如何解码每个宏块: ./ffplay -debug vis_mb_type -window_title "ss" -ss 20 -t 10 -autoexit 0357.mp4




### 3.查看B帧P帧信息: ./ffplay -vismv pf 0357.mp4

### 4.运动矢量: ./ffplay -flags2 +export_mvs -ss 40 0357.mp4 -vf codecview=mv=pf+bf+bb


![02-FFmpeg工具使用基础-30](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-30.png)



