import it.sevenbits.Formatter;
import it.sevenbits.exceptions.ReaderException;
import it.sevenbits.exceptions.WriterException;
import it.sevenbits.readers.StringReader;
import it.sevenbits.writers.StringWriter;


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
    public static void main(final String[] args) throws ReaderException, WriterException {
        Formatter formatter = new Formatter();
        StringWriter stringWriter = new StringWriter();
        StringReader stringReader = new StringReader("{{{{}}}}");
        formatter.format(stringReader, stringWriter);
        System.out.print(stringWriter.getOutput());
    }
}