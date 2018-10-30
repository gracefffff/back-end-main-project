package it.sevenbits.exceptions;

/**
 * This class signals that read error occurred
 */
public class WriterException extends Exception {
    /**
     *
     * @param message this is message which describe the exception
     */
    public WriterException(final String message) {
        super(message);
    }
}
