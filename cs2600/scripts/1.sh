# script that asks user for number and determines if it is even or odd
#! /bin/sh
a=2
b=0
echo "Please enter an integer"
read integer
c=`expr $integer \% 2` 
if [ $c == $b ]
then
    echo "The number entered is even"
else
echo "The number entered is odd"    
fi
