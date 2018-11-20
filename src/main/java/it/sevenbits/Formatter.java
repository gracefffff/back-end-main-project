package it.sevenbits;

import it.sevenbits.exceptions.LexerException;
import it.sevenbits.exceptions.ReaderException;
import it.sevenbits.exceptions.WriterException;
import it.sevenbits.readers.IReader;
import it.sevenbits.writers.IWriter;


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

    private void addTransition(final IWriter writer) throws WriterException {
        writer.write('\n');
        previousSymbol = '\n';
    }

    private void addTabulation(final IWriter writer) throws WriterException {
        final int countSpace = 4;
        if (previousSymbol == '\n') {
            for (int j = 0; j < this.level; ++j) {
                for (int i = 0; i < countSpace; i++) {
                    writer.write(' ');
                }
            }
        } else {
            if (whitespace) {
                writer.write(' ');
            }
        }
    }

    /**
     * format this method for modifying code to java code from stream
     *
     * @param reader this object to read character from stream
     * @param writer this object to write characters in stream
     * @throws ReaderException This class signals that read error occurred
     * @throws WriterException This class signals that read error occurred.
     */
    public void format(final ILexer lexer, final IWriter writer) throws ReaderException, WriterException, LexerException {
        char currentSymbol;
        final int countSpace = 4;
        while (lexer.hasMoreTokens()) {
            //currentSymbol = reader.read();
            IToken token = lexer.readToken();
            switch (token.getName()) {
                case "SEMICOLON":
                    for (int i = 0; i < token.getLexeme().length(); i++) {
                        writer.write(token.getLexeme().charAt(i));
                    }
                    addTransition(writer);
                    whitespace = false;
                    break;
                case "OPENBRACE":
                    addTabulation(writer);
                    if (previousSymbol == ' ') {
                        writer.write(previousSymbol);
                    }
                    for (int i = 0; i < token.getLexeme().length(); i++) {
                        writer.write(token.getLexeme().charAt(i));
                    }
                    addTransition(writer);
                    level++;
                    whitespace = false;
                    break;
                case "CLOSEBRACE":
                    level--;
                    if (previousSymbol == '\n') {
                        for (int j = 0; j < this.level; ++j) {
                            for (int i = 0; i < countSpace; i++) {
                                writer.write(' ');
                            }
                        }
                    }
                    for (int i = 0; i < token.getLexeme().length(); i++) {
                        writer.write(token.getLexeme().charAt(i));
                    }
                    if (lexer.hasMoreTokens()) {
                        addTransition(writer);
                    }
                    whitespace = false;
                    break;
                case "SPACE":
                    if (previousSymbol != '\u0000') {
                        whitespace = true;
                    }
                    break;
                case "NEWLINE":
                    break;
                case "TABULATION":
                    break;
                default:
                    addTabulation(writer);
                    for (int i = 0; i < token.getLexeme().length(); i++) {
                        writer.write(token.getLexeme().charAt(i));
                    }
                    previousSymbol = token.getLexeme().charAt(token.getLexeme().length() - 1);
                    whitespace = false;
                    break;
            }
        }
    }
}
