package it.sevenbits;
import it.sevenbits.exceptions.ReaderException;
import it.sevenbits.readers.FileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class FileReaderTest {
    private FileReader fileReader;

    @Before
    public void setUp() throws ReaderException {
        fileReader = new FileReader("src/test/java/it/sevenbits/1.txt");
    }

    @After
    public void close() throws ReaderException {
        fileReader.close();
    }

    @Test
    public void testFileReader() throws ReaderException {
        StringBuilder result = new StringBuilder();
        while (fileReader.hasNext()) {
            result.append(fileReader.read());
        }
        assertEquals("Wrong result", "hello world!\n", result.toString());
    }
}
