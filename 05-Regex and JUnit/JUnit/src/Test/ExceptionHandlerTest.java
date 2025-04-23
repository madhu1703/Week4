import org.junit.Test;
import static org.junit.Assert.*;

public class ExceptionHandlerTest {

    ExceptionHandler handler = new ExceptionHandler();

    @Test
    public void testDivideValid() {
        assertEquals(5, handler.divide(10, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZeroThrowsException() {
        handler.divide(10, 0);
    }
}
