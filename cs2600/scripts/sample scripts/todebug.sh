#!/bin/sh
# Sript name: todebug
name="Joe Blow"
if  [  "$name" = "Joe Blow"  ] 
then
    echo "Hi $name"
fi

num=1
while [  $num -lt 5  ]
do
    num=`expr  $num + 1`
done
echo The grand total is $num
