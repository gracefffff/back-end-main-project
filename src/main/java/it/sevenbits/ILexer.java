package it.sevenbits;

import it.sevenbits.exceptions.LexerException;

public interface ILexer {
    boolean hasMoreTokens();
    IToken readToken() throws LexerException;


}
