package EdYass.emprestimos.domains;

import EdYass.emprestimos.factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerTest {

    @Nested
    class isIncomeEsqualOrLowerThan{
        @Test
        void shouldBeTrueWhenIncomeIsEqual(){
            var customer = CustomerFactory.build(5000.00);
            assertTrue(customer.isIncomeEsqualOrLowerThan(5000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsLowerThan(){
            var customer = CustomerFactory.build(5000.00);
            assertTrue(customer.isIncomeEsqualOrLowerThan(9000.00));
        }

        @Test
        void shouldBeFalseWhenIncomeIsGreaterThan(){
            var customer = CustomerFactory.build(5000.00);
            assertTrue(customer.isIncomeEsqualOrLowerThan(8000.00));
        }
    }

    @Nested
    class isIncomeEsqualOrGreaterThan{
        @Test
        void shouldBeTrueWhenIncomeIsEqual(){
            var customer = CustomerFactory.build(5000.00);
            assertTrue(customer.isIncomeEsqualOrGreaterThan(5000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsGreaterThan(){
            var customer = CustomerFactory.build(5000.00);
            assertTrue(customer.isIncomeEsqualOrGreaterThan(3000.00));
        }

        @Test
        void shouldBeFalseWhenIncomeIsLowerThan(){
            var customer = CustomerFactory.build(5000.00);
            assertFalse(customer.isIncomeEsqualOrGreaterThan(8000.00));
        }
    }

    @Nested
    class isIncomeBetween{
        @Test
        void shouldBeTrueWhenIncomeIsBetween(){
            var customer = CustomerFactory.build(5000.00);
            assertTrue(customer.isIncomeBetween(3000.00,8000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualToMin(){
            var customer = CustomerFactory.build(5000.00);
            assertTrue(customer.isIncomeBetween(5000.00,8000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualToMax(){
            var customer = CustomerFactory.build(8000.00);
            assertTrue(customer.isIncomeBetween(5000.00,8000.00));
        }

        @Test
        void shouldBeFalseWhenIncomeIsNotBetween(){
            var customer = CustomerFactory.build(5000.00);
            assertFalse(customer.isIncomeBetween(3000.00,4500.00));
        }

    }

    @Nested
    class isAgeLowerThan{
        @Test
        void shouldBeTrueWhenAgeIsLowerThan(){
            var customer = CustomerFactory.build(25);
            assertTrue(customer.isAgeLower(30));
        }

        @Test
        void shouldBeFalseWhenAgeIsNotLowerThan(){
            var customer = CustomerFactory.build(25);
            assertFalse(customer.isAgeLower(22));
        }

        @Test
        void shouldBeFalseWhenAgeIsEqualToValue(){
            var customer = CustomerFactory.build(25);
            assertFalse(customer.isAgeLower(25));
        }
    }

    @Nested
    class isFromLocation {
        @Test
        void shouldBeTrueWhenLocationIsEqual(){
            var customer = CustomerFactory.build("SP");
            assertTrue(customer.isFromLocation("SP"));
        }
        @Test
        void shouldBeFalseWhenLocationIsEqual(){
            var customer = CustomerFactory.build("SP");
            assertFalse(customer.isFromLocation("RJ"));
        }
    }

}