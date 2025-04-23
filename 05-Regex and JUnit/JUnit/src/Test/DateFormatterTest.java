import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class DateFormatterTest {

    private DateFormatter formatter;

    @Before
    public void setUp() {
        formatter = new DateFormatter();
    }

    @Test
    public void testValidDate() throws ParseException {
        String input = "2025-05-19";
        String expected = "19-05-2025";
        assertEquals(expected, formatter.formatDate(input));
    }

    @Test(expected = ParseException.class)
    public void testInvalidDateFormat() throws ParseException {
        formatter.formatDate("19-05-2025");
    }

    @Test(expected = ParseException.class)
    public void testInvalidDateValue() throws ParseException {
        formatter.formatDate("2025-13-40");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullDate() throws ParseException {
        formatter.formatDate(null);
    }
}

