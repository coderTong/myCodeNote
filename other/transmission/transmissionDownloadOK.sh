#!/bin/sh -l

# script to check for complete torrents in transmission folder, then stop and move them

# either hard-code the MOVEDIR variable here.
MOVEDIR=/home/user # the folder to move completed downloads to
USERNAME=
PASSWORD=
# .or set MOVEDIR using the first command-line argument
# MOVEDIR=%1

# use transmission-remote to get torrent list from transmission-remote list
# use sed to delete first / last line of output, and remove leading spaces
# use cut to get first field from each line
TORRENTLIST=`transmission-remote -n $USERNAME:$PASSWORD  -l | sed -e '1d;$d;s/^ *//' | cut --only-delimited --delimiter=" " --fields=1`

# for each torrent in the list
for TORRENTID in $TORRENTLIST
do
#echo "* * * * * Operations on torrent ID $TORRENTID starting. * * * * *"

# check if torrent download is completed
DL_COMPLETED=`transmission-remote -n $USERNAME:$PASSWORD -l --torrent $TORRENTID --info | grep "Percent Done: 100%"`

# check torrent.s current state is .Stopped., .Finished., or .Idle.
STATE_STOPPED=`transmission-remote -n $USERNAME:$PASSWORD --list --torrent $TORRENTID --info | grep "State: Stopped\|Idle\|Finished"`

# if the torrent is .Stopped., .Finished., or .Idle. after downloading 100%.
if [ "$DL_COMPLETED" != "" ] && [ "$STATE_STOPPED" != "" ]; then
# move the files and remove the torrent from Transmission
echo "Torrent #$TORRENTID is completed."

echo "Moving downloaded file(s) to $MOVEDIR."
transmission-remote -n $USERNAME:$PASSWORD -t $TORRENTID --move $MOVEDIR
#in case after move you want to change owner and\or group of the content - you can uncomment next lines. 
#BUT: beware! these commands will change owner\group for all content in movedir and it's sub dirs! 
#sudo chown -R user $MOVEDIR/*
#sudo chgrp -R user $MOVEDIR/*
echo "Removing torrent from list."
transmission-remote -n media:1253400 -t $TORRENTID --remove
else
echo "Torrent #$TORRENTID is not completed. Ignoring."
fi

echo "* * * * * Operations on torrent ID $TORRENTID completed. * * * * *"

done