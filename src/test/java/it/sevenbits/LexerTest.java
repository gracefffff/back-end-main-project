package it.sevenbits;

import it.sevenbits.exceptions.LexerException;
import it.sevenbits.exceptions.ReaderException;
import it.sevenbits.readers.FileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;


public class LexerTest {
    private Lexer lexer;
    private FileReader reader;
    @Before
    public void setUp() throws ReaderException {
        reader = new FileReader("src/test/java/it/sevenbits/text.txt");
        lexer = new Lexer(reader);
    }
    @After
    public void close() throws ReaderException {
        reader.close();
    }
    @Test
    public void testLexerReadToken() throws LexerException {
        StringBuilder result = new StringBuilder();
        while(lexer.hasMoreTokens()) {
           result.append(lexer.readToken().getName());
           result.append(' ');
        }
        assertEquals("Wrong result","CLOSEBRACE SPACE CLOSEBRACE SPACE OPENBRACE SPACE OPENBRACE DEFAULT SEMICOLON SPACE NEWLINE ",result.toString());

    }



}
