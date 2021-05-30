#!/bin/bash
# Short script to split videos by filesize using ffmpeg by LukeLR

if [ $# -ne 2 ]; then
    echo '要两个参数哈~不够!!!!'
    echo '第一个参数是文件路径'
    echo '第二个参数是文件大小: '
    echo '					1000 000 = 1MB'
    exit 1
fi

    echo '参数够~'


FILE="$1"
SIZELIMIT="$2"

echo "文件名是: $FILE"
echo "每个视频要切成: $SIZELIMIT"

DURATION=$(ffprobe -i "$FILE" -show_entries format=duration -v quiet -of default=noprint_wrappers=1:nokey=1|cut -d. -f1)


echo "你给的视频总时长是: $DURATION 单位: 秒"


CUR_DURATION=0

BASENAME="${FILE%.*}"

EXTENSION="mp4"

i=1


NEXTFILENAME="$BASENAME-$i.$EXTENSION"


while [[ $CUR_DURATION -lt $DURATION ]]; do
	#statements

	echo ffmpeg -i "$FILE" -ss "$CUR_DURATION" -fs "$SIZELIMIT"  "$NEXTFILENAME"
    ffmpeg -ss "$CUR_DURATION" -i "$FILE" -fs "$SIZELIMIT"  "$NEXTFILENAME"

    NEW_DURATION=$(ffprobe -i "$NEXTFILENAME" -show_entries format=duration -v quiet -of default=noprint_wrappers=1:nokey=1|cut -d. -f1)

    CUR_DURATION=$((CUR_DURATION + NEW_DURATION))

    i=$((i + 1))

    NEXTFILENAME="$BASENAME-$i.$EXTENSION"

done

# ffmpeg -i cc.ts -fs 20000000 ok123.mp4
