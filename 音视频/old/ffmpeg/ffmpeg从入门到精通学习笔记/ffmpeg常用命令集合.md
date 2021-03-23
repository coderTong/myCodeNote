# 切某段音频
 音频

平时用音频操作基本就是剪切制作手机铃声，所以就只记录剪切的方法

`ffmpeg -i input.mp3 -ss 00:01:12 -t 00:01:42 -acodec copy output.mp3`

ffmpeg -i output.aac -ss 00:00:00 -t 00:00:06 -acodec copy 6s.aac && 



```

for name in `ls`; do openssl enc -des-cbc -k 622153 -iv 0000000000000001 -nosalt -in $name -out $name.mp4 -d; done



for int i = 

for name in `ls`; int i = 1; do mv $name $i.aac i++; done



for name in {6..9}; do ffmpeg -i output.aac -ss 00:00:00 -t 00:00:0$name -acodec copy $names.aac;done


for ((g=10; g<=29; g++))
do
ffmpeg -i output.aac -ss 00:00:00 -t 00:01:$g -acodec copy sm$g.aac;
done

ffmpeg -i output.aac -ss 00:00:00 -t 00:00:01 -acodec copy s60.aac;

```


# 切某个时段的一个视频



`ffmpeg -ss 2400 -i ffmpeg.mp4 -c copy -t 40 mp3Video.mp4`


`ffmpeg -ss 2400 -i opengl.mp4 -c copy -t 40 aacVideo.mp4`



ffmpeg -ss 360 -i c.mp4 -c copy -t 40 c1.mp4

ffmpeg -ss 4800 -i ffmpeg.mp4 -c copy -t 480 rtmpflv.mp4

# 只要某一段的音频

里面是什么音频, 抠出来就是什么
`ffmpeg -ss 2400 -i ffmpeg.mp4 -vn -acodec copy -t 40 mp3Video.xx`


ffmpeg -i c.mp4 -vn -y -acodec copy 3.aac

# 调整mp4的moov

	`ffmpeg -i wechat.mp4 -c copy -f mp4 -movflags faststart fastmoov.mp4`


ffmpeg -i ccz.mp4 -c copy -f mp4 -movflags faststart fastmoov.mp4
# MP4==>flv

`ffmpeg -i mp3Video.mp4 -c copy -f flv rtmpVideo.flv`


# 








