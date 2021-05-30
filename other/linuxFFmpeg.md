```c

git clone https://github.com/FFmpeg/FFmpeg.git

wget http://www.tortall.net/projects/yasm/releases/yasm-1.3.0.tar.gz


tar xf yasm-1.3.0.tar.gz && cd yasm-1.3.0 && ./configure --prefix=/application/yasm-1.3.0/ && make && make install



cd FFmpeg

./configure --yasmexe=/application/yasm-1.3.0/bin/yasm --prefix=/application/FFmpeg/ && make -j8 && make install



ln -s /application/FFmpeg/bin/ffmpeg /usr/bin/ffmpeg && ln -s /application/FFmpeg/bin/ffprobe /usr/bin/ffprobe


```



```c

for name in `ls`; do ffmpeg -i $name -vf scale=1280:720 $name.mp4 -hide_banner; done


for name in `ls`; do ffmpeg -threads 8 -i $name -vf scale=1920:1080 $name.mp4 -hide_banner; done



```



```C



ffmpeg -i kom1.mp4 -vf scale=1920:1080 kom1_1080.mp4



ffmpeg -threads 8 -i kom1.mp4 -vf scale=1920:1080  kom1_1080.mp4

3840×2160 （超高清 4K）
2560X1440 （2K）
1920×1080 （1080p全高清）
1600×900
1280×720    （720P 高清）

for name in `ls`; do ffmpeg -i $name $name.mp4; done


// 去掉冗余
-hide_banner

ffmpeg -i miaa-416ch.mp4 -vf scale=1280:720 416.mp4 -hide_banner


ffmpeg -i

```



