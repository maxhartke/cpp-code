# script that outputs an incrementing integer while less then 10
#! /bin/sh
a=0
while [ "$a" -lt 10 ]
do
    echo $a
    a=`expr $a + 1`
done