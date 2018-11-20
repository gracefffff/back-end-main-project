package it.sevenbits;
import it.sevenbits.exceptions.LexerException;
import it.sevenbits.exceptions.ReaderException;
import it.sevenbits.exceptions.WriterException;
import it.sevenbits.readers.StringReader;
import it.sevenbits.writers.StringWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
public class FormatterTest {
private Formatter formatter;
    @Before
    public void setUp() {
        this.formatter = new Formatter();
    }

    @Test
    public void testFormatterSimple() throws ReaderException, WriterException, IOException, LexerException {
        StringWriter stringWriter = new StringWriter();
        StringReader stringReader = new StringReader("aaa { bb; ccc ; dddd; eee;         }");
        Lexer lexer = new Lexer(stringReader);
        formatter.format(lexer, stringWriter);
        String test = stringWriter.getOutput();
        String correct = "aaa {\n" +
                "    bb;\n" +
                "    ccc;\n" +
                "    dddd;\n" +
                "    eee;\n" +
                "}";
        assertEquals("Wrong result",correct , test);
    }
    @Test
    public void testFormatterCheckTabulation() throws ReaderException, WriterException, IOException, LexerException {
        StringWriter stringWriter = new StringWriter();
          StringReader stringReader = new StringReader ("aaa   {bbbb;  ddd;  ccc   ;}{  { {{}}}}");
        Lexer lexer = new Lexer(stringReader);
        formatter.format(lexer,stringWriter);
        String test = stringWriter.getOutput();
        String correct = "aaa {\n" +
                "    bbbb;\n" +
                "    ddd;\n" +
                "    ccc;\n" +
                "}\n" +
                "{\n" +
                "    {\n" +
                "        {\n" +
                "            {\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
         assertEquals("Wrong result",correct , test);
    }
    @Test
    public void testFormatterHelloWorld() throws ReaderException, WriterException, IOException, LexerException {
        StringWriter stringWriter = new StringWriter();
        StringReader stringReader = new StringReader ("public class HelloWorld {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        // Prints \"Hello, World\" to the terminal window.\n" +
                "        System.out.println(\"Hello, World\");\n" +
                "    }\n" +
                "}");
        Lexer lexer = new Lexer(stringReader);
        formatter.format(lexer,stringWriter);
        String test = stringWriter.getOutput();
        String correct = "public class HelloWorld {\n" +
                "    public static void main(String[] args) {\n" +
                "        // Prints \"Hello, World\" to the terminal window. System.out.println(\"Hello, World\");\n" +
                "    }\n" +
                "}";
        assertEquals("Wrong result",correct , test);
    }

}
