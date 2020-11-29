
# 编译x86

```c

./configure --arch=x86_64 --target-os=darwin --disable-yasm --prefix=./output --disable-ffmpeg --disable-ffplay --disable-doc --disable-ffprobe --disable-bzlib --disable-ffserver

```

# chenchao编译的
```

--cc=/usr/bin/gcc --arch=x86_64 --target-os=darwin --prefix=output/x86_64 --disable-ffmpeg --disable-ffplay --disable-ffprobe --disable-ffserver --disable-iconv --disable-bzlib --enable-avresample --enable-avresample --enable-pic --disable-doc --disable-decoders --enable-decoder=h264 --enable-decoder=mjpeg --disable-encoders --disable-demuxers --enable-demuxer=mp4 --disable-muxers --enable-muxer=mp4 --disable-filters

```


# make
用8个线程去跑

```c

make -j8
```


# make install

```c


make install
```
