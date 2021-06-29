# script that outputs cube of ineteger given 
#! /bin/sh
if [ $# -lt 1 ]
then
echo Error, not enough arguments
exit 1
fi
echo Number $1
a=`expr $1 \* $1 \* $1`
echo cube $a