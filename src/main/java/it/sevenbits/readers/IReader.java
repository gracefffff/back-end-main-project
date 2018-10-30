package it.sevenbits.readers;

import it.sevenbits.exceptions.ReaderException;

import java.io.IOException;

/**
 * this is interface for character reading from stream
 */
public interface IReader {
    /**
     *
     * @return char symbol from stream
     * @throws ReaderException This class signals that read error occurred
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of
     * exceptions produced by failed or interrupted I/O operations.
     */
    char read() throws ReaderException, IOException;

    /**
     *
     * @return boolean value true - next symbol is exist, false - next symbol is not exist
     */
    boolean hasNext();
}
