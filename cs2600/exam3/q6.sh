# Rewrite the solution to Question 1 (perfect numbers between 1 and 1000) 
# in Bourne or Bourne Again shell. Hence, your sh/bash script should print 
# out all perfect numbers between 1 and 1000.
#!/bin/sh
sum=0
c=1
i=1
j=1
while [ "$i" -lt 1000 ]
do
c=`expr $i \- 1`
while [ `expr $j \< $i`] 
do 
while [ "$c" -gt 1]
do 
if [ `expr $c \* $j` == $i ]
then
sum=`expr $sum \+ $j` 
fi
c=`expr $c \- 1`
done
j=`expr $j \+ 1`
done
if [ $sum == $i ]
then
echo $sum
fi
i=`expr $i \+ 1`
done