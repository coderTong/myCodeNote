# 第五章 FFmpeg 流媒体



# 5.1 FFmpeg 发布与录制RTMP流

## 一, RTMP参数说明

![05-FFmpeg流媒体-02-rtmp](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-02-rtmp.png)


## 二, RTMP参数举例


### 1. rtmp_app,  `rtmp_app`可以设置推流发布点,  和发布流

设置推流, 这个应该是你可以把数据推到服务器去
`ffmpeg -rtmp_app live -i rtmp://26.189.128.41 -c copy -f rtmpapp01.flv`

设置发布流, 这个发布我试过了,  我下面是把服务器一部电影发布到网上了. 用vlc打开`rtmp://26.189.128.41/live`就可以看到了..
`ffmpeg -re -i ffmpeg.mp4 -c copy -f flv -rtmp_app live rtmp://26.189.128.41`



![05-FFmpeg流媒体-03-rtmp](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-03-rtmp.png)


rtmp_app 后面接的名字要和Nginx里面设置的一样


![05-FFmpeg流媒体-04-rtmp](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-04-rtmp.png)



### 2. rtmp_playpath 

书上说直接用发布流那条命令会出错, ........然后建议如下
`ffmpeg -re -i ffmpeg.mp4 -c copy -f flv -rtmp_app liveyo -rtmp_playpath class rtmp://26.189.128.41`

这样就不会出现了, 实际上我测试, 这样我反而播不了了, 上面那个没加`class`的播放是正常的....

app + class简化版

`ffmpeg -i ffmpeg.mp4 -c copy -f flv rtmp://206.189.128.41/liveyo/class`



### 3.  用FFmpeg叫RTMP的流保存为文件

如果发布流的时候加了class, 这里也加个..
`ffmpeg -rtmp_app liveyo -rtmp_playpath class -i rtmp://206.189.128.41 -c copy -f flv savef.flv`

没加就这样, 本身发布没加, 保存这里反而加了的话, 我测试好像动不了了......, 这条测试有效.....
`ffmpeg -rtmp_app liveyo -i rtmp://206.189.128.41 -c copy -f flv savef.flv`




### 4. rtmp_pageurl ,   rtmp_swfurl   rtmp_tcurl


# 5.2 FFmpeg 录制RTSP流

## 一, RTSP 参数说明
## 二, RTSP 参数使用举例


# 5.3 FFmpeg 录制HTTP流

## 一, HTTP参数说明
## 二, HTTP参数使用举例
## 三, HTTP拉流录制
## 四, 拉取HTTP中的流录制FLV

# 5.4 FFmpeg 录制和发布UDP/TCP流

## 一, TCP 与 UDP 参数说明
## 二, TCP参数使用举例
## 三, TCP/UDP 使用小结

# 5.5 FFmpeg 推多路流

## 一, 管道方式输出多路流
## 二, tee 封装格式输出多路流
## 三, tee协议输出多路流


# 5.6 FFmpeg 生成HDS流


## 一, HDS 参数说明
## 二, HDS 使用举例


# 5.7 FFmpeg 生成DASH流

## DASH参数说明
## DASH 参数使用举例