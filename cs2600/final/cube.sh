# Write a script in Bourne Again shell (bash) that takes a command line argument 
# that is an integer between 1 and 20. Use an if statement in your program to check 
# if the user has entered 1 argument and if it is between 1 and 20. If not, then tell 
# the user how to use the script and end the script. If the number is entered correctly, 
# then use a function called cube (you need to write the function) to calculate the cube 
# of the integer passed to it. The main part of the script will call this function in a 
# loop going from 1 to the number entered in the command line and the output will be a 
# table as follows:
# 
# Number           Cube
# 
# 1                      1
# 
# 2                      8
# 
# .                       .
# 
# n                      n3
#!/bin/bash
cube () {
    cube=`expr $1 \* $1 \* $1`
    return $cube
}
if [ $# -lt 1 ]
then
echo Error, not enough arguments
exit 1
fi
if [ $1 -lt 1 ] || [ $1 -gt 20 ]
then
echo Error, enter an integer between 1 and 20
exit 1
fi
count=1
echo "Number        Cube"
while [ $count -lt `expr $1 \+ 1` ]
do
cube= cube $count
echo "$count             $cube"
count=`expr $count \+ 1`
done
