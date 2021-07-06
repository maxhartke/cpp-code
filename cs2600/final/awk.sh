# This is my awk script
/:N/{print$1, $2}
/ C/{print $6}
{print "Number of lines this file has is" $lc}
