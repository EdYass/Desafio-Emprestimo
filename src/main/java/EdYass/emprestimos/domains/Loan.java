package EdYass.emprestimos.domains;

public class Loan {

    private final Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAvailable(){
        if(customer.isIncomeEsqualOrLowerThan(3000.00)){
            return true;
        }
        return customer.isIncomeBetween(3000.00, 5000.00)
                && customer.isAgeLower(30)
                && customer.isFromLocation("SP");
    }

    public boolean isConsignmentLoanAvailable(){
        return customer.isIncomeEsqualOrGreaterThan(5000.00);
    }

    public boolean isGuaranteedLoanAvailable(){
        return basicLoanAvailable();
    }

    public double getPersonalLoanInterestRate(){
        if(isPersonalLoanAvailable()){
            return 4.0;
        }
        throw new LoanNotAvailableException();
    }

    public double getConsignmentLoanInterestRate(){
        if(isConsignmentLoanAvailable()){
            return 2.0;
        }
        throw new LoanNotAvailableException();
    }

    public double getGuaranteedLoanInterestRate(){
        if(isGuaranteedLoanAvailable()){
            return 3.0;
        }
        throw new LoanNotAvailableException();
    }

    private boolean basicLoanAvailable(){
        if(customer.isIncomeEsqualOrLowerThan(3000.00)){
            return true;
        }
        return customer.isIncomeBetween(3000.00, 5000.00)
                && customer.isAgeLower(30)
                && customer.isFromLocation("SP");
    }
}
