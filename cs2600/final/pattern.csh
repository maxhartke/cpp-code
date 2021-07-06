# Write a C-shell script that takes in an integer between 1 and 9 from the command line 
# and then prints out the following pattern using an echo statement that prints only a 
# single star (*).You can use echo -n to suppress the new line aspect of the echo statement. 
# Please remember, you have to use loops in order to print the different lines that have the 
# star character (*). So, if integer read from command line was 3, the pattern printed is as follows:
# 
# *
# 
# **
# 
# ***
# 
# if, integer read from command line was 6, then the pattern is as follows:
# 
# *
# 
# **
# 
# ***
# 
# ****
# 
# *****
# 
# ******
# 
# So, use two loops, one nested inside another. The first loop goes over the line number and the 
# second loop prints the number of stars (which is the same as the line number). 
# So, notice, line 1 has 1 star, line 2 has 2 stars and so on. The last line is the integer that 
# you read from the command line argument. You will not get any credit for printing out multiple 
# stars using a single statement like echo ******. Please make sure that the echo statement 
# only prints a single star and multiple stars are printed as a result of the loops around the echo statement.
#!/bin/csh
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
if [ $1 -lt 1 ] || [ $1 -gt 9 ]
then
echo Error, enter an integer between 1 and 9
exit 1
fi
set var = 1
while ( $var < $1 )
    set i = 0;
    while( $i < $var )
        echo -n *
        $i++
    end
    echo \n
    $var++
end