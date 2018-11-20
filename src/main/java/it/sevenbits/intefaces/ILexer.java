package it.sevenbits.intefaces;

import it.sevenbits.exceptions.LexerException;

public interface ILexer {
    boolean hasMoreTokens();
    IToken readToken() throws LexerException;


}
