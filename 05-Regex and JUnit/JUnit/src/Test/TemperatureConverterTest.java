import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TemperatureConverterTest {

    private TemperatureConverter converter;

    @Before
    public void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.001);
        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.001);
        assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.001);
    }

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.001);
        assertEquals(37.0, converter.fahrenheitToCelsius(98.6), 0.001);
    }
}

