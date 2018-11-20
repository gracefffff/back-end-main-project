package it.sevenbits.writers;

import it.sevenbits.exceptions.WriterException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileWriter implements IWriter {
    private BufferedWriter writer;

    public FileWriter(final String path) throws IOException {
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
    }

    @Override
    public void write(final char symbol) throws WriterException {
        try {
            writer.append(symbol);
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
