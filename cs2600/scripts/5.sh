# script that presents menu and takes in a color as input
#! /bin/sh
echo "Please enter a color"
read color
case $color in
    bl* | BL* ) echo "The sky color is $color";;
    yellow | red ) echo "the sun is sometimes this color";;
    *) echo "This color is not in any of the categories defined";;
esac