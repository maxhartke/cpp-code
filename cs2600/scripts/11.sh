# script that takes an interger and outputs the sum from 1 to the integer and the factorial of the integer
#! /bin/sh
echo "Please enter an integer between 1 and 10"
read integer
sum=$integer
count=$integer 
fact=$integer 
while [ "$count" -gt 1 ]
do
count=`expr $count \- 1`
sum=`expr $sum \+ $count`
fact=`expr $fact \* $count`
done
echo sum: $sum
echo factorial: $fact
