#!/bin/sh
trapper () { 
    echo "In trapper"
    trap 'echo "Caught in a trap!"' 2 
    # Once set, this trap affects the entire script. Anytime
    # ^C is entered, the script will ignore it.
}

while :
do
    echo "In the main script"
    trapper 
    echo "Still in main"
    sleep 5
done
