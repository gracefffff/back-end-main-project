package it.sevenbits;
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
    public void testFormatterSimple() throws ReaderException, WriterException, IOException {
        StringWriter stringWriter = new StringWriter();
        StringReader stringReader = new StringReader("aaa { bb; ccc ; dddd; eee;         }");
        formatter.format(stringReader, stringWriter);
        String test = stringWriter.getOutput();
        String correct = "aaa {\n" +
                "\tbb;\n" +
                "\tccc;\n" +
                "\tdddd;\n" +
                "\teee;\n" +
                "}";
        assertEquals("Wrong result",correct , test);
    }
    @Test
    public void testFormatterCheckTabulation() throws ReaderException, WriterException, IOException {
        StringWriter stringWriter = new StringWriter();
          StringReader stringReader = new StringReader ("aaa   {bbbb;  ddd;  ccc   ;}{  { {{}}}}");

        formatter.format(stringReader,stringWriter);
        String test = stringWriter.getOutput();
        String correct = "aaa {\n" +
                "\tbbbb;\n" +
                "\tddd;\n" +
                "\tccc;\n" +
                "}\n" +
                "{\n" +
                "\t{\n" +
                "\t\t{\n" +
                "\t\t\t{\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
         assertEquals("Wrong result",correct , test);
    }
    @Test
    public void testFormatterHelloWorld() throws ReaderException, WriterException, IOException {
        StringWriter stringWriter = new StringWriter();
        StringReader stringReader = new StringReader ("public class HelloWorld {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        // Prints \"Hello, World\" to the terminal window.\n" +
                "        System.out.println(\"Hello, World\");\n" +
                "    }\n" +
                "}");

        formatter.format(stringReader,stringWriter);
        String test = stringWriter.getOutput();
        String correct = "public class HelloWorld {\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\t// Prints \"Hello, World\" to the terminal window. System.out.println(\"Hello, World\");\n" +
                "\t}\n" +
                "}";
        assertEquals("Wrong result",correct , test);
    }

}
