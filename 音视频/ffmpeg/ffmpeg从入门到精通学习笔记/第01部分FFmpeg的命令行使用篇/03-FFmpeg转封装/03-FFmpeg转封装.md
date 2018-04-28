# 03-FFmpeg转封装

# 3.1 音视频文件转MP4格式

## 3.1.1  Mp4格式标准介绍

mp4格式标准为`ISO-14496 Part 12`, `ISO-14496 Part 14`

### 1. MP4几个概念
1. `MP4文件由许多Box和FullBox组成`
这幅图并不准确, 只是为了说明Mp4是由他两组成的.....


![03-FFmpeg转封装-01-Mp4](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-01-Mp4.png)


2. `每个Box由Header和Data两部分组成`

![03-FFmpeg转封装-02-Box](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-02-Box.png)


3. `FullBox是Box的扩展, 其在Box结构的基础上, 在Header中增加了8位version标志和24位的flags标志`

![03-FFmpeg转封装-02-FullBox](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-02-FullBox.png)


 4. `Header 包含了整个Box的长度的大小(size) 和类型(type), 当size等于0时, 代表这个Box是文件的最后一个Box.  当size等于1时, 说明Box长度需要更多的位来描述, 在后面会定义一个64位的largesize用来描述Box的长度. 当Type为uuid时, 说明这个Box中的数据是用户自定义扩展类型`


![03-FFmpeg转封装-02-Header](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-02-Header.png)




5.`Data为Box的实际数据, 可以是纯数据, 也可以是更多的子Box`

![03-FFmpeg转封装-05-Data](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-05-Data.png)



6. 当一个Box中Data是一系列的子Box时, 这个Box又可以称为Container(容器)Box

![03-FFmpeg转封装-06-ContainerBox](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-06-ContainerBox.png)



### 2. Mp4中Box的组成排列表

![03-FFmpeg转封装-07-t01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-07-t01.png)
![03-FFmpeg转封装-07-t02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-07-t02.png)
![03-FFmpeg转封装-07-t03](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-07-t03.png)
![03-FFmpeg转封装-07-t04](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-07-t04.png)
![03-FFmpeg转封装-07-t05](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-07-t05.png)


mp4标准中描述的moov和mdat的存放位置前后并没有进行强制要求, 哪个放到前面都并不一定.


互联网的视频希望快速点播, 就把moov存放在mdat的前面. 反之的话就得把整个文件下载完了才能播放..

![03-FFmpeg转封装-07-t06](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-07-t06.png)
![03-FFmpeg转封装-07-t07](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-07-t07.png)


### 3.解析mp4文件需要一些关键信息

#### 1.moov 容器

- 定义了一个MP4文件中的数据信息
- 类型是moov
- 是一个容器Atom, 必须包含下面三种中的一个
  - mvhd 标签, Movie Header Atom, 存放未压缩过的影片信息的头容器
  - cmov 标签, Compressed Movie Atom, 压缩过的电影信息容器, 此容器`不常用`
  - rmra 标签, Refernce Movie Atom, 参考电影信息容器, `不常用`


![03-FFmpeg转封装-08-moov](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-08-moov.png)


- 如图我打开的这个mp4是一个moov在最后的mp4文件, 所以要想看这个文件,就得下载完整mp4文件才能看
- 第二我这个MP4的moov = size(4字节) + type(4字节) + subAtoms(1018字节=mvhd(108) + trak(910)) = 1026, 如下
![03-FFmpeg转封装-08-moov02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-08-moov02.png)

- 


#### 2.解析mvhd 子容器 (电影文件头.....)

![03-FFmpeg转封装-09-mvhd](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-09-mvhd.png)

![03-FFmpeg转封装-09-mvhd02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-09-mvhd02.png)


![03-FFmpeg转封装-09-mvhd03](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-09-mvhd03.png)



#### 3.解析trak子容器
trak容器中定义了媒体文件中的一个track(轨)的信息, 什么轨? 就是音轨呀, 视频轨呀....

看这个图, 可以看到这个moov只有一个track(视频轨), 因为这个mp4是我自己生成的我把音频去掉了, 它是一个没有声音的mp4 
![03-FFmpeg转封装-08-moov02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-08-moov02.png)

一般的moov都有两个track, 音频+视频嘛....如下

![03-FFmpeg转封装-09-mvhd04](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-09-mvhd04.png)
![03-FFmpeg转封装-09-mvhd05](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-09-mvhd05.png)

所以说一个多媒体文件可以有多个trak容器, 1个, 2个, 其他个?(暂时没见过)

我们往下看看, 看看trak容器里面装了些啥.....
trak1, `有两个trak, 里面有tkhd, edts, mdia`
![03-FFmpeg转封装-10-trak01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-10-trak01.png)
trak2, `有一个trak, 里面有tkhd, tapt, edts, mdia`
![03-FFmpeg转封装-10-trak01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-10-trak02.png)
trak3, `有两个trak, 里面有tkhd, mdia`
![03-FFmpeg转封装-10-trak01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-10-trak03.png)
基本上都是有tkhd,mdia这两家伙的
先说说使用trak容器的目的:
- 包含媒体数据的引用和描述
- 包含modifier track信息
- 流媒体协议的打包信息(hint  track), hint track可以引用或者复制对应的媒体采样数据

`hint  track` 和 `modifier track` 必须保证完整性...同时要与至少一个`mdia track`一起存在

一个`trak`容器中要求必须要有一个Track Header Atom(tkhd) 和一个 `Media Atom(mdia)`其他都是可选的.....


####  4. 解析tkhd
看了下一个tkhd基本上都是由20个属性组成的
![03-FFmpeg转封装-11-tkhd01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-11-tkhd01.png)

下面是书上对其中17项的解释, 作图实在太浪费时间了.......
![03-FFmpeg转封装-11-tkhd02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-11-tkhd02.png)
![03-FFmpeg转封装-11-tkhd03](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-11-tkhd03.png)


怎么判断一个	`trak`是音轨还是视频轨,?
- 看`tkhd`的Volume(音量)是否有值,不是0是音频
- 看宽高是否为0, 不为0为视频

那个不管是视频的tkhd还是音频的, 他们大小都一样, 都是`92`字节.



####  5.解析mdia

![03-FFmpeg转封装-12-mdia01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-12-mdia01.png)

可以看到`mdia`包含三个子容器
- 一个媒体头:Media Header Atom (mdhd)
- 一个句柄参考: Handler Reference (hdlr) 
- 一个媒体信息 Media Infomation (minf) 或者用户数据User Data Atom(udta)



####  6. 解析mdhd容器

![03-FFmpeg转封装-13-mdhd01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-13-mdhd01.png)

![03-FFmpeg转封装-13-mdhd02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-13-mdhd02.png)

说:解析版本为1的和解析版本为0的是不一样的...

####  7. 解析hdlr容器

![03-FFmpeg转封装-14-hdlr01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-14-hdlr01.png)


![03-FFmpeg转封装-14-hdlr02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-14-hdlr02.png)

####  8.解析minf容器

![03-FFmpeg转封装-15-minf01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-15-minf01.png)

minf里面包含了音视频采样等信息, minf容器中的信息将作为音视频数据的映射存在. 内容如下:
- 视频信息头: Video Media Information Header (vmhd 子容器)
- 音频信息头: Sound Media Information Header (sound 子容器)
- 数据信息: Data Information (dinf 子容器)
- 采样表: Sample Table (stbl 子容器)



####  9.解析vmhd容器


![03-FFmpeg转封装-16-vmhd01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-16-vmhd01.png)
![03-FFmpeg转封装-16-vmhd02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-16-vmhd02.png)


####  10.解析smhd容器
音频Header


![03-FFmpeg转封装-17-smhd01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-17-smhd01.png)
![03-FFmpeg转封装-17-smhd02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-17-smhd02.png)

- Balance(均衡): 音频的均衡是用来控制计算机的两个扬声器的声音混合效果, 一般是0 



####  11. 解析dinf容器

![03-FFmpeg转封装-18-dinf01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-18-dinf01.png)

![03-FFmpeg转封装-18-dinf02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-18-dinf02.png)


####  12. 解析stbl容器


![03-FFmpeg转封装-19-stbl01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-19-stbl01.png)
一般只有:`stsd`, `stts`, `stsz`, `stsc`, `stco`
有的有: `stss`,`stsh`

stbl容器又称为	`采样参数列表`,的容器(Sample Table Atom), 该容器包含转换媒体时间到实际的Sample的信息, 也说明了解释Sample的信息, 例如, 视频数据是否需要解压缩, 解压缩算法是什么等信息. 
- 采样描述容器: Sample Description Atom (stsd)
- 采样时间容器: Time To Sample Atom(stts)
- 采样同步容器: Sync Sample Atom (stss)
- Chunk采样容器: Sample to Chunk Atom (stsc)
- 采样大小容器: Sample size Atom (stsz)
- Chunk偏移容器: Chunk Offset Atom(stco)
- Shadow同容器: Shadow Sync Atom(stsh)




`stbl` 包含`track`中`media Sample` 的所有`时间`和`数据索引`, 利用这个容器中的Sample信息, 就可以定位Sample的`媒体时间`, 决定其`类型`,`大小`, 以及如何在其他容器中找到紧邻的Sample. 如果`Sample Table Atom`所在的track没有引用任何数据. 那么它就不是一个有用的Media track, 不需要包含任何子Atom


如果`Sample Table Atom`所在的track引用了数据, 那么其必须包含以下子Atom.
- 采样描述容器: Sample Description Atom (stsd)
- 采样大小容器: Sample size Atom (stsz)
- Chunk采样容器: Sample to Chunk Atom (stsc)
- Chunk偏移容器: Chunk Offset Atom(stco)

stbl是必不可少的一个Atom, 而且必须包含至少一个条目, 因为它包含了数据引用Atom检索Media Sample的目录信息. 没有Sample Description, 就不可能计算出media Sample 存储的位置. Sync Sample Atom 是可选的, 如果没有, 则表明所有的Sample 都是sync Sample.

####  13.解析edts容器


![03-FFmpeg转封装-20-edts01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-20-edts01.png)

edts 容器定义了`创建`Movie媒体文件中一个track的一部分媒体, 所有的edts数据都在一个表里, 包括每一部分的时间偏移量和长度. 如果没有该表, 那么这个track就会立即开始播放, 一个`空的`edts数据`用来定位`到track的起始时间偏移位置.

## 3.1.2 MP4分析工具
- 1.Elecard StreamEye 
- 2. mp4box 
- 3. mp4info
- 4. synalyze it! po


## 3.1.3 MP4在FFMpeg中的Demuxer

查看mp4的Demuxer: `./ffmpeg -h demuxer=mp4 ./mp4/33.mp4`

![03-FFmpeg转封装-21-demuxer01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-21-demuxer01.png)

![03-FFmpeg转封装-21](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-21.png)

![03-FFmpeg转封装-22](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-22.png)




### 1. faststart  参数使用案例,

 先来一个moov移到mdat后面生成的mp4
`./ffmpeg -i cuc_ieschool.flv -c copy -f mp4 ff.mp`

![03-FFmpeg转封装-23-faststart01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-23-faststart01.png)

在根据这个生成一个在前面的

`./ffmpeg -i cuc_ieschool.flv -c copy -f mp4 -movflags faststart fastmoov.mp4`


![03-FFmpeg转封装-23-faststart02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-23-faststart02.png)


### 2. dash 参数使用案例

`./ffmpeg -i cuc_ieschool.flv -c copy -f mp4 -movflags dash dashMP4.mp4`


## 3.1.4  MP4在FFMpeg中的muxer



# 3.2 音视频文件转FLV

## 3.2.1  FLV格式标准介绍


### 1. FLV文件头格式解析
FLV文件格式分为两部分: 
- 一部分为FLV`文件头`, 
- 另一部分为FLV`文件内容`


![03-FFmpeg转封装-24-flv01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv01.png)
![03-FFmpeg转封装-24-flv02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv02.png)

- 签名字段3字节, signature
- version一个字节
- 下一个字节. 如果是一个音视频都展示的FLV文件, 这个字节设置为0x05( 00000 101 ), 这个解释是固定前5位为0 , 第六位是`音频展示设置`为1, 第七位0, 第八位为`视频展示设置`为1.  `我们看到第六位和第八位分别是音频和视频, 而且他们都是1, 那是因为他们都是有的, 说一个视频如果没有音频会怎么样, 没有音频那么第六位就是0`
- 接下来4个字节是FLV文件头数据的偏移位置.0x00 00 00 00


### 2.FLV文件内容格式解析

FLV文件TAG排列方式
![03-FFmpeg转封装-24-flv03](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv03.png)

所以FLV文件内容 = PerTagSize + Tags

书: 从上表中可以看到FLV文件内容的格式主要为FLVTAG, FLVTAG分为两部分, TAGHeader TAGBody


### 3. FLVTAG 格式解析




![03-FFmpeg转封装-24-flv05](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv05.png)

![03-FFmpeg转封装-24-flv06](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv06.png)


我查看的这个:
- 没有`保留`, 
- 没有`滤镜`, 
- 然后数据的大小叫做	`BodyLength`而不是书上说的`DataSize`
- timestamp有
- timestampExtended(扩展时间戳)
- StreamId有
- TAG的data 叫做Body而不是Data



![03-FFmpeg转封装-24-flv07](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv07.png)


TAG数据部分一般存三种数据: `视频数据(0x09)`, `音频数据(0x08),` `脚本数据( 0x12  Script Data, 例如 Metadata )`

下面具体介绍



### 4. VideoTag 数据解析, 视频数据(0x09)

如果是09, 就是视频数据
FLV支持多种视频格式, 下面是视频数据VideoData 部分的相关说明..


![03-FFmpeg转封装-24-flv08](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv08.png)

![03-FFmpeg转封装-24-flv09](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv09.png)


### 5. AudioTag 数据格式解析


![03-FFmpeg转封装-24-flv10](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv10.png)

![03-FFmpeg转封装-24-flv11](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv11.png)


Mono : 单声道
Stereo: 双声道


## 3.2.2  FFmpeg 转FLV参数


![03-FFmpeg转封装-24-flv13](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv13.png)

`在生成FLV文件时, 写入视频, 音频数据时, 均需要写入 Sequence Header数据`


## 3.2.3 FFmpeg文件转FLV举例

如果将FLV不支持的音频合成,会出错
`./ffmpeg -i ./mp4/input_ac3.mp4 -c copy -f flv output.flv`,  这句说mp4里面的音频是`ac3`的, flv不支持这个音频就会报错


为了成功封装现将`ac3`-->`aac`:
`./ffmpeg -i ./mp4/input_ac3.mp4 -vcodec copy -acodec aac -f flv output.flv`



## 3.2.4 FFmpeg生成带关键索引的FLV


![03-FFmpeg转封装-24-flv14](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv14.png)



![03-FFmpeg转封装-24-flv15](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-24-flv15.png)


## 3.2.5  FLV文件格式分析工具

`flvparse`  `flvAnalyzer`

ffrobe 查看: `./ffprobe -v trace -i keyframe.flv`


# 3.3 音视频文件转M3U8

## 3.3.1  M3U8格式标准介绍

- M3U8是一种常见的`流媒体格式`, 主要以`文件列表`的形式存在, 既支持直播又支持点播.它是一个文件,是一个列表文件, `描述文件`
- HLS，Http Live Streaming 是由Apple公司定义的用于实时`流传输的协议`，HLS基于HTTP协议实现，传输内容包括两部分，一是M3U8描述文件，二是TS媒体文件。
- TS, 传输流文件. 实际的音视频数据文件, 这个文件才能播....

我们用VLC播放器或者其他播放器,双击m3u8文件可以播放视频, 是按照里面写好的先播哪个ts再播哪个ts, 实际还是去找ts文件.



m3u8 例子


![03-FFmpeg转封装-25-m3u8-01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-25-m3u8-01.png)


```

#EXTM3U
#EXT-X-VERSION:3
#EXT-X-TARGETDURATION:17
#EXT-X-MEDIA-SEQUENCE:5
#EXTINF:16.666667,
m3u8f15.ts
#EXTINF:16.666667,
m3u8f16.ts
#EXTINF:16.666667,
m3u8f17.ts
#EXTINF:16.666667,
m3u8f18.ts
#EXTINF:4.533333,
m3u8f19.ts
#EXT-X-ENDLIST



```


下面是标签介绍
### 1. EXTM3U
M3U8文件必须包含的标签,   并且必须放在第一行

### 2.EXT-X-VERSION 
版本常见为3

### 3.EXT-X-TARGETDURATION
每一个分片都会有一个分片自己的duration, 这个标签是最大的那个分片的浮点数四舍五入后的正整数数值.

### 4.EXT-X-MEDIA-SEQUENCE
M3U8直播时的直播切片`序列`, 当播放打开M3U8时, 以这个标签的值为参考, 播放对应的序号的切片.
- 分片必须是动态改变的, 序列不能相同, 并且序列必须是增序
- 当m3u8列表中没有出现 `EXT-X-ENDLIST`, 无论列表中有多少分片, 都从倒数第三个开始播放, 不满三片不播放.
- 有这个`EXT-X-ENDLIST`的话就从列表第一个开始呗~

### 5.EXTINF
`EXTINF`是每一个分片的持续时间..`EXTINF`标签除了duration值以外, 还可以包含其他信息,以`,`隔开

### 6.#EXT-X-ENDLIST
若`EXT-X-ENDLIST`出现了表面m3u8不会产生更多切片了.m3u8停止更新


## 3.3.2 FFmpeg 转HLS参数

FFmpeg中自带HLS的封装参数, 使用HLS格式即可进行HLS的封装, 但是生成HLS的时候有各种参数可以进行参考. 
- 设置HLS列表的中切片的前置路径
- 生成HLS的TS切片时设置TS的分片参数
- 生成HLS时设置M3U8列表中保存的TS个数等

![03-FFmpeg转封装-25-m3u8-02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-25-m3u8-02.png)




## 3.3.3 FFmpeg 转HLS举例

常规文件转换:  `./ffmpeg -re -i ./mp4/0036.mp4 -c copy -f hls -bsf:v h264_mp4toannexb m3u8f1.m3u8`

`-bsf:v h264_mp4toannexb` 这个参数是将`mp4`中的`H.264`数据转换为 `H.264 AnnexB`标准的编码.

`AnnexB`标准的编码常见于实时传输流中, FLV TS这些里面就是

### 1.strat_number 参数

设置M3U8列表中的第一片的序列

`./ffmpeg -re -i ./mp4/0036.mp4 -c copy -f hls -bsf:v h264_mp4toannexb -start_number 300 m3u8f1.m3u8`

```

#EXTM3U
#EXT-X-VERSION:3
#EXT-X-TARGETDURATION:17
#EXT-X-MEDIA-SEQUENCE:300
#EXTINF:16.666667,
m3u8f1300.ts
#EXTINF:16.666667,
m3u8f1301.ts
#EXTINF:16.666667,
m3u8f1302.ts
#EXTINF:15.000000,
m3u8f1303.ts
#EXT-X-ENDLIST



```
![03-FFmpeg转封装-25-m3u8-03](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-25-m3u8-03.png)



###  2.hls_time 参数
设置每一片的时长

`./ffmpeg -re -i ./mp4/0036.mp4 -c copy -f hls -bsf:v h264_mp4toannexb -hls_time 20 m3u8f1.m3u8`

`这个切片规则采用的的方式是从关键帧处开始切片GOP, 所以并不是你设置多少切出来就一定是多少 `

### 3.hls_list_size参数
设置M3U8中分片的个数,

我测试了一下, 仿佛没什么卵用, 我设置了3个切出来6个, 我设置了4个切了6个, 我设置8个也是6个, 所以应该按照i
`./ffmpeg -re -i ff.mp4 -c copy -f hls -bsf:v h264_mp4toannexb -hls_list_size 4 m3u8f1.m3u8`

### 4. 设置hls_wrap参数--对CND不友好, 后面将去掉它!-----没什么卵前途
hls_wrap参数用于为M3U8列表中TS设置刷新回滚参数, 当TS分片序号等于hls_wrap参数设置的数值时回滚.

当切片序号大于3时回滚为0
`./ffmpeg -re -i ff.mp4 -c copy -f hls -bsf:v h264_mp4toannexb -hls_wrap 3 m3u8f.m3u8`

```

#EXTM3U
#EXT-X-VERSION:3
#EXT-X-TARGETDURATION:6
#EXT-X-MEDIA-SEQUENCE:1
#EXTINF:5.996000,
m3u8f11.ts
#EXTINF:5.996000,
m3u8f12.ts
#EXTINF:5.996000,
m3u8f10.ts
#EXTINF:5.996000,
m3u8f11.ts
#EXTINF:3.997333,
m3u8f12.ts
#EXT-X-ENDLIST



```

### 5. hls_base_url参数
hls_base_url参数吗用于为M3U8列表中的文件路径设置前置基本路径参数, 因为在FFmpeg中生成的M3U8时写入的TS切片路径默认为与M3U8生成路径相同, 但是实际上TS所存储的路径既可以为本地绝对路径, 也可以为当前相对路径, 还可以为网络路径, 因此使用hls_base_url参数可以达到该效果.


`/application/FFmpeg/bin/ffmpeg -re -i fastMoov.mp4 -c copy -f hls -hls_base_url http://139.59.56.129:9999/cc/ -bsf:v h264_mp4toannexb output.m3u8`


```

#EXTM3U

#EXT-X-VERSION:3

#EXT-X-TARGETDURATION:6

#EXT-X-MEDIA-SEQUENCE:1

#EXTINF:5.996000,

http://139.59.56.129:9999/cc/output1.ts

#EXTINF:5.996000,

http://139.59.56.129:9999/cc/output2.ts

#EXTINF:5.996000,

http://139.59.56.129:9999/cc/output3.ts

#EXTINF:5.996000,

http://139.59.56.129:9999/cc/output4.ts

#EXTINF:3.997333,

http://139.59.56.129:9999/cc/output5.ts

#EXT-X-ENDLIST

```

### 6. hls_segment_filename 参数

设置名字的

`./ffmpeg -re -i ff.mp4 -c copy -f hls -hls_segment_filename test_output-%d.ts -bsf:v h264_mp4toannexb outputf.m3u8`


### 7. hls_flags
hls_flags 参数包含了一些子参数, 子参数包含了:
- 正常文件索引
- 删除过期切片
- 整数显示duration
- 列表开始插入discontinuity标签
- M3U8结束不追加endlist标签等

- 1, delete_segments 
使用`delete_segments`参数用于删除已经`不在M3U8列表中`的旧文件, 这里要注意的是, FFmpeg删除切片时会将hls_list_size大小的2倍作为删除的依据.

`./ffmpeg -re -i ff.mp4 -c copy -f hls -hls_flags delete_segments -hls_list_size 4 -bsf:v h264_mp4toannexb outputf.m3u8`
不在列表中的会被删除....



- 2, round_durations

每一片的秒数都搞成整数, 不知道有啥用

```

#EXTM3U
#EXT-X-VERSION:3
#EXT-X-TARGETDURATION:6
#EXT-X-MEDIA-SEQUENCE:1
#EXTINF:6,
outputf1.ts
#EXTINF:6,
outputf2.ts
#EXTINF:6,
outputf3.ts
#EXTINF:6,
outputf4.ts
#EXTINF:4,
outputf5.ts
#EXT-X-ENDLIST




```



- 3. discont_start

`./ffmpeg -re -i ff.mp4 -c copy -f hls -hls_flags discont_start -bsf:v h264_mp4toannexb outputf.m3u8`
生产时生成`EXT-X-DISCONTINUITY`, 这个标签常用于在切片不连续时作特别声明用.


```

// 生产中出现#EXT-X-DISCONTINUITY

#EXTM3U
#EXT-X-VERSION:3
#EXT-X-TARGETDURATION:6
#EXT-X-MEDIA-SEQUENCE:0
#EXT-X-DISCONTINUITY
#EXTINF:5.996000,
outputf0.ts
#EXTINF:5.996000,
outputf1.ts
#EXTINF:5.996000,
outputf2.ts
#EXTINF:5.996000,
outputf3.ts

// 生产完成

#EXTM3U
#EXT-X-VERSION:3
#EXT-X-TARGETDURATION:6
#EXT-X-MEDIA-SEQUENCE:1
#EXTINF:5.996000,
outputf1.ts
#EXTINF:5.996000,
outputf2.ts
#EXTINF:5.996000,
outputf3.ts
#EXTINF:5.996000,
outputf4.ts
#EXTINF:3.997333,
outputf5.ts
#EXT-X-ENDLIST



```


- 4.omit_endlist 

` ./ffmpeg -re -i ff.mp4 -c copy -f hls -hls_flags omit_endlist -bsf:v h264_mp4toannexb outputf.m3u8`
这个参数就是结束时不加`#EXT-X-ENDLIST`
当m3u8列表中没有出现 `EXT-X-ENDLIST`, 无论列表中有多少分片, 都从倒数第三个开始播放, 不满三片不播放.


- 5. split_by_time
这设置了以后说多少秒就是多少秒, 之前`hls_time`这个是根据关键帧切的. 加上这个后说多少就是多少...

`但是这值, 比如下面设置只有2秒, 切出来可能就只有音频没有画面`

`./ffmpeg -re -i ff.mp4 -c copy -f hls -hls_time 2 -hls_flags split_by_time -bsf:v h264_mp4toannexb outputf.m3u8`


```

#EXTM3U
#EXT-X-VERSION:3
#EXT-X-TARGETDURATION:2
#EXT-X-MEDIA-SEQUENCE:12
#EXTINF:1.932044,
outputf12.ts
#EXTINF:2.065289,
outputf13.ts
#EXTINF:1.998667,
outputf14.ts
#EXTINF:1.932044,
outputf15.ts
#EXTINF:2.065289,
outputf16.ts
#EXT-X-ENDLIST



```


### 8.use_localtime

使用系统名作为切片名

`./ffmpeg -re -i ff.mp4 -c copy -f hls -use_localtime 1 -bsf:v h264_mp4toannexb outputf.m3u8`
![03-FFmpeg转封装-25-m3u8-04](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-25-m3u8-04.png)


### 9.method

- Method参数 用于设置HLS将M3U8及TS文件上传至HTTP服务器, 使用该功能你要有台HTTP服务器, 支持上传相关的方法, 例如PUT, POST, 
- 可以搞一台Nginx的webdav模块来完成

`./ffmpeg -i fastMoov.mp4 -c copy -f hls -hls_time 3 -hls_list_size 0 -method PUT -t 30 http://139.59.56.129:9243/cc/output_test.m3u8`



# 3.4视频文件切片

## 3.4.1 FFmpeg切片segment参数

![03-FFmpeg转封装-26-切片-01](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-26-%E5%88%87%E7%89%87-01.png)


## 3.4.2  FFmpeg切片segment举例


### 1. segment_format 指定切片文件的格式

- MP4切MP4
`./ffmpeg -re -i dashMP4.mp4 -c copy -f segment -segment_format mp4 test_output-%d.mp4`


![03-FFmpeg转封装-26-切片-02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-26-%E5%88%87%E7%89%87-02.png)

查看第一分片MP4的最后的时间戳:`./ffprobe -v quiet -show_packets -select_streams v test_output-0.mp4 2> x|grep pts_time | tail -n 3`


![03-FFmpeg转封装-26-切片-03](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-26-%E5%88%87%E7%89%87-03.png)


查看第二片分片MP4的最开始的时间戳:`./ffprobe -v quiet -show_packets -select_streams v test_output-1.mp4 2> x|grep pts_time | head -n 3`


![03-FFmpeg转封装-26-切片-04](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-26-%E5%88%87%E7%89%87-04.png)


6.133008-6.066016=0.066992;.......说上说这个值是正常的duration, 0.040





### 2.segment_list 与 segment_list_type 指定切片索引列表

- 生成ffconcat格式索引文件
` ./ffmpeg -re -i dashMP4.mp4 -c copy -f segment -segment_format mp4 -segment_list_type ffconcat -segment_list output.lst test_output-%d.mp4`


![03-FFmpeg转封装-26-切片-05](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-26-%E5%88%87%E7%89%87-05.png)


```
**codew$** cat output.lst

ffconcat version 1.0

file test_output-0.mp4

file test_output-1.mp4

file test_output-2.mp4

file test_output-3.mp4

file test_output-4.mp4

file test_output-5.mp4



```
ffconcat, 用于虚拟轮播等场景



- 生成FLAT格式索引
`./ffmpeg -re -i dashMP4.mp4 -c copy -f segment -segment_format mp4 -segment_list_type flat -segment_list filelist.txt test_output-%d.mp4`


```
**codew$** cat filelist.txt

test_output-0.mp4

test_output-1.mp4

test_output-2.mp4

test_output-3.mp4

test_output-4.mp4

test_output-5.mp4


```

- 生成CSV格式索引文件------用来作图


		
`./ffmpeg -re -i dashMP4.mp4 -c copy -f segment -segment_format mp4 -segment_list_type csv -segment_list filelist.csv test_output-%d.mp4`
		
```

**codew$** cat filelist.csv

test_output-0.mp4,0.000000,6.133594

test_output-1.mp4,6.133984,12.133594

test_output-2.mp4,12.133984,18.133594

test_output-3.mp4,18.133984,24.133594

test_output-4.mp4,24.133984,30.133594

test_output-5.mp4,30.133984,34.133594


```

- 生成M3U8格式索引文件

`./ffmpeg -re -i dashMP4.mp4 -c copy -f segment -segment_format mp4 -segment_list_type m3u8 -segment_list output.m3u8 test_output-%d.mp4`

```

cat output.m3u8 

#EXTM3U

#EXT-X-VERSION:3

#EXT-X-MEDIA-SEQUENCE:0

#EXT-X-ALLOW-CACHE:YES

#EXT-X-TARGETDURATION:7

#EXTINF:6.133594,

test_output-0.mp4

#EXTINF:5.999609,

test_output-1.mp4

#EXTINF:5.999609,

test_output-2.mp4

#EXTINF:5.999609,

test_output-3.mp4

#EXTINF:5.999609,

test_output-4.mp4

#EXTINF:3.999609,

test_output-5.mp4

#EXT-X-ENDLIST

```


### 3. reset_timestamps 使切片时间戳归0

`./ffmpeg -re -i dashMP4.mp4 -c copy -f segment -segment_format mp4 -reset_timestamps 1 test_output-%d.mp4`


```

**codew$** ls -l test_output-*

-rw-r--r-- 1 codew staff 190740 Apr 29 02:27 test_output-0.mp4

-rw-r--r-- 1 codew staff 191752 Apr 29 02:27 test_output-1.mp4

-rw-r--r-- 1 codew staff 182671 Apr 29 02:27 test_output-2.mp4

-rw-r--r-- 1 codew staff 180042 Apr 29 02:28 test_output-3.mp4

-rw-r--r-- 1 codew staff 146044 Apr 29 02:28 test_output-4.mp4

-rw-r--r-- 1 codew staff  47670 Apr 29 02:28 test_output-5.mp4


```

- 查看第一片末尾时间戳

```

**codew$** ./ffprobe -v quiet -show_packets -select_streams v test_output-0.mp4 2> x|grep pts_time | tail -n 3

pts_time=5.866016

pts_time=6.066016

pts_time=5.999023


```
- 查看第二片开始时间戳

```


**codew$** ./ffprobe -v quiet -show_packets -select_streams v test_output-1.mp4 2> x|grep pts_time | head -n 3

pts_time=0.000000

pts_time=0.133008

pts_time=0.066016



```
每一片的开始时间戳均已归0,  ......




### 4. segment_times 按照时间点剪切

对文件进行切片时, 有时候需要均匀的切片, 有时候需要按照指定的时间长度进行切片, segment可以根据指定的时间点进行切片, 

` ./ffmpeg -re -i dashMP4.mp4 -c copy -f segment -segment_format mp4 -segment_times 3,9,12 test_output-%d.mp4`


根据命令行参数可以看到, 切片时间分别为第三秒, 第九秒, 第12秒, 在这三个时间点进行切片

`其实并不准确, 不准....应该又是i帧的关系`


## 3.4.3 FFmpeg使用ss与t参数进行切片

### 1. 使用ss指定剪切开头部分
		` ./ffmpeg -ss 10 -i dashMP4.mp4 -c copy output.ts`, 剪出来的居然是`ts`的



# 3.5 音视频文件音视频流抽取

## 3.5.1  FFmpeg抽取音视频文件中的AAC音频流
## 3.5.2  FFmpeg抽取音视频文件中的H264视频流
## 3.5.3  FFmpeg抽取音视频文件中的H265视频流



# 3.6 系统资源使用情况


