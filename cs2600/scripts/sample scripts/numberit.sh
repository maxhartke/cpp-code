#!/bin/sh
# Program name: numberit
# Put line numbers on all lines of memo
if [ $# -lt  1 ] 
then
    echo  "Usage: $0 filename " >&2
    exit 1
fi
count=1		#Initialize count
cat $1 | while read line    
#Input is coming from file on command line
do
    [ $count -eq 1 ] && echo "Processing file $1..." > /dev/tty  
    echo $count $line
    count=`expr $count + 1`
done > tmp$$	#Output is going to a temporary file
mv tmp$$ $1
