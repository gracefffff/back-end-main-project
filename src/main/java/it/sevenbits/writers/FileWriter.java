package it.sevenbits.writers;
import it.sevenbits.exceptions.WriterException;
import it.sevenbits.intefaces.IWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * this is class to write characters into file
 */
public class FileWriter implements IWriter {
    private BufferedWriter writer;

    /**
     *
     * @param path this is path to file
     * @throws WriterException this exception signals about writing into file errors
     */
    public FileWriter(final String path) throws WriterException {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
        } catch (IOException ex) {
            throw new WriterException(ex.getMessage());
        }
    }

    @Override
    public void write(final char symbol) throws WriterException {
        try {
            writer.append(symbol);
        } catch (IOException ex) {
            throw new WriterException(ex.getMessage());
        }
    }

    /**
     * this method to close stream after writing
     * @throws WriterException this exception signals about writing into file errors
     */
    public void close() throws WriterException {
        try {
            writer.close();
        } catch (IOException ex) {
            throw new WriterException(ex.getMessage());
        }
    }
}
