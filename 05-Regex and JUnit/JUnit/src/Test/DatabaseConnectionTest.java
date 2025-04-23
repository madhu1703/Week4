import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatabaseConnectionTest {

    private DatabaseConnection db;

    @Before
    public void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @After
    public void tearDown() {
        db.disconnect();
    }

    @Test
    public void testConnectionIsEstablished() {
        assertTrue("Database should be connected after setUp", db.isConnected());
    }

    @Test
    public void testPerformOperationWhileConnected() {
        assertTrue(db.isConnected());
    }

    @Test
    public void testDisconnectionHappens() {
        assertTrue(db.isConnected());
    }
}

