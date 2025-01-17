package EdYass.emprestimos.dtos;

import EdYass.emprestimos.domains.LoanType;

public record LoanResponse(LoanType type,
                           Double interestRate) {
}
