package TaskB;

public class PersonalLoan extends Loan {

    public PersonalLoan(int loanNumber, int loanAmount, int term, String lastName, double primeInterestRate) {
        super(loanNumber, loanAmount, term, lastName);
        interestRate = primeInterestRate + .02;
        this.loanType = "Personal Loan";
        if(term == shortTerm || term == mediumTerm || term == longTerm) {
            totalOwed = interestRate * term * loanAmount + loanAmount;
        } else {
            totalOwed = interestRate * shortTerm * loanAmount + loanAmount;
        }
    }
}
