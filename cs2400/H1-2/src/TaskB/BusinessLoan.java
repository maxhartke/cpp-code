package TaskB;

public class BusinessLoan extends Loan{

    public BusinessLoan(int loanNumber, int loanAmount, int term, String lastName, double primeInterestRate, String companyName) {
        super(loanNumber, loanAmount, term, lastName);
        interestRate = primeInterestRate + .01;
        this.loanType = "Business Loan";
        if(term == shortTerm || term == mediumTerm || term == longTerm) {
            totalOwed = interestRate * term * loanAmount + loanAmount;
        } else {
            totalOwed = interestRate * shortTerm * loanAmount + loanAmount;
        }
        this.companyName = companyName;
    }
}
