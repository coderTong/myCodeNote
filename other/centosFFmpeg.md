


1.  必要安装

```

yum install autoconf automake bzip2 cmake freetype-devel gcc gcc-c++ git libtool make mercurial pkgconfig zlib-devel -y


```


2. 资源下载

```

cd /wt

FFmpeg源码
curl -O -L https://ffmpeg.org/releases/ffmpeg-snapshot.tar.bz2


// 编译工具
curl -O -L http://www.tortall.net/projects/yasm/releases/yasm-1.3.0.tar.gz


// 编译工具
curl -O -L http://www.nasm.us/pub/nasm/releasebuilds/2.13.02/nasm-2.13.02.tar.bz2

// libx264
git clone https://code.videolan.org/videolan/x264.git

// fdk_aac
git clone https://github.com/mstorsjo/fdk-aac



// 一句
curl -O -L https://ffmpeg.org/releases/ffmpeg-snapshot.tar.bz2 && \
curl -O -L http://www.tortall.net/projects/yasm/releases/yasm-1.3.0.tar.gz && \
curl -O -L http://www.nasm.us/pub/nasm/releasebuilds/2.13.02/nasm-2.13.02.tar.bz2 && \
git clone https://code.videolan.org/videolan/x264.git && \
git clone https://github.com/mstorsjo/fdk-aac



```


3.  先编译yasm

```

cd /wt/wk && \
tar xzvf yasm-1.3.0.tar.gz && \
cd yasm-1.3.0 && \
./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin && \
make && make install


```

4. 编译nasm

```

cd /wt/wk && \
tar xjvf nasm-2.13.02.tar.bz2 && \
cd nasm-2.13.02 && \
./autogen.sh && \
./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin && \
make && make install


```


5. 做个软连接


```

ln -s /application/FFmpeg/bin/nasm /usr/sbin/nasm

```

6. 装x264

```

cd /wt/wk && cd x264 && \
PKG_CONFIG_PATH=/application/FFmpeg/ffmpeg_build/lib/pkgconfig ./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin --enable-static  && \
make && make install

```

7. 装fdk_aac

```

cd /wt/wk && cd fdk-aac && \
autoreconf -fiv && \
./configure --prefix=/application/FFmpeg/ffmpeg_build --disable-shared && \
make && make install

```

8. 编译FFmpeg

```

cd /wt/wk && \
tar xjvf ffmpeg-snapshot.tar.bz2 && \
cd ffmpeg && \
PATH="/application/FFmpeg/bin:$PATH" PKG_CONFIG_PATH="/application/FFmpeg/ffmpeg_build/lib/pkgconfig" ./configure \
  --prefix="/application/FFmpeg/ffmpeg_build" \
  --pkg-config-flags="--static" \
  --extra-cflags="-I/application/FFmpeg/ffmpeg_build/include" \
  --extra-ldflags="-L/application/FFmpeg/ffmpeg_build/lib" \
  --extra-libs=-lpthread \
  --extra-libs=-lm \
  --bindir="/application/FFmpeg/bin" \
  --enable-gpl \
  --enable-libfdk_aac \
  --enable-libfreetype \
  --enable-libx264 \
  --enable-nonfree
&& make && make install && hash -r












cd /wt/FFmpeg && \
curl -O -L https://ffmpeg.org/releases/ffmpeg-snapshot.tar.bz2 && \
tar xjvf ffmpeg-snapshot.tar.bz2 && \
cd ffmpeg  && \
PATH="/application/FFmpeg/bin:$PATH" && \ PKG_CONFIG_PATH="/application/FFmpeg/ffmpeg_build/lib/pkgconfig" && \
./configure \
  --prefix="/application/FFmpeg/ffmpeg_build" \
  --pkg-config-flags="--static" \
  --extra-cflags="-I/application/FFmpeg/ffmpeg_build/include" \
  --extra-ldflags="-L/application/FFmpeg/ffmpeg_build/lib" \
  --extra-libs=-lpthread \
  --extra-libs=-lm \
  --bindir="/application/FFmpeg/bin" \
  --enable-gpl \
  --enable-libfdk_aac \
  --enable-libfreetype \
  --enable-libx264 \
  --enable-libmp3lame \
  --enable-nonfree && \
make && make install && hash -r
```


