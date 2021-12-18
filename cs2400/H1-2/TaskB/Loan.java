package TaskB;

public abstract class Loan implements LoanConstants {
    int loanNumber;
    int loanAmount;
    double interestRate;
    int term;
    double totalOwed;
    String customerLastName;
    String loanType;
    String companyName;
    String dueDate = "year";
    public Loan(int loanNumber, int loanAmount, int term, String lastName) {
        if(loanAmount > maxLoanAmount){
            System.out.println("Loans not allowed over 100000");
        }
        else {
            this.loanNumber = loanNumber;
            this.loanAmount = loanAmount;
            this.customerLastName = lastName;
            if(term == shortTerm || term == mediumTerm || term == longTerm){
                this.term = term;
                if(term == shortTerm){
                    dueDate = "year";
                } else {
                    dueDate = "years";
                }
            }
            else {
                this.term = shortTerm;
                this.customerLastName = lastName;
            }
        }
    }

    @Override
    public String toString() {
        return  "\n" + "Loan Number: " + loanNumber + "\n" +
                "Loan Amount: " + loanAmount + "\n" +
                "Interest Rate: " + interestRate + "\n" +
                "Term: " + term + " " + dueDate + "\n" +
                "Last Name: " + customerLastName + "\n" +
                "Company Name: " + companyName + "\n" +
                "Loan Type: " + loanType + "\n" +
                "Due in: " + term + " " + dueDate + "\n" +
                "Total Owed: " + totalOwed + "\n";
    }
}
