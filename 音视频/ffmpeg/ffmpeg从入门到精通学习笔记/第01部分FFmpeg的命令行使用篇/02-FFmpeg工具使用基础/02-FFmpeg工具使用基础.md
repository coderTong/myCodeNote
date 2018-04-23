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
- 




## 2.1.1 的封装转换 
## 2.1.2 的转码参数
## 2.1.3 的基本转码原理

# 2.2 ffprobe常用命令

# 2.3 ffplay常用命令

## 2.3.1 ffplay常用参数
## 2.3.2 ffplay高级参数
## 2.3.3 ffplay的数据可视化分析
