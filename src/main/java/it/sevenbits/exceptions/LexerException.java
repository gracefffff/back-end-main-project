package it.sevenbits.exceptions;

/**
 * this class signals about lexer errors
 */
public class LexerException extends Exception {
    /**
     * this exception signals about lexer errors
     * @param message about error
     */
    public LexerException(final String message) {
        super(message);
    }

}
