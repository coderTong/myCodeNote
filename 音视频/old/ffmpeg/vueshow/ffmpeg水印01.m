```

ffmpeg -i mk.mp4 -i 1.png -filter_complex "[0:v][1:v]overlay=0:0:enable=between(t\,10\,15)" out7.mp4



ffmpeg -i mk.mp4   -i 1.png   -filter_complex "[1:v]scale=50:50[s];[0:v][s]overlay=0:0:enable=between(t\,10\,15)"   -vcodec h264 a1.mp4


ffmpeg -i mk.mp4   -i 1.png   -filter_complex "[1:v]scale=150:150[ws];[0:v][ws]overlay=0:0:enable=between(t\,0\,150)"   -vcodec h264 awt.mp4



ffmpeg -i mk.mp4   -i 1.png -i 2.jpg   -filter_complex "[2:v]scale=150:150[fbb];[1:v]scale=150:150[ws];[0:v][1:v]overlay=130:60:enable=between(t\,5\,150):[bkg1];[0:v][2:v]overlay=0:0:enable=between(t\,0\,150):[bkg2];"   -vcodec h264 awt54.mp4

/// 多图片ok
ffmpeg -i input.mp4 -i image1.png -i image2.png -filter_complex "[1:v]scale=100:100[img1];[2:v]scale=20:20[img2];[0:v][img1]overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2:enable=between(t\,5\,150)[bkg];[bkg][img2]overlay=0:0:enable=between(t\,10\,150)" -y output.mp4


//三张图片
ffmpeg -i input.mp4 -i image1.png -i image2.png -i image3.png -filter_complex "[1:v]scale=100:100[img1];[2:v]scale=20:20[img2];[3:v]scale=190:298[img3];[0:v][img1]overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2:enable=between(t\,5\,150)[bkg];[bkg][img2]overlay=0:0:enable=between(t\,10\,150)[bkg];[bkg][img3]overlay=55:55:enable=between(t\,2\,150)" -y output.mp4




ffmpeg -i input.mp4  -i audio0.aac -i audio1.aac -i audio2.aac -i image1.png -i image2.png -i image3.png -filter_complex "[4:v]scale=100:100[img1];[5:v]scale=20:20[img2];[6:v]scale=190:298[img3];[0:v][img1]overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2:enable=between(t\,5\,150)[bkg];[bkg][img2]overlay=0:0:enable=between(t\,10\,150)[bkg];[bkg][img3]overlay=55:55:enable=between(t\,2\,150)[vout];


// 拼接
...



/usr/local/ffmpeg/bin/ffmpeg -i d1.mp3 -i d2.mp3 -filter_complex '[0:0] [1:0] concat=n=2:v=0:a=1 [a]' -map [a] j5.mp3
1

-ss 00:00:00.0 -t 00:00:30.00 -acodec copy ccx.aac


[1:a]afade=t=in:st=2:d=0.1,afade=t=out:st=20:d=0.1,volume=1[aud0];
[2:a]afade=t=in:st=2:d=0.1,afade=t=out:st=3:d=0.1,volume=0.5[aud1];
[2:a]afade=t=in:st=2:d=0.1,afade=t=out:st=3:d=0.1,volume=0.5[aud2];


[aud0][aud1][aud2]amix[aout];-map [vout] -map [aout] -r 30 -b:v 1500K 15 -c:v libx264"    aaakk.mp4


ffmpeg -i input.mp4  -i audio0.aac -i audio1.aac "[0:a]volume=0.8[a0]; \
[1:a]volume=0.8[a1]; \
[a0][a1]amix=inputs=2[a]" \

//ok
ffmpeg -i input.mp4 -i audio3.m4a  -filter_complex "[0:a]afade=t=in:st=0:d=0.1,afade=t=out:st=20:d=0.1,volume=0.01[a0];[1:a]afade=t=in:st=0:d=0.1,afade=t=out:st=20:d=10,volume=1[a1];[a0][a1]amix=inputs=2[a]" -map 0:v -map "[a]" -c:v copy -c:a aac -shortest output21.mp4




ffmpeg -i input.mp4 -i audio2.aac -i audio1.aac -i audio0.aac -i audio4.aac  -i image1.png -i image2.png -i image3.png -filter_complex "[5:v]scale=100:100[img1];[6:v]scale=20:20[img2];[7:v]scale=190:298[img3];[0:v][img1]overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2:enable=between(t\,5\,150)[bkg];[bkg][img2]overlay=0:0:enable=between(t\,10\,150)[bkg];[bkg][img3]overlay=55:55:enable=between(t\,2\,150)[vout];[0:a]volume=0.01[a0];[1:a]volume=0.01[a1];[2:a]volume=1[a2];[3:a]volume=0.01[a3];[4:a]volume=1[a4];[a0][a1][a2][a3][a4]amix=inputs=5[aout]" -map "[vout]" -map "[aout]" s.mp4



ffmpeg -i input.mp4 -i audio2.aac -i audio1.aac -i audio0.aac -i audio4.aac  -i image1.png -i image2.png -i image3.png -filter_complex "[5:v]scale=100:100[img1];[6:v]scale=20:20[img2];[7:v]scale=190:298[img3];[0:v][img1]overlay=40:50:enable=between(t\,5\,150)[bkg];[bkg][img2]overlay=0:0:enable=between(t\,10\,150)[bkg];[bkg][img3]overlay=55:55:enable=between(t\,2\,150)[vout];[0:a]volume=0.01[a0];[1:a]volume=0.01[a1];[2:a]volume=1[a2];[3:a]volume=0.01[a3];[4:a]volume=1[a4];[a0][a1][a2][a3][a4]amix=inputs=5[aout]" -map "[vout]" -map "[aout]" 55.mp4








ffmpeg -i input.mp4 -i image1.png -i image2.png -i image3.png -filter_complex "[1:v]scale=100:100[img1];[2:v]scale=20:20[img2];[3:v]scale=190:298[img3];[0:v][img1]overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2:enable=between(t\,5\,150)[bkg];[bkg][img2]overlay=0:0:enable=between(t\,10\,150)[bkg];[bkg][img3]overlay=55:55:enable=between(t\,2\,150)" -y output.mp4






//.....
ffmpeg -i input.mp4 -i image1.png -i image2.png -i image3.png -filter_complex "[1:v]scale=100:100[img1];[2:v]scale=20:20[img2];[3:v]scale=190:298[img3];[0:v][img1]overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2:enable=between(t\,5\,150)[bkg];[bkg][img2]overlay=0:0:enable=between(t\,10\,150)[bkg];[bkg][img3]overlay=55:55:enable=between(t\,2\,150)" -y output.mp4





ffmpeg -i input.mp4 -i audio2.aac  -filter_complex "[0:a]volume=0.01[a0];[1:a]volume=1.0[a1];[a0][a1]amix=inputs=2[a]" -map 0:v -map "[a]" -c:v copy -c:a aac -shortest output23.mp4


ffmpeg -i input.mp4 -i audio2.aac  -filter_complex





ffmpeg -i audio0.aac -i audio1.aac -i audio2.aac -filter_complex "[0:a]afade=t=in:st=2:d=0.1,afade=t=out:st=20:d=0.1,volume=1[aud0];[1:a]afade=t=in:st=2:d=0.1,afade=t=out:st=3:d=0.1,volume=0.5[aud1];[2:a]afade=t=in:st=2:d=0.1,afade=t=out:st=3:d=0.1,volume=0.5[aud2];[aud0][aud1][aud2]amix" -y output3.aac

ffmpeg -i audio0.aac -i audio1.aac -i audio2.aac -filter_complex "[0:a]afade=t=in:st=2:d=0.1,afade=t=out:st=4:d=0.1,volume=1[aud0];[1:a]afade=t=in:st=2:d=0.1,afade=t=out:st=3:d=0.1,volume=0.5[aud1];[2:a]afade=t=in:st=2:d=0.1,afade=t=out:st=3:d=0.1,volume=0.5[aud2];[aud0][aud1][aud2]amix" -out output3.aac




ffmpeg -i audio1.aac -af 'afade=t=in:ss=0:d=0,afade=t=out:ss=1:d=0' outaa.aac



ffmpeg -i input.mp4 -i audio2.aac -filter_complex "[2:a][1:a]amerge=inputs=2[aout]" -map "[aout]" -ac 2 mix_amerge.aac




ffmpeg -i input.mp4 -i image1.png -i image2.png -i image3.png -i audio1.aac -i audio2.aac -filter_complex "[1:v]scale=100:100[img1];[2:v]scale=20:20[img2];[3:v]scale=190:298[img3];[0:v][img1]overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2:enable=between(t\,5\,150)[bkg];[bkg][img2]overlay=0:0:enable=between(t\,10\,150)[bkg];[bkg][img3]overlay=55:55:enable=between(t\,2\,150)[vout];[0:a]afade=t=in:st=1:d=0.1,afade=t=out:st=20:d=0.1,volume=1" -y output.aac



ffmpeg -i input.mp4 -i audio1.aac -filter_complex "[1:a]afade=t=in:st=0:d=0.1,afade=t=out:st=20:d=0.1,volume=1" -y mix_amerge.aac

ffmpeg -i input.mp4 -i audio1.aac -i audio2.aac -filter_complex "[0:a]afade=t=in:st=0:d=0.1,afade=t=out:st=20:d=0.1,volume=0.5[aud01];[aud01][1:a]afade=t=in:st=0:d=0.1,afade=t=out:st=20:d=0.1,volume=1[aout];[aout]amix"  output.aac



ffmpeg -i mk.mp4 -i 2.jpg -filter_complex overlay=W-w:H-h pair3.mp4

// 多个图片
ffmpeg -i mk.mp4   -i 1.png -i 2.jpg -filter_complex
"[1:v]scale=90:100[img1];\
[2:v]scale=30:80[img2];\
[0:v][img1]overlay=25:100[bkg];\
[bkg][img2]overlay=150:75"
-vcodec h264 awt54.mp4

ffmpeg -i mk.mp4   -i 1.png -i 2.jpg   -filter_complex "[2:v]scale=150:150[fbb];[1:v]scale=150:150[ws];[0:v][fbb]overlay=130:60:enable=between(t,5,150)[bkg];[bkg][ws]overlay=0:0:enable=between(t,0,150);"   -vcodec h264 90.mp4


ffmpeg -i mk.mp4 -i 1.png -filter_complex "[0:v][1:v]scale=50:50;[0:v][1:v]overlay=0:0:enable=between(t\,10\,15)" out8.mp4

ffmpeg -i mk.mp4 -i 1.png -filter_complex "[1:v]scale=50:50[s];[1:v][s]overlay=0:0:enable=between(t\,10\,15)" out5.mp4

```
