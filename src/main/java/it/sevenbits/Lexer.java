package it.sevenbits;

import it.sevenbits.exceptions.LexerException;
import it.sevenbits.exceptions.ReaderException;
import it.sevenbits.readers.IReader;


import java.util.HashMap;
import java.util.Map;

/**
 * this class makes constructs characters to tokens
 */
public class Lexer implements ILexer {
    private Map<String, String> hashMap;
    private IReader reader;
    private char currentSymbol;

    /**
     * this is constructor of class Lexer
     * @param reader to read characters from stream
     */
    public Lexer(final IReader reader) {
        hashMap = new HashMap<>();
        hashMap.put(" ", "SPACE");
        hashMap.put("{", "OPENBRACE");
        hashMap.put("}", "CLOSEBRACE");
        hashMap.put(";", "SEMICOLON");
        hashMap.put("\n", "NEWLINE");
        hashMap.put("\t", "TABULATION");
        this.reader = reader;
    }

    private boolean checkLexeme(final String key) {
        return hashMap.containsKey(key);
    }

    private String getValue(final String key) {
        return hashMap.get(key);
    }

    private boolean endToken(final StringBuilder lexeme, final char symbol) {
        return (Character.isWhitespace(symbol) || symbol == ';') && (lexeme.length() != 0);
    }

    @Override
    public boolean hasMoreTokens() {
        return reader.hasNext();
    }

    @Override
    public IToken readToken() throws LexerException {
        StringBuilder lexeme = new StringBuilder();

        try {
            while (reader.hasNext()) {

                if (checkLexeme(String.valueOf(currentSymbol))) {
                    lexeme.append(currentSymbol);
                    currentSymbol = '\u0000';
                    return new Token(getValue(lexeme.toString()), lexeme.toString());
                }
                currentSymbol = reader.read();
                if (endToken(lexeme, currentSymbol)) {
                    break;
                }
                lexeme.append(currentSymbol);
                if (checkLexeme(lexeme.toString())) {
                    currentSymbol = '\u0000';
                    return new Token(getValue(lexeme.toString()), lexeme.toString());
                }
            }
            return new Token("DEFAULT", lexeme.toString());
        } catch (ReaderException ex) {
            throw new LexerException(ex.getMessage());
        }
    }
}
