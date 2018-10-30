package it.sevenbits.writers;

import it.sevenbits.exceptions.WriterException;

import java.io.IOException;

/**
 *
 */
public interface IWriter {
    /**
     * @param symbol - symbol , which will be write in stream
     * @throws IOException     Signals that an I/O exception of some sort has occurred. This class is the general class of
     *                         exceptions produced by failed or interrupted I/O operations.
     * @throws WriterException This class signals that read error occurred.
     */
    void write(char symbol) throws IOException, WriterException;
}
