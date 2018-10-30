package it.sevenbits.exceptions;

/**
 * This class signals that read error occurred
 */
public class ReaderException extends Exception {
    /**
     *
     * @param message is describe the exceptions
     */
   public ReaderException(final String message) {
        super(message);
    }
}
