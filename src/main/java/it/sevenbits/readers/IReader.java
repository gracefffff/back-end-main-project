package it.sevenbits.readers;

import it.sevenbits.exceptions.ReaderException;


/**
 * this is interface for character reading from stream
 */
public interface IReader {
    /**
     *
     * @return char symbol from stream
     * @throws ReaderException This class signals that read error occurred
     */
    char read() throws ReaderException;

    /**
     *
     * @return boolean value true - next symbol is exist, false - next symbol is not exist
     */
    boolean hasNext();
}
