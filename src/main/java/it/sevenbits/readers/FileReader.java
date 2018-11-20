package it.sevenbits.readers;

import it.sevenbits.exceptions.ReaderException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * this class implemented interface IReader
 * this class to read characters from file
 */
public class FileReader implements IReader {
    private BufferedReader reader;
    private int symbol;

    /**
     * @param path this is path to file
     * @throws ReaderException this exception signals about reading file errors
     */
    public FileReader(final String path) throws ReaderException {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            symbol = reader.read();
        } catch (IOException ex) {
            throw new ReaderException(ex.getMessage());
        }
    }

    @Override
    public char read() throws ReaderException {
        char currentSymbol;
        try {
            currentSymbol = (char) symbol;
            symbol = reader.read();
            return currentSymbol;
        } catch (IOException ex) {
            throw new ReaderException(ex.getMessage());
        }
    }

    @Override
    public boolean hasNext() {
        return symbol != -1;
    }

    /**
     * this method to close stream after reading
     * @throws ReaderException this exception signals about reading file errors
     */
    public void close() throws ReaderException {
        try {
            reader.close();
        } catch (IOException ex) {
            throw new ReaderException(ex.getMessage());
        }
    }
}
