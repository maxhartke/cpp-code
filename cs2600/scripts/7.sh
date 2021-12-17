# script that outputs arguments in a format
#! /bin/sh
if [ $# -lt 7 ]
then echo "Not enough arguments provided, expected 7"
else
echo $1 $2 $3 $4 $5 $6 $7
echo $2 $3 $4 $5 $6 $7 $3 $4 $5
echo $6 $7 $4 $5 $6 $7
echo $5 $6 $7
echo $6 $7 $7
fi