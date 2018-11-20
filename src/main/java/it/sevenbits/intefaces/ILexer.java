package it.sevenbits.intefaces;
import it.sevenbits.exceptions.LexerException;

/**
 * this is interface of lexer
 */
public interface ILexer {
    /**
     *
     * @return true - next token are exist, false - not exist
     */
    boolean hasMoreTokens();

    /**
     *
     * @return IToken this is a characters constructing to tokens
     * @throws LexerException this is exceptions signals about lexer errors
     */
    IToken readToken() throws LexerException;


}
