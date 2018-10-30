package it.sevenbits;
import it.sevenbits.exceptions.ReaderException;
import it.sevenbits.exceptions.WriterException;
import it.sevenbits.readers.IReader;
import it.sevenbits.writers.IWriter;

import java.io.IOException;

/**
 * class for modifying code in Java-code
 */
public class Formatter {
    private int level;

    /**
     * this is constructor for this class
     */
    public Formatter() {
        level = 0;
    }

    private char previousSymbol;
    private boolean whitespace;

    private void addTransition(final IWriter writer) throws WriterException, IOException {
        writer.write('\n');
        previousSymbol = '\n';
    }

    private void addTabulation(final IWriter writer) throws WriterException, IOException {
        if (previousSymbol == '\n') {
            for (int j = 0; j < this.level; ++j) {
                writer.write('\t');
            }
        } else {
            if (whitespace) {
                writer.write(' ');
            }
        }
    }

    /**
     * format this method for modifying code to java code from stream
     * @param reader this object to read charachters from stream
     * @param writer this object to write charachters in stream
     * @throws ReaderException This class signals that read error occurred
     * @throws WriterException This class signals that read error occurred
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of
     *                             exceptions produced by failed or interrupted I/O operations.
     */
    public void format(final IReader reader, final IWriter writer) throws ReaderException, WriterException, IOException {
        char currentSymbol;
        while (reader.hasNext()) {
            currentSymbol = reader.read();
            switch (currentSymbol) {
                case ';':
                    writer.write(currentSymbol);
                    addTransition(writer);
                    whitespace = false;
                    break;
                case '{':
                    addTabulation(writer);
                    if (previousSymbol == ' ') {
                        writer.write(previousSymbol);
                    }
                    writer.write(currentSymbol);
                    addTransition(writer);
                    level++;
                    whitespace = false;
                    break;
                case '}':
                    level--;
                    if (previousSymbol == '\n') {
                        for (int j = 0; j < this.level; ++j) {
                            writer.write('\t');
                        }
                    }
                    writer.write(currentSymbol);
                    if (reader.hasNext()) {
                        addTransition(writer);
                    }
                    whitespace = false;
                    break;
                case ' ':
                    if (previousSymbol != '\u0000') {
                        whitespace = true;
                    }
                    break;
                case '\n':
                    break;
                case '\t':
                    break;
                default:
                    addTabulation(writer);
                    writer.write(currentSymbol);
                    previousSymbol = currentSymbol;
                    whitespace = false;
                    break;
            }
        }
    }
}