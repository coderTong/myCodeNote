# 第八章 FFmpeg接口libavformat

# 8.1音视频流封装

`FFmpeg/doc/examples/muxing.c`
muxing.c

- 1. API注册

- 2.申请AVFormatContext

- 3.申请AVStream

- 4.增加目标容器头

- 5. 写入帧数据

- 6.写容器尾信息


![08-FFmpeg接口libavformat的使用-02](image/08-FFmpeg%E6%8E%A5%E5%8F%A3libavformat%E7%9A%84%E4%BD%BF%E7%94%A8-02.png)




# 8.2 音视频文件解封装


`FFmpeg/doc/examples/demuxing_decoding.c`

- 1. API注册

- 2.构建AVFormatContext

- 3. 查找音频流信息

- 4. 读取音视频流

- 5. 收尾



![08-FFmpeg接口libavformat的使用-03](image/08-FFmpeg%E6%8E%A5%E5%8F%A3libavformat%E7%9A%84%E4%BD%BF%E7%94%A8-03.png)


# 8.3 音频文件转封装


- 1. API注册

- 2.构建输入AVFormatContext

- 3.查找流信息

- 4.构建输出AVFormatContext

- 5. 申请AVStream

- 6. stream信息复制

- 7.写文件头信息

- 8. 数据包读取和写入

- 9. 写文件尾信息

- 10.收尾


![08-FFmpeg接口libavformat的使用-04](image/08-FFmpeg%E6%8E%A5%E5%8F%A3libavformat%E7%9A%84%E4%BD%BF%E7%94%A8-04.png)


# 8.4 视频截取


![08-FFmpeg接口libavformat的使用-05](image/08-FFmpeg%E6%8E%A5%E5%8F%A3libavformat%E7%9A%84%E4%BD%BF%E7%94%A8-05.png)




# 8.5 avio内存数据操作

- 1. API注册

- 2. 读取一个文件到内存

- 3.申请AVFormatContext

- 4. 申请AVIOContext

- 5.打开AVFormatContext

- 6.查找音视频流信息

- 7. 读取帧


![08-FFmpeg接口libavformat的使用-06](image/08-FFmpeg%E6%8E%A5%E5%8F%A3libavformat%E7%9A%84%E4%BD%BF%E7%94%A8-06.png)

