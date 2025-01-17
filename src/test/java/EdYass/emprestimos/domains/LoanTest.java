package EdYass.emprestimos.domains;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class LoanTest {
    @Mock
    private Customer customer;

    @InjectMocks
    private Loan loan;

    @Nested
    class isPersonalLoanAvailable{
        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLess3k(){
            doReturn(true).when(customer).isIncomeEsqualOrLowerThan(3000.00);
            assertTrue(loan.isPersonalLoanAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAgeIsLessThan30AndLocationIsSP(){
            doReturn(false).when(customer).isIncomeEsqualOrLowerThan(3000.00);
            doReturn(true).when(customer).isIncomeBetween(3000.00,5000.00);
            doReturn(true).when(customer).isAgeLower(30);
            doReturn(true).when(customer).isFromLocation("SP");
            assertTrue(loan.isPersonalLoanAvailable());
        }
    }

    @Nested
    class isGuaranteedLoanAvailable{
        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrLess3k(){
            doReturn(true).when(customer).isIncomeEsqualOrLowerThan(3000.00);
            assertTrue(loan.isGuaranteedLoanAvailable());
        }

        @Test
        void shouldBeAvailableWhenIncomeIsBetween3kAnd5kAgeIsLessThan30AndLocationIsSP(){
            doReturn(false).when(customer).isIncomeEsqualOrLowerThan(3000.00);
            doReturn(true).when(customer).isIncomeBetween(3000.00,5000.00);
            doReturn(true).when(customer).isAgeLower(30);
            doReturn(true).when(customer).isFromLocation("SP");
            assertTrue(loan.isGuaranteedLoanAvailable());
        }
    }

    @Nested
    class isConsignmentLoanAvailable{
        @Test
        void shouldBeAvailableWhenIncomeIsEqualOrGreaterThan5k(){
            doReturn(true).when(customer).isIncomeEsqualOrGreaterThan(5000.00);
            assertTrue(loan.isConsignmentLoanAvailable());
        }

        @Test
        void shouldNotBeAvailableWhenIncomeIsEqualTo4k(){
            doReturn(false).when(customer).isIncomeEsqualOrGreaterThan(5000.00);
            assertFalse(loan.isConsignmentLoanAvailable());
        }
    }

    @Nested
    class getPersonalLoanInterestRate{
        @Test
        void shouldTheInterestRateBe4(){
            doReturn(true).when(customer).isIncomeEsqualOrLowerThan(3000.00);
            assertEquals(4.0, loan.getPersonalLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable(){
            doReturn(false).when(customer).isIncomeEsqualOrLowerThan(3000.00);
            assertThrows(LoanNotAvailableException.class, () -> loan.getPersonalLoanInterestRate());
        }
    }

    @Nested
    class getGuaranteedLoanInterestRate{
        @Test
        void shouldTheInterestRateBe3(){
            doReturn(true).when(customer).isIncomeEsqualOrLowerThan(3000.00);
            assertEquals(3.0, loan.getGuaranteedLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable(){
            doReturn(false).when(customer).isIncomeEsqualOrLowerThan(3000.00);
            assertThrows(LoanNotAvailableException.class, () -> loan.getGuaranteedLoanInterestRate());
        }
    }

    @Nested
    class getConsignmentLoanInterestRate{
        @Test
        void shouldTheInterestRateBe2(){
            doReturn(true).when(customer).isIncomeEsqualOrGreaterThan(5000.00);
            assertEquals(2.0, loan.getConsignmentLoanInterestRate());
        }

        @Test
        void shouldThrowExceptionWhenIsNotAvailable(){
            doReturn(false).when(customer).isIncomeEsqualOrGreaterThan(5000.00);
            assertThrows(LoanNotAvailableException.class, () -> loan.getConsignmentLoanInterestRate());
        }
    }
}