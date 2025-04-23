import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

    StringUtils utils = new StringUtils();

    @Test
    public void testReverse() {
        assertEquals("edcba", utils.reverse("abcde"));
        assertEquals("", utils.reverse(""));
        assertNull(utils.reverse(null));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(utils.isPalindrome("Madam"));
        assertTrue(utils.isPalindrome("racecar"));
        assertFalse(utils.isPalindrome("hello"));
        assertFalse(utils.isPalindrome(null));
        assertTrue(utils.isPalindrome(""));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"));
        assertEquals("JAVA", utils.toUpperCase("Java"));
        assertNull(utils.toUpperCase(null));
    }
}

