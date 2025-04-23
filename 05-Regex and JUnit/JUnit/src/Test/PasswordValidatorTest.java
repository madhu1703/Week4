import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorTest {

    private PasswordValidator validator;

    @Before
    public void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    public void testValidPassword() {
        assertTrue(validator.isValid("StrongPass1"));
    }

    @Test
    public void testPasswordTooShort() {
        assertFalse(validator.isValid("Ab1"));
    }

    @Test
    public void testPasswordNoUppercase() {
        assertFalse(validator.isValid("weakpass1"));
    }

    @Test
    public void testPasswordNoDigit() {
        assertFalse(validator.isValid("NoDigitsHere"));
    }

    @Test
    public void testPasswordNull() {
        assertFalse(validator.isValid(null));
    }

    @Test
    public void testPasswordEmpty() {
        assertFalse(validator.isValid(""));
    }
}

