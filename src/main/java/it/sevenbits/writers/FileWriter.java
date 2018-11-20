package it.sevenbits.writers;

import it.sevenbits.exceptions.WriterException;

import java.io.*;

public class FileWriter implements IWriter {
    private BufferedWriter writer;

    public FileWriter(final String path) throws IOException {
        writer = new BufferedWriter(new OutputStreamWriter((new FileOutputStream(path))));
    }

    @Override
    public void write(final char symbol) throws WriterException {
        try {
            writer.write(symbol);
        } catch (IOException ex) {
            throw new WriterException(ex.getMessage());
        }
    }

    public void close() throws WriterException {
        try {
            writer.close();
        } catch (IOException ex) {
            throw new WriterException(ex.getMessage());
        }
    }
}
