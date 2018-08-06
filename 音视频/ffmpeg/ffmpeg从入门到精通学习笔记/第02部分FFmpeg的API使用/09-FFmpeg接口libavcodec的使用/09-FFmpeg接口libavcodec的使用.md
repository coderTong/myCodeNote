# 第九章 FFmpeg接口libavcodec

# 9.1FFmpeg旧接口的使用

## 1. FFmpeg旧接口视频解码
## 2.FFmpeg旧接口视频编码

## 3.FFmpeg旧接口音频解码

主要函数
```

  // FFmpeg旧接口音频解码

// av_register_all();

// avformat_open_input(<#AVFormatContext **ps#>, <#const char *url#>, <#AVInputFormat *fmt#>, <#AVDictionary **options#>)

// avformat_find_stream_info(<#AVFormatContext *ic#>, <#AVDictionary **options#>)

// avcodec_find_decoder(<#enum AVCodecID id#>)

// avcodec_alloc_context3(<#const AVCodec *codec#>)

// avcodec_parameters_to_context(<#AVCodecContext *codec#>, <#const AVCodecParameters *par#>)

// avcodec_open2(<#AVCodecContext *avctx#>, <#const AVCodec *codec#>, <#AVDictionary **options#>)

// av_frame_alloc()

// av_init_packet(<#AVPacket *pkt#>)

// av_read_frame(<#AVFormatContext *s#>, <#AVPacket *pkt#>)

// avcodec_decode_audio4(<#AVCodecContext *avctx#>, <#AVFrame *frame#>, <#int *got_frame_ptr#>, <#const AVPacket *avpkt#>)

// av_sample_fmt_is_planar(<#enum AVSampleFormat sample_fmt#>)

// av_get_packed_sample_fmt(<#enum AVSampleFormat sample_fmt#>)

// avcodec_close(<#AVCodecContext *avctx#>)

// avcodec_free_context(<#AVCodecContext **avctx#>)

// avformat_close_input(<#AVFormatContext **s#>)


```

## 4.FFmpeg旧接口音频编码

```

  // FFmpeg新接口音频解码

// avcodec_register_all();

// av_packet_alloc();

// avcodec_find_decoder(<#enum AVCodecID id#>)

// av_parser_init(<#int codec_id#>)

// avcodec_alloc_context3(<#const AVCodec *codec#>)

// avcodec_open2(<#AVCodecContext *avctx#>, <#const AVCodec *codec#>, <#AVDictionary **options#>)

// av_frame_alloc()

// av_parser_parse2(<#AVCodecParserContext *s#>, <#AVCodecContext *avctx#>, <#uint8_t **poutbuf#>, <#int *poutbuf_size#>, <#const uint8_t *buf#>, <#int buf_size#>, <#int64_t pts#>, <#int64_t dts#>, <#int64_t pos#>)

// avcodec_send_packet(<#AVCodecContext *avctx#>, <#const AVPacket *avpkt#>)

// avcodec_receive_frame(<#AVCodecContext *avctx#>, <#AVFrame *frame#>)

// av_get_bytes_per_sample(<#enum AVSampleFormat sample_fmt#>);

// avcodec_free_context(<#AVCodecContext **avctx#>)

// av_parser_close(<#AVCodecParserContext *s#>)

// av_frame_free(<#AVFrame **frame#>)

// av_packet_free(<#AVPacket **pkt#>)


```


# 9.2  FFmpeg 新接口的使用

## 1.FFmpeg新接口音频编码

## FFmpeg新接口音频解码

## FFmpeg新接口视频编码

## FFmpeg新接口视频解码
