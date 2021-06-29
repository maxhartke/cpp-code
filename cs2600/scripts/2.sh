# script that asks user how they are doing 
#! /bin/sh
while [ true ]
do 
echo "Are you OK?"
read response
case $response in
    "y" | "Y")
        echo "glad to hear it"
        break
        ;;
    "n" | "N")
        echo "sorry that you are not feeling good"
        break
        ;;
    *)
        echo "in-correct choice"
        ;;
esac
done