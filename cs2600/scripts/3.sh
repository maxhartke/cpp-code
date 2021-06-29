# script that asks user for a score or take a score as an arguemnet and returns grade
#! /bin/sh
if [ `expr 90 \< $1` -eq 1 ] && [ `expr $1 \< 100` -eq 1 ]
then echo "A"
elif [ `expr 80 \< $1` -eq 1 ] && [ `expr $1 \< 90` -eq 1 ]
then echo "B"
elif [ `expr 70 \< $1` -eq 1 ] && [ `expr $1 \< 80` -eq 1 ] 
then echo "C"
elif [ `expr 60 \< $1` -eq 1 ] && [ `expr $1 \< 70` -eq 1 ]
then echo "D"
elif [ `expr $1 \< 60` -eq 1 ] && [ `expr $1 \> 0` -eq 1 ] 
then echo "F"
elif [ `expr $1 \< 0` -eq 1 ] || [ `expr $1 \> 100` -eq 1 ] 
then echo "Error, please enter scores between 0 & 100"
exit 1
fi