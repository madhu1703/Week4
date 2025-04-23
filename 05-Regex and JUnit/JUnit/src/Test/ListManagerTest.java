import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    ListManager manager = new ListManager();

    @Test
    public void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        manager.addElement(list, 20);
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(15);

        manager.removeElement(list, 10);
        assertFalse(list.contains(10));
        assertEquals(2, list.size());
    }

    @Test
    public void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, manager.getSize(list));
        manager.addElement(list, 100);
        manager.addElement(list, 200);
        assertEquals(2, manager.getSize(list));
    }
}

