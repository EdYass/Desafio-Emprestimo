package EdYass.emprestimos.dtos;

import java.util.List;

public record CustomerLoanResponse(String customer,
                                   List<LoanResponse> loans) {
}
