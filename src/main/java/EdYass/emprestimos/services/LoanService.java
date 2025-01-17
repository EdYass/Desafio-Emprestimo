package EdYass.emprestimos.services;

import EdYass.emprestimos.domains.Loan;
import EdYass.emprestimos.domains.LoanType;
import EdYass.emprestimos.dtos.CustomerLoanRequest;
import EdYass.emprestimos.dtos.CustomerLoanResponse;
import EdYass.emprestimos.dtos.LoanResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {
    public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest loanRequest) {

        var customer = loanRequest.toCustomer();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if (loan.isPersonalLoanAvailable()){
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if (loan.isConsignmentLoanAvailable()){
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
        }

        if (loan.isGuaranteedLoanAvailable()){
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        return new CustomerLoanResponse(loanRequest.name(), loans);
    }
}
