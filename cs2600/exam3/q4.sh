# Write a script in Bourne shell that uses an until loop 
# to go from 1 to 24 and prints out Good morning for 
# values of the loop variable from 1 through 11, Lunch time 
# when the value is 12 and Siesta time when the value is 13 through 17 
# and Goodnight for the remaining values. Use a case statement 
# to switch based on the value of the loop variable and a loop to go 
# over all the hours. Call this script hour by mentioning it in a comment line.
# ./hour.sh 
#! /bin/sh
i=1
until [ $i -gt 24 ]
do
case $i in
    [0-11]) echo  "Good morning";;
    12)	echo "Lunch time";;
    [13-17]) echo "Siesta time";;
    *) echo "Good night";;
    esac
i=`expr $i + 1`
done