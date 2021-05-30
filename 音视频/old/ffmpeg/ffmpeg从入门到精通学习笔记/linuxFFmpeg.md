```c

git clone https://github.com/FFmpeg/FFmpeg.git

wget http://www.tortall.net/projects/yasm/releases/yasm-1.3.0.tar.gz


tar xf yasm-1.3.0.tar.gz && cd yasm-1.3.0 && ./configure --prefix=/application/yasm-1.3.0/ && make && make install



cd FFmpeg

./configure --yasmexe=/application/yasm-1.3.0/bin/yasm --prefix=/application/FFmpeg/ && make && make install



```
