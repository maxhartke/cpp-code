package TaskB;

import java.util.Scanner;
//test cases can be found in Test Case.docx
public class CreateLoans {

    public static void CreateLoans(String[] args) {

        Loan array[] = new Loan[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("What is the current or desired prime interest rate?");
        double primeInterestRate = sc.nextDouble();

        for (int i = 0; i < 5; i++) {
            int loanNumber = i + 1;
            System.out.println("Please choose loan number " + loanNumber + " type: Business or Personal");
            String loanType = sc.next();
            if (loanType.equals("Business")) {
                System.out.println("Enter company name for loan number " + loanNumber);
                String companyName = sc.next();
                System.out.println("Enter loan number " + loanNumber + " amount");
                int loanAmount = sc.nextInt();
                if(loanAmount > 100000){
                    System.out.println("We Do not allow loan amounts over $100,000. Please enter loan amount below $100,000.");
                    loanAmount = sc.nextInt();
                }
                System.out.println("Enter loan number " + loanNumber + " term: 1, 3, or 5 years");
                int loanTerm = sc.nextInt();
                System.out.println("Enter last name for loan number " + loanNumber);
                String lastName = sc.next();
                BusinessLoan businessLoan = new BusinessLoan(loanNumber, loanAmount, loanTerm, lastName, primeInterestRate, companyName);
                array[i] = businessLoan;
            } else if (loanType.equals("Personal")) {
                System.out.println("Enter loan number " + loanNumber + " amount");
                int loanAmount = sc.nextInt();
                if(loanAmount > 100000){
                    System.out.println("We Do not allow loan amounts over $100,000. Please enter loan amount below $100,000.");
                    loanAmount = sc.nextInt();
                }
                System.out.println("Enter loan number " + loanNumber + " term: 1, 3, or 5 years");
                int loanTerm = sc.nextInt();
                System.out.println("Enter last name for loan number " + loanNumber);
                String lastName = sc.next();
                PersonalLoan personalLoan = new PersonalLoan(loanNumber, loanAmount, loanTerm, lastName, primeInterestRate);
                array[i] = personalLoan;
            } else {
                System.out.println("Wrong type");
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(array[i].toString());
        }

    }
}
