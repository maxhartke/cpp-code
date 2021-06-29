#!/bin/sh
# Script name: do_increment
increment ()  {
    sum=`expr $1 + 1`
    return $sum     
}

echo  -n "The sum is "
increment 5    # Call to function increment
echo $?       
echo  $sum  