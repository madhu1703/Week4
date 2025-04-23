import org.junit.Before;
import org.junit.Test;

public class UserRegistrationTest {

    private UserRegistration userRegistration;

    @Before
    public void setUp() {
        userRegistration = new UserRegistration();
    }

    @Test
    public void testValidRegistration() {
        userRegistration.registerUser("madhumitha", "madhumitha@example.com", "StrongPass1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyUsername() {
        userRegistration.registerUser("", "madhumitha@example.com", "StrongPass1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullUsername() {
        userRegistration.registerUser(null, "madhumitha@example.com", "StrongPass1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidEmail() {
        userRegistration.registerUser("madhumitha", "invalid-email", "StrongPass1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullEmail() {
        userRegistration.registerUser("madhumitha", null, "StrongPass1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShortPassword() {
        userRegistration.registerUser("madhumitha", "madhumitha@example.com", "short");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPassword() {
        userRegistration.registerUser("madhumitha", "madhumitha@example.com", null);
    }
}

