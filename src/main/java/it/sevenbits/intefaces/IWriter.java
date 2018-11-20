package it.sevenbits.intefaces;

import it.sevenbits.exceptions.WriterException;


/**
 *
 */
public interface IWriter {
    /**
     * @param symbol - symbol , which will be write in stream.
     * @throws WriterException This class signals that read error occurred.
     */
    void write(char symbol) throws WriterException;
}
