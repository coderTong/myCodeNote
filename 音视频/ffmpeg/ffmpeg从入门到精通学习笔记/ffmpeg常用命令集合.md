# 切某个时段的一个视频



`ffmpeg -ss 2400 -i ffmpeg.mp4 -c copy -t 40 mp3Video.mp4`


`ffmpeg -ss 2400 -i opengl.mp4 -c copy -t 40 aacVideo.mp4`

# 只要某一段的音频

里面是什么音频, 抠出来就是什么
`ffmpeg -ss 2400 -i ffmpeg.mp4 -vn -acodec copy -t 40 mp3Video.xx`




# 调整mp4的moov

	`ffmpeg -i cuc_ieschool.flv -c copy -f mp4 -movflags faststart fastmoov.mp4`



# MP4==>flv

`ffmpeg -i mp3Video.mp4 -c copy -f flv rtmpVideo.flv`


