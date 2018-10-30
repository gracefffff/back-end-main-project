package it.sevenbits.readers;

import it.sevenbits.exceptions.ReaderException;

/**
 * class to read the characters from String
 */
public class StringReader implements IReader {
    private String input;
    private int index;

    /**
     * @param input String from which characters will be read
     * @throws ReaderException his class signals that read error occurred
     */
    public StringReader(final String input) throws ReaderException {
        if (input == null || input.length() == 0) {
            throw new ReaderException("This string is empty");
        }
        this.input = input;
        index = 0;
    }

    /**
     * this function reading symbol fron String
     *
     * @return symbol from String
     */
    public char read() {
        index++;

        return input.charAt(index - 1);
    }

    /**
     * this function checks existence of next symbol
     *
     * @return boolean value, true - next symbol exist, false - is not exist
     */
    public boolean hasNext() {
        return index <= input.length() - 1;
    }
}
