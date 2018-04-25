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




####  11. 解析dinf容器
####  12. 解析stbl容器
####  13.解析edts容器



## 3.1.2 MP4分析工具
## 3.1.3 MP4在FFMpeg中的Demuxer
## 3.1.4  MP4在FFMpeg中的muxer



# 3.2 音视频文件转FLV

## 3.2.1  FLV格式标准介绍
## 3.2.2  FFmpeg 转FLV参数
## 3.2.3 FFmpeg文件转FLV举例
## 3.2.4 FFmpeg生成带关键索引的FLV
## 3.2.5  FLV文件格式分析工具


# 3.3 音视频文件转M3U8

## 3.3.1  M3U8格式标准介绍
## 3.3.2 FFmpeg 转HLS参数
## 3.3.3 FFmpeg 转HLS举例



# 3.4视频文件切片

## 3.4.1 FFmpeg切片segment参数
## 3.4.2  FFmpeg切片segment举例
## 3.4.3 FFmpeg使用ss与t参数进行切片



# 3.5 音视频文件音视频流抽取

## 3.5.1  FFmpeg抽取音视频文件中的AAC音频流
## 3.5.2  FFmpeg抽取音视频文件中的H264视频流
## 3.5.3  FFmpeg抽取音视频文件中的H265视频流



# 3.6 系统资源使用情况


