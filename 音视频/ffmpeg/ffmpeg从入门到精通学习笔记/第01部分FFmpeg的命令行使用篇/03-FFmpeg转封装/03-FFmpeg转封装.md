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
- 第二我这个MP4的moov = size(4字节) + type(4字节) + subAtoms(1018字节=mvhd(108) + trak(910));


![03-FFmpeg转封装-08-moov02](image/03-FFmpeg%E8%BD%AC%E5%B0%81%E8%A3%85-08-moov02.png)


#### 2.解析mvhd 子容器
#### 3.解析trak子容器
####  4. 解析tkhd
####  5.解析mdia
####  6. 解析mdhd容器
####  7. 解析hdlr容器
####  8.解析minf容器
####  9.解析vmhd容器
####  10.解析smhd容器
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


