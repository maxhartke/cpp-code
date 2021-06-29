# script that display menu of of arithmetic options for two given integers
#! /bin/sh
x=$1
y=$2
if [ $# -lt 2 ]
then
echo Error, not enough arguments
exit 1
fi
while [ true ]
do
echo  "Please enter a character to do one of the following:"
while [ true ]
do
echo "(a) Add the numbers
(s) Subtract the numbers
(m) Multiply the numbers
(d) Divide the numbers 
(e) Exit"
read response

case $response in
    "a" | "A") 
    a=`expr $x \+ $y`
    echo $a 
    break
    ;; 
    "s" | "S") 
    a=`expr $x \- $y`
    echo $a 
    break
    ;; 
    "m" | "M") 
    a=`expr $x \* $y`
    echo $a 
    break
    ;; 
    "d" | "D") 
    a=`expr $x \/ $y`
    echo $a 
    break
    ;; 
    "e" | "E") exit 1 ;; 
    *) echo "Error, unkown character. Please try again";; 
esac
done 
echo "Plase enter a number to do one of the following:
 (1) Do another operation on $x and $y 
 (2) Do another operation with two different integers
 (3) Exit"
 read response
 
 case $response in 
    "1");;
    "2") echo "Please enter two integers"
    read a b
    x=$a
    y=$b
    ;;
    "3") exit 1;;
 esac
done
