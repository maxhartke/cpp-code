#1/bin/csh
echo "Please enter a number to do one of the following:"
echo "
(1) Print list of records in alphapbetical order by first name
(2) Print list of records in alphapbetical order by last name
(3) Search for record by last name
(4) Search for record by birthday in a given year 
(5) Search for record by birthday in a given month
(6) Insert record
(7) Delete record by phone number
(8) Delete record by last name
"
read option
touch copyphonebook
cp phonebook copyphonebook
case $option in 
    1)
    sort copyphonebook | tee phonebook ;;
    2)
    sort -k 2 copyphonebook | tee phonebook;;
    3)
    echo "Please enter last name"
    read lasname
    grep $lasname phonebook
    ;;
    4)
    echo "Please enter birthyear"
    read birthyear
    grep /$birthyear: phonebook 
    ;;
    5)
    echo "Please enter birthmonth"
    read birthmonth
    grep :$birthmonth/ phonebook
    ;;
    6)
    echo "Please enter record"
    read record
    printf "\n$record" >> copyphonebook 
    sort copyphonebook | tee phonebook
    ;;
    7)
    echo "Please enter phone number"
    read number
    grep -v $number copyphonebook | tee phonebook
    ;;
    8)
    echo "Please enter last name"
    read name
    grep -v $name: copyphonebook | tee phonebook
    ;;
esac
rm copyphonebook