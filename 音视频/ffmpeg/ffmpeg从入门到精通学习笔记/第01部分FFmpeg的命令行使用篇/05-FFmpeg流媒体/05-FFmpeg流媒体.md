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

`ffmpeg -i opengl.mp4 -c copy -f flv rtmp://26.189.128.41/liveyo/class`

### 简化版的话, 服务器会报错应该是格式有问题., app + class然后前我测的时候播放不了, 是因为我用rtmp://26.189.128.41/live去播, 实际上如果加了class, 就要用rtmp://26.189.128.41/live/class去播放




### 3.  用FFmpeg叫RTMP的流保存为文件

如果发布流的时候加了class, 这里也加个..
`ffmpeg -rtmp_app liveyo -rtmp_playpath class -i rtmp://206.189.128.41 -c copy -f flv savef.flv`

没加就这样, 本身发布没加, 保存这里反而加了的话, 我测试好像动不了了......, 这条测试有效.....
`ffmpeg -rtmp_app liveyo -i rtmp://206.189.128.41 -c copy -f flv savef.flv`




### 4. rtmp_pageurl ,   rtmp_swfurl   rtmp_tcurl

- rtmp_tcurl : RTMP的connect命令中设置的tcURL目标发布点地址, 一般形如rtmp://xx.xx.xx.xx/app 
- rtmp_swfurl: RTMP的connect命令中设置的swfURL播放器的URL 
- rtmp_pageurl : RTMP在Connect 命令中设置的PageURL字段, 其为播发时所在的Web页面URL

rtmp_pageurl: 放盗链

`ffmpeg -rtmp_pageurl "wojiu.shishi.com" -i rtmp://26.189.128.41/liveyo/class`




# 5.2 FFmpeg 录制RTSP流


`曾经`很常见, 现在有些安防有用




## 一, RTSP 参数说明


![05-FFmpeg流媒体-05-rtsp](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-05-rtsp.png)

![05-FFmpeg流媒体-06-rtsp](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-06-rtsp.png)


## 二, RTSP 参数使用举例


(略~)



# 5.3 FFmpeg 录制HTTP流

## 一, HTTP参数说明

![05-FFmpeg流媒体-07-HTTP](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-07-HTTP.png)




## 二, HTTP参数使用举例

### 1. seekable 参数举例

使用FFmpeg打开直播或者点播文件时, 可以通过seek操作进行播放进行


书上说下面这句会阻塞,..... 我是用的服务器, 两台服务器之间搞.. 并没有出现阻塞...
`ffmpeg -ss 300 -seekable 0 -i http://15.227.50.226/cc/fastmoov.mp4 -c copy httpTest01.mp4`


这句也OK....., 书上说这句不会阻塞
`ffmpeg -ss 30 -seekable 1 -i http://15.227.50.226/cc/fastmoov.mp4 -c copy httpTest03Seek1.mp4`


### 2. headers 参数
在使用FFmpeg`拉取`HTTP数据时, 很多时候会遇到需要自己设置HTTP的header的情况, 例如使用HTTP传输时在header中设置referer字段等操作, 

`ffmpeg -headers "referer: http://www.codertomwu.com" -i http://165.227.50.226/cc/fastmoov.mp4 -c copy -f flv -y httpHeader.flv`




### 3. user_agent 参数设置

在使用FFmpeg进行HTTP连接时,  在HTTP服务器端会对连接的客户端进行记录与区分, 是safari? 是Chrome?均可以记录, 而在流媒体中, 常见的User-Agent 还包括Android的StageFright, iOS的QuickTime, FFmpeg进行HTTP连接时

FFmpeg默认的user_agent是`Lavf`, 通过如下可以修改`user_agent`

`ffmpeg -user_agent "coderTomwu Player" -i http://165.227.50.226/cc/fastmoov.mp4 -c copy userAgent.mp4`




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