#!/bin/sh
#Script name: sayit
echo  Type q to quit.
go=start
while [ -n "$go" ]	   # Make sure to double quote the variable 
do
    echo -n I love you.
    read word
    if  [ "$word" = q -o "$word" = Q ]
    then
	echo "I'll always love you!"
	go=
    fi
done
