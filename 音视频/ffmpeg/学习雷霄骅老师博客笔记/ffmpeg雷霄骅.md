# FFmpeg数据结构简介

## AVFormatContext

封装格式上下文结构体，也是统领全局的结构体，保存了视频文件封装 格式相关信息。

## AVInputFormat 

 每种封装格式(例如FLV, MKV, MP4, AVI)对应一个该结构体。

## AVStream 
 视频文件中每个视频(音频)流对应一个该结构体。

## AVCodecContext 
 编码器上下文结构体，保存了视频(音频)编解码相关信息。

## AVCodec 
 每种视频(音频)编解码器(例如H.264解码器)对应一个该结构体。

## AVPacket 
 存储一帧压缩编码数据。

## AVFrame 
 存储一帧解码后像素(采样)数据