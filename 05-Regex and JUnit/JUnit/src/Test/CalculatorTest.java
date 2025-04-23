import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(10, calculator.add(6, 4));
    }

    @Test
    public void testSubtraction() {
        assertEquals(2, calculator.subtract(7, 5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    public void testDivision() {
        assertEquals(5, calculator.divide(10, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.divide(10, 0);
    }
}
