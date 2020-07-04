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
`ffmpeg -rtmp_app liveyo -i rtmp://26.189.128.41 -c copy -f flv savef.flv`




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

`ffmpeg -user_agent "coderTomwu Player" -i http://15.227.50.226/cc/fastmoov.mp4 -c copy userAgent.mp4`


## 四, 拉取HTTP中的流录制FLV

- 1, 拉取FLV直播流录制为FLV
`ffmpeg -i http://15.227.50.226:9777/ff/ccz.mp4 -c copy -f flv outputF.flv`

- 2.拉取TS直播流录制为FLV
`ffmpeg -i http://15.227.50.226:9777/ff/ccz.ts -c copy -f flv outputF.flv`


- 3.拉取HLS直播流录制为FLV
`ffmpeg -i http://15.227.50.226:9777/ff/ccz.m3u8 -c copy -f flv outputF.flv`

# 5.4 FFmpeg 录制和发布UDP/TCP流

## 一, TCP 与 UDP 参数说明

![05-FFmpeg流媒体-08](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-08.png)


![05-FFmpeg流媒体-09](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-09.png)



## 二, TCP参数使用举例

### 如果是两台真实服务器, 就需要设置真的ip地址,而不是127.0.0.1

使用FFmpeg既可以进行TCP的监听, 也可以使用FFmpeg进行TCP的链接请求, 使用TCP监听与请求可以是对称方式

- 1,TCP监听接收流

`ffmpeg -listen 1 -f flv -i tcp://127.0.0.1:1234/wt -c copy -f flv output.flv`


- 2. TCP请求发布流

`ffmpeg -re -i ccz.mp4 -c copy -f flv tcp://26.189.128.41:1234/wt/video`

- 3. 监听端口超时listen_timeout
  - 没设置的话默认是持续监听的
  - 这里的单位是毫秒

5秒钟没连过来我就停止监听, `listen_timeout`单位是毫秒所以为5000
`time ffmpeg -listen_timeout 5000 -listen 1 -f flv -i tcp://26.189.128.41:1234/wt/video -c copy -f flv output.flv`


- 4. TCP拉流超时参数 timeout

`time ffmpeg -timeout 200000 -i tcp://26.189.128.41:1935/live/stream -c copy -f flv output.flv`



- 5. TCP 传输buffer大小设置 send_buffer_size/recv_buffer_size
`buffer`设置得越小, 传输就会越频繁, 网络开销就越大.


`ffmpeg -re -i ccz.mp4 -c copy -send_buffer_size 256 -f flv tcp://26.189.128.41:1936/wt/video`


- 6.绑定本地UDP端口, localport

### 使用FFmpeg的UDP传输数据时, 默认会由系统分配本地端口, 使用localport参数时可以设置监听本地端口.

`ffmpeg -re -i ccz.mp4 -c copy -localport 23456 -f flv udp://26.189.128.41:12345/wt/video`



## 三, TCP/UDP 使用小结



# 5.5 FFmpeg 推多路流

关键词: `一次编码输出多个封装`


- 管道,两路输出
`ffmpeg -i ccn.mp4 -vcodec libx264 -acodec aac -f flv - | ffmpeg -f flv -i - -c copy -f flv rtmp://26.189.128.41/liveyo/class1 -c copy -f flv rtmp://26.189.128.41/liveyo/class2`

- tee 封装格式输出多路流

```

ffmpeg -re -i aacVideo.mp4 -vcodec libx264 -acodec aac -map 0 -f tee "[f=flv]rtmp://26.189.128.41/liveyo/class1 | [f=flv]rtmp://26.189.128.41/liveyo/class2"


```

验证两路流是不是一样

```

ffmpeg -i rtmp://26.189.128.41/liveyo/class1 -i rtmp://26.189.128.41/liveyo/class2


```
- tee协议输出多路流

```

ffmpeg -re -i ccn.mp4 -vcodec libx264 -acodec aac -f flv "tee:rtmp://206.189.128.41/liveyo/class1|rtmp://206.189.128.41/liveyo/class2"

```




# 5.6 FFmpeg 生成HDS流


`ffmpeg -h muxer=hds`
![05-FFmpeg流媒体-10](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-10.png)


## 一, HDS 参数说明


![05-FFmpeg流媒体-11](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-11.png)



## 二, HDS 使用举例

- 1.window_size 参数控制文件列表大小
设置HDS为直播模式时, 需要实时更新列表, 可以通过window_size参数控制文件列表窗口大小
HDS文件列表中只保存4个文件, 通过window_size设置


` ffmpeg -i ccn.mp4 -c copy -f hds -window_size 4 output`


![05-FFmpeg流媒体-12](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-12.png)

看了下好像不是4个

- index.f4m, 索引文件, 主要为F4M参考标准中mainfest相关, Metadata信息等
- stream0.abst: 文件流相关描述信息
- stream0Seg1-Frag844 : 相似规则文件切片, 文件切片中均为mdat信息


`ffmpeg -i ccn.mp4 -c copy -f hds output`默认没有设置



- 2. extra_window_size 参数控制文件个数

在控制`window_size`之后, HLS切片的情况与之类似, 列表之外的文件会有一些残留.  通过`extra_window_size` 可以控制文件残留个数

设置文件残留个数为1.
`ffmpeg -re -i test.mp4 -c copy -f hds -window_size 4 -extra_window_size 1 output`


![05-FFmpeg流媒体-13](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-13.png)


- 3. remove_at_exit





# 5.7 FFmpeg 生成DASH流----略

## DASH参数说明
## DASH 参数使用举例