### **Project 2**

Write 2 seperate scripts (phonebook.bash and phonebook.csh) to maintain a phonebook as specified below.

**Program specification**

**Input:** A file of records containing the following fields separated by a :

- FirstName LastName
- Home Phone Number: (desired format is xxx-xxx-xxxx)
- Mobile Phone Number: (unique for every person, i.e. the primary key)
- Address: Street address, City, State and Zip
- Birth date: MM/DD/YYYY
- Salary

The sample text file with the desired format can be found here

**Output:**

The program should provide the user with the following menu options:

- Listing of records in alphabetical order of first name or last name
- Listing of records in reverse alphabetical order of first name or last name
- Search for a record by Last Name and print out the result.
- Search for a record by birthday in a given year or month.
- Insert Record (of course, at the correct location in the sorted list)
- Delete Record from the list by providing the mobile phone number or last name
- Write out the sorted records to the same file before exiting the script.
- If not using the sample datafile, then create a text file containing minimum 10 records in the specified format. Your script should reject any record(s) having illegal values, e.g. phone numbers in incorrect format or incorrect zip codes etc., either upon reading the file first or upon a new entry. If you cannot implement format checking for fields due to time constraints, it's ok, please go ahead and submit what you have. you will not be penalized for it
- Feel free to add any other field(s) that you might think is/are important for you to have in a phone book.
- You can also add more menu options (functionality) as desired other than the ones mentioned in the next section.
- Write your own functions (if allowed by the shell, to do the various menu options)

**Programming considerations**

Properly document your script by having ample comments throughout the different parts of your scripts

**FAQs**

1. Can we have multiple entries in the phone book?

   No, you cannot, unless one of the fields is different.

2. What is an illegal zip?

   Any integer that is less or more than 5 digits long.

3. What is an illegal phone number?

   One that does not have 10 digits or is not in the correct format using the hyphens in the correct places. Hence, currently international numbers are not included in the address book.

4. Do I have to check for illegal address (like incorrect state)?

   No, but if you can that would be fabulous. So, I encourage you to do so.

5. Do I have to check for birth date being a valid date?

   No, but again, if you have time and the motivation, surely try to implement it and I would highly recommend doing it.

6. Will I get extra credit for adding more fields?

   Sorry, no.

7. Will I get extra credit for adding more functionality?

   Sorry, no. You are doing this to make your script more functional and usable.

8. If no extra credit is given, why add fields or extra functionality?

   So that you can make your scripts more functional (and cooler) and feel proud about your scripts.

9. Can I use unix utilities within my scripts like sort, grep, sed and awk etc.

   Sure, you can but try to do as many things as possible by using shell commands and features.

10. I cannot find an answer to my question here.

    Please Email me or ask in class.

**Write-up:**

Compare the two scripts in terms of number of lines of code, simplicity of the code and any other aspects that you did or didn’t like while when scripting. The write-up should reflect what you found easy or difficult to do in one versus the other, thus highlighting the advantages of using a particular shell or perl. The write-up should be single space size 12 font and atleast two pages or more.

---

What to hand in for this project on the due date
Upload the well documented scripts and write up. 45 points for each script and 10 points for the write-up.
