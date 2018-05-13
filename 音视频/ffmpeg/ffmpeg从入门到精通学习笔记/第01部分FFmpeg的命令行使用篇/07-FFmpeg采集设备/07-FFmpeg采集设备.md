# 第七章 FFmpeg采集设备


# 7.1 FFmpeg 中linux设备操作

## 1 Linux 下查看设备列表

`ffmpeg -hide_banner -devices`


![07-FFmpeg采集设备01](image/07-FFmpeg%E9%87%87%E9%9B%86%E8%AE%BE%E5%A4%8701.png)



输入设备:  `lavfi`,  `video4linux2`, `lavfi`
输出设备: `v4l2`,  `fbdev`

## 2. Linux 采集设备fbdev 参数说明

使用fbdev设备之前, 需要了解清楚fbdev设备操作参数的情况, FFmpeg可通过如下查看
`ffmpeg -h demuxer=fbdev`
![07-FFmpeg采集设备02](image/07-FFmpeg%E9%87%87%E9%9B%86%E8%AE%BE%E5%A4%8702.png)




![07-FFmpeg采集设备03](image/07-FFmpeg%E9%87%87%E9%9B%86%E8%AE%BE%E5%A4%8703.png)


## 3. Linux 采集设备 fbdev 使用举例


` sudo ffmpeg -framerate 30 -f fbdev -i /dev/fb0 fbdev1.mp4`

出现错误:`Could not open framebuffer device '/dev/fb0': No such device/dev/fb0: No such device`

暂时不解决

## 4. Linux 采集设备 v412参数说明 -------略


## 5. Linux 采集设备 v412使用举例-------略

## 6. Linux 采集设备 x11grab参数说明-------略

## 7. Linux 采集设备 x11grab 使用举例-------略


# 7.2 FFmpeg 中OSX 设备操作

## 1. OSX下查看设备列表

`ffmpeg -hide_banner -devices`
![07-FFmpeg采集设备04](image/07-FFmpeg%E9%87%87%E9%9B%86%E8%AE%BE%E5%A4%8704.png)


```

codew$ ffmpeg -hide_banner -devices
Devices:
 D. = Demuxing supported
 .E = Muxing supported
 --
 D  avfoundation    AVFoundation input device
 D  lavfi           Libavfilter virtual input device
  E sdl,sdl2        SDL2 output device


```

在FFmpeg中采集OSX系统的输入输出设备,  常规采用 `avfoundation`


![07-FFmpeg采集设备05](image/07-FFmpeg%E9%87%87%E9%9B%86%E8%AE%BE%E5%A4%8705.png)




- 还可以像下面一样查看

`ffmpeg -devices`

![07-FFmpeg采集设备06](image/07-FFmpeg%E9%87%87%E9%9B%86%E8%AE%BE%E5%A4%8706.png)



## 2. OSX下设备采集举例


### 1. 枚举avfoundation支持的输入设备

`ffmpeg -f avfoundation -list_devices true -i ""`
![07-FFmpeg采集设备07](image/07-FFmpeg%E9%87%87%E9%9B%86%E8%AE%BE%E5%A4%8707.png)

从输出信息可以看到, 当前系统包含3个设备

视频输入设备:
- [0] FaceTime HD Camera
- [1] Capture screen 0

音频输入设备:
- [0] Built-in Microphone

`avfoundation`除了枚举了物理摄像头([0] FaceTime HD Camera)之外, 还包括1个虚拟设备, 即` [1] Capture screen 0` 设备代表了OSX桌面. 



书上说的命令会出错
`sudo ffmpeg -f avfoundation -i "FaceTime HD Camera" out.mp4` 是因为没有设置`video_size`,`-framerate`

错误如下

```

[avfoundation @ 0x7f82c900d000] Selected framerate (29.970030) is not supported by the device

[avfoundation @ 0x7f82c900d000] Supported modes:

[avfoundation @ 0x7f82c900d000]  640x480@[30.000030 30.000030]fps


............

[avfoundation @ 0x7f82c900d000]  1280x720@[2.000000 2.000000]fps

[avfoundation @ 0x7f82c900d000]  1280x720@[1.000000 1.000000]fps

FaceTime HD Camera: Input/output error



```

加上帧率和尺寸就可以了
`ffmpeg -f avfoundation -video_size 1280x720 -framerate 25 -i "FaceTime HD Camera" out2.mp4`

还有上面这个是不采集声音的. 如果要采集声音需要加上声音采集设备如下:

先看看有什么音频设备

`ffmpeg -f avfoundation -list_devices true -i ""`


`ffmpeg -f avfoundation -video_size 1280x720 -framerate 25 -i "FaceTime HD Camera:Built-in Microphone" out3.mp4`



上面是有采集的设备都是使用的名字, 其实用他们的序号就行了前面是视频采集,后面是音频采集

- 用摄像头采集视频,麦克风采集音频, 第一个0是`[0] FaceTime HD Camera`, 第二个0是`[0] Built-in Microphone`
`ffmpeg -f avfoundation -video_size 1280x720 -framerate 25 -i "0:0" out4.mp4`


- 只要画面不要音频


`ffmpeg -f avfoundation -video_size 1280x720 -framerate 25 -i "0:none" out4.mp4`


- 采集桌面没设置尺寸和帧率也行

`ffmpeg -f avfoundation -i "1:0" -r:v 30 out5.mp4`

`ffmpeg -f avfoundation -video_size 1280x720 -framerate 25 -i "1:0"  -r:v 30 out6.mp4`

加了也ok, 但是好像有点卡, 然后还没声音




- 将桌面图像带上鼠标一起录制下来

`ffmpeg -f avfoundation -capture_cursor 1 -i "1:none" -r:v 30 output9.mp4`


- 采集音频

`ffmpeg -video_size 1280x720 -framerate 25 -f avfoundation -i "0:0" out10.aac`




# 7.3 FFmpeg 中Windows设备操作 ------------略

## 1. FFmpeg 使用dshow采集音视频设备

## 2. FFmpeg使用vfwcap采集音视频设备

## 3. FFmpeg使用gdigrab 采集窗口