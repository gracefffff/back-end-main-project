package it.sevenbits;
import it.sevenbits.formatters.Formatter;
import it.sevenbits.lexers.Lexer;
import it.sevenbits.exceptions.LexerException;
import it.sevenbits.exceptions.ReaderException;
import it.sevenbits.exceptions.WriterException;
import it.sevenbits.lexers.sm.LexerStateMachine;
import it.sevenbits.readers.FileReader;
import it.sevenbits.writers.FileWriter;

/**
 * main class
 */
public final class Main {
    private Main() {
    }

    /**
     * @param args from commands line
     * @throws ReaderException This class signals that read error occurred
     * @throws WriterException This class signals that read error occurred
     * @throws LexerException This class signals about Lexer errors
     */
    public static void main(final String[] args) throws ReaderException, WriterException, LexerException {
        Formatter formatter = new Formatter();
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        Lexer lexer = new Lexer(fileReader);
        LexerStateMachine lexerStateMachine = new LexerStateMachine(fileReader);
        formatter.format(lexerStateMachine, fileWriter);
        fileReader.close();
        fileWriter.close();
    }
}