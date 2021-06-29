# Write a Bourne or Bash script that takes in a positive integer 
# at the command line as an argument. If the user enters no arguments 
# at the command line or more that 1 argument, then the script prints 
# a statement letting the user know how to use the script and exits. 
# If the user enters a positive integer correctly as the first argument 
# to the script, it then calculates the factorial of this integer and 
# prints out the result on the console (standard output). 
# Factorial of a number is defined as 4! = 4*3*2*1 = 24 and 0! =1 by definition.
#!/bin/sh
if [ $# -lt 1 ]
then
echo Error, not enough arguments
exit 1
fi
if [ $# -gt 1 ]
then
echo Error, too many arguments
exit 1
fi
if [ $1 -lt 0 ]
then
echo Error, must be positve integer
exit 1
fi
count=$1 
fact=$1 
while [ "$count" -gt 1 ]
do
count=`expr $count \- 1`
fact=`expr $fact \* $count`
done
echo $fact