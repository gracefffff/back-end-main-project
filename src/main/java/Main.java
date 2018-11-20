import it.sevenbits.Formatter;
import it.sevenbits.Lexer;
import it.sevenbits.exceptions.LexerException;
import it.sevenbits.exceptions.ReaderException;
import it.sevenbits.exceptions.WriterException;
import it.sevenbits.readers.FileReader;
import it.sevenbits.readers.IReader;
import it.sevenbits.readers.StringReader;
import it.sevenbits.writers.FileWriter;
import it.sevenbits.writers.StringWriter;

import java.io.IOException;


/**
 * main class
 */
public final class Main {
    private Main() {
    }

    /**
     * @param args from command line
     * @throws ReaderException This class signals that read error occurred
     * @throws WriterException This class signals that read error occurred
     */
    public static void main(final String[] args) throws ReaderException, WriterException, LexerException, IOException {
        Formatter formatter = new Formatter();
        StringWriter stringWriter = new StringWriter();
        StringReader stringReader = new StringReader("public class HelloWorld {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        // Prints \"Hello, World\" to the terminal window.\n" +
                "        System.out.println(\"Hello, World\");\n" +
                "    }\n" +
                "}");
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);


        Lexer lexer = new Lexer(fileReader);

        formatter.format(lexer, fileWriter);


        fileReader.close();
        fileWriter.close();
        System.out.print(stringWriter.getOutput());
    }
}