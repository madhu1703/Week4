import org.junit.After;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileProcessorTest {

    private final FileProcessor processor = new FileProcessor();
    private final String testFile = "C:\\Users\\madhumitha\\OneDrive\\Documents\\csv\\students.csv";

    @After
    public void cleanUp() {
        File file = new File(testFile);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testWriteAndReadFile() throws IOException {
        String content = "Hello, JUnit!";
        processor.writeToFile(testFile, content);
        File file = new File(testFile);
        assertTrue(file.exists());
        String readContent = processor.readFromFile(testFile);
        assertEquals(content, readContent);
    }

    @Test(expected = IOException.class)
    public void testReadNonExistentFileThrowsException() throws IOException {
        processor.readFromFile("nonexistentfile.txt");
    }
}

