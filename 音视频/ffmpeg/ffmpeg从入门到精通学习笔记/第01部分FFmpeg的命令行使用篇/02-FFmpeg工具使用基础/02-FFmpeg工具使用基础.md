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


![02-FFmpeg工具使用基础-23](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-23.png)



![02-FFmpeg工具使用基础-24](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-24.png)
![02-FFmpeg工具使用基础-25](image/02-FFmpeg%E5%B7%A5%E5%85%B7%E4%BD%BF%E7%94%A8%E5%9F%BA%E7%A1%80-25.png)



# 2.3 ffplay常用命令

## 2.3.1 ffplay常用参数
## 2.3.2 ffplay高级参数
## 2.3.3 ffplay的数据可视化分析
