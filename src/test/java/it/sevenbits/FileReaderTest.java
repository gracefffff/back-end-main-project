package it.sevenbits;

import it.sevenbits.exceptions.ReaderException;
import it.sevenbits.exceptions.WriterException;
import it.sevenbits.readers.FileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class FileReaderTest {
    private FileReader fileReader;

    @Before
    public void setUp() throws ReaderException {
        fileReader = new FileReader("1.txt");
    }

    @After
    public void close() throws ReaderException {
        fileReader.close();
    }

    @Test
    public void testFileReader() throws ReaderException {
        String result = "";
        while (fileReader.hasNext()) {
            result += fileReader.read();
        }
        assertEquals("Wrong result", "hello world!", result);
    }
}
