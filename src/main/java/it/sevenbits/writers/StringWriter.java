package it.sevenbits.writers;

import it.sevenbits.intefaces.IWriter;

/**
 * this class do charachter writing in String
 */
public class StringWriter implements IWriter {
    /**
     * constructor for this class
     */
    public StringWriter() {
        output = new StringBuilder();
    }

    private StringBuilder output;

    /**
     * @param symbol - symbol , which will be write in stream
     */
    public void write(final char symbol) {
        output.append(symbol);
    }

    public String getOutput() {
        return output.toString();
    }
}