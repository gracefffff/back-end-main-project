package it.sevenbits.intefaces;

import it.sevenbits.exceptions.LexerException;
import it.sevenbits.exceptions.WriterException;

/**
 * this is interface of formatter
 */
public interface IFormatter {
    /**
     *
     * @param lexer lexer to analyze
     * @param writer this is writer to write characters in stream
     * @throws WriterException This class signals that read error occurred.
     * @throws LexerException  This class signals about Lexer errors
     */
    void format(ILexer lexer, IWriter writer) throws WriterException, LexerException;
}
