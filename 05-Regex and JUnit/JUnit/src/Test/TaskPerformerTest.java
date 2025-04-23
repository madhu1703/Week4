import org.junit.Test;
import static org.junit.Assert.*;

public class TaskPerformerTest {

    TaskPerformer performer = new TaskPerformer();

    @Test(timeout = 2000)
    public void testLongRunningTaskTimeout() {
        performer.longRunningTask();
    }

    @Test(timeout = 4000)
    public void testLongRunningTaskPass() {
        String result = performer.longRunningTask();
        assertEquals("Completed", result);
    }
}