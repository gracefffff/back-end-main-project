package it.sevenbits;

import it.sevenbits.exceptions.LexerException;
import it.sevenbits.exceptions.ReaderException;
import it.sevenbits.readers.FileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class LexerTest {
    private Lexer lexer;
    private Lexer lexer1;
    private FileReader reader;
    private FileReader reader1;

    @Before
    public void setUp() throws ReaderException {
        reader = new FileReader("src/test/java/it/sevenbits/text.txt");
        lexer = new Lexer(reader);
        reader1 = mock(FileReader.class);
        lexer1 = new Lexer(reader1);
    }
    @After
    public void close() throws ReaderException {
        reader.close();
    }
    @Test
    public void SimpleTestLexerReadToken() throws LexerException {
        StringBuilder result = new StringBuilder();
        while(lexer.hasMoreTokens()) {
           result.append(lexer.readToken().getName());
           result.append(' ');
        }
        assertEquals("Wrong result","CLOSEBRACE SPACE CLOSEBRACE SPACE OPENBRACE SPACE OPENBRACE DEFAULT SEMICOLON SPACE NEWLINE ",result.toString());
    }
    @Test
    public void TestLexerReadToken() throws LexerException, ReaderException {
        StringBuilder result = new StringBuilder();
        when(reader1.read()).thenReturn('}').thenReturn('{').thenReturn('a').thenReturn(' ');
        when(reader1.hasNext()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        while(lexer1.hasMoreTokens()) {
            result.append(lexer1.readToken().getName());
            result.append(' ');
        }
        assertEquals("Wrong result","CLOSEBRACE OPENBRACE DEFAULT SPACE ",result.toString());
    }



}
