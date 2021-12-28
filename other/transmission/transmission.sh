#!/bin/bash
# Short script to split videos by filesize using ffmpeg by LukeLR

echo '============================================================';
echo 'start';
echo '============================================================';

for name in `ls`;
    do transmission-remote --auth opengl:aaaa -a $name && rm $name;
    echo $name
done



echo '============================================================';
echo 'end';
echo '============================================================';
