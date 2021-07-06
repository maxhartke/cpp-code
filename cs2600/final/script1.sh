#!/bin/csh

#Name of script is sum

set limit = $argv[1]

set index = 1

set sum = 1

while ($index <= $limit)

            @ sum *= $index

            @ index++

 end

echo "Sum: $sum"