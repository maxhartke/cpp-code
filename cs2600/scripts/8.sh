# script that finds GCD and LCM of two given integers
#! /bin/sh
a=$1
b=$2
c=`expr $1 \< $2`
lcm=`expr $1 \* $2`
if [ $c == 1 ]
then
while [ $b != 0 ]
do
t=$b
b=`expr $a \% $b`
a=$t
done
gcd=$a
echo GCD: $gcd
echo LCM: $lcm
else 
while [ $a != 0 ]
do
t=$a
a=`expr $b \% $a`
b=$t
done
echo GCD: $gcd
echo LCM: $lcm
fi