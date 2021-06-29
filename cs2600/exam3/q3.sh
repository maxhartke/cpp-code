# Write a Bourne/ Bourne Again shell script that takes the input of the date command
# from the command line or you can also run date from within the script, and prints 
# out the date in the following format:

# Wed
# June
# 17
# 12:13:45
# PDT
# 2020
#! /bin/sh
date=$(date)
i=1
while [ "$i" -lt 7 ]
do
    echo $date | cut -d " " -f$i
    i=`expr $i + 1`
done