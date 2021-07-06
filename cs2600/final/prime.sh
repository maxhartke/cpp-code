# Write a Bourne Again shell (bash) script that is run as follows from the prompt:
# 
# % prime 8
# 
# It then prints if 8 is prime or not. Please let the user know that the script 
# needs an integer as a command line argument (and exit script) in case it is run with 
# incorrect number of command line arguments. The name of the script is prime and should 
# be mentioned as a comment in your script. Your script should make sure that the user 
# enters positive integers only. If a negative integer is entered, then ask the user to 
# enter an integer again until the user finally enters a positive integer. A prime number 
# is defined as an integer that is only divisible by 1 and itself and has no other factors.
#!/bin/bash
# script called prime that prints out if a given integer is prime or not 
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
int=$1
while [ $int -lt 0 ]
do
echo Please enter a positive integer
read integer
int=$integer
done
count=2
rem=0
while [ $count -lt $int ]
do
rem=`expr $int \% $count`
if [ $rem == 0 ]
then
echo not prime 
exit 1
fi
count=`expr $count \+ 1`
done
echo prime