
1. zsh

```

yum install curl-devel expat-devel gettext-devel openssl-devel zlib-devel wget vim zsh gcc -y && wget https://github.com/git/git/archive/v2.24.0.tar.gz && tar -zxf v2.24.0.tar.gz && cd git-2.24.0 && make prefix=/usr/local all && sudo make prefix=/usr/local install && sh -c "$(wget https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh -O -)"


```


3. 安装

```

yum install autoconf automake bzip2 cmake freetype-devel gcc gcc-c++ git libtool make mercurial pkgconfig zlib-devel -y && \
cd /wt/mk && \

curl -O -L https://ffmpeg.org/releases/ffmpeg-snapshot.tar.bz2 && \
curl -O -L http://www.tortall.net/projects/yasm/releases/yasm-1.3.0.tar.gz && \
curl -O -L http://www.nasm.us/pub/nasm/releasebuilds/2.13.02/nasm-2.13.02.tar.bz2 && \
git clone https://code.videolan.org/videolan/x264.git && \
git clone https://github.com/mstorsjo/fdk-aac && \


cd /wt/wk && \
tar xzvf yasm-1.3.0.tar.gz && \
cd yasm-1.3.0 && \
./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin && \
make && make install && \

cd /wt/wk && \
tar xjvf nasm-2.13.02.tar.bz2 && \
cd nasm-2.13.02 && \
./autogen.sh && \
./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin && \
make && make install && \

ln -s /application/FFmpeg/bin/nasm /usr/sbin/nasm && \

cd /wt/wk && cd x264 && \
PKG_CONFIG_PATH=/application/FFmpeg/ffmpeg_build/lib/pkgconfig ./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin --enable-static  && \
make && make install && \

cd /wt/wk && cd fdk-aac && \
autoreconf -fiv && \
./configure --prefix=/application/FFmpeg/ffmpeg_build --disable-shared && \
make && make install && \



```


```
cd / && mkdir -p /wt/wk && \
cd /wt/wk && \
yum install autoconf automake bzip2 cmake freetype-devel gcc gcc-c++ git libtool make mercurial pkgconfig zlib-devel -y && \
cd /wt/wk && \
curl -O -L https://ffmpeg.org/releases/ffmpeg-snapshot.tar.bz2 && \
curl -O -L http://www.tortall.net/projects/yasm/releases/yasm-1.3.0.tar.gz && \
curl -O -L http://www.nasm.us/pub/nasm/releasebuilds/2.13.02/nasm-2.13.02.tar.bz2 && \
git clone https://code.videolan.org/videolan/x264.git && \
git clone https://github.com/mstorsjo/fdk-aac && \
cd /wt/wk && \
tar xzvf yasm-1.3.0.tar.gz && \
cd yasm-1.3.0 && \
./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin && \
make && make install && \
cd /wt/wk && \
tar xjvf nasm-2.13.02.tar.bz2 && \
cd nasm-2.13.02 && \
./autogen.sh && \
./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin && \
make && make install && \
ln -s /application/FFmpeg/bin/nasm /usr/sbin/nasm && \
cd /wt/wk && cd x264 && \
PKG_CONFIG_PATH=/application/FFmpeg/ffmpeg_build/lib/pkgconfig ./configure --prefix=/application/FFmpeg/ffmpeg_build --bindir=/application/FFmpeg/bin --enable-static  && \
make && make install && \
cd /wt/wk && cd fdk-aac && \
autoreconf -fiv && \
./configure --prefix=/application/FFmpeg/ffmpeg_build --disable-shared && \
make && make install && \
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
  --enable-nonfree && make && make install && hash -r

```
