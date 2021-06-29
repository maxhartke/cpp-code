# script that loops and prints over date
#! /bin/sh
d=$(date)
a=1
while [ "$a" -lt 7 ]
do
    echo $d | cut -d " " -f$a
    a=`expr $a + 1`
done