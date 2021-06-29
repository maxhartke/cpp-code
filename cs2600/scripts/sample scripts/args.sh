#!/bin/sh
# Script name:  args
# Script to test command line arguments
echo The name of this script is $0.
echo The arguments are $*.
echo The first argument is $1.
echo The second argument is $2.
echo The number of arguments is $#.
oldargs=$*		# save parameters  passed in from the
			# command line
set Jake Nicky Scott	# reset the positional parameters
echo All the positional parameters are $*.
echo The number of postional parameters is $#.
echo "Good-bye for now, $1 "
set `date`			          #  reset the positional parameters
echo The date is $2 $3, $6.
echo "The value of \$oldargs is $oldargs."
set $oldargs
exit
echo $1 $2 $3
