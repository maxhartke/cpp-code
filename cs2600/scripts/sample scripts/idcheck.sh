#!/bin/sh
# script name: idcheck
# purpose:check user id to see if user is root.
# Only root has a uid of 0.
# Format for id output:uid=9496(ellie) gid=40 groups=40
# root's uid=0 

id=`id | nawk -F'[=(]'  '{print $2}'`     # get user id
echo your user id is:  $id
if [ $id -eq 0 ]
then 
    echo "you are superuser."
else
    echo "you are not superuser."
fi

