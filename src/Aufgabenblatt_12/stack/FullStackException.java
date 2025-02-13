package Aufgabenblatt_12.stack;

/**
 * A custom exception that is thrown when an operation attempts to add an element
 * to a stack that has reached its maximum capacity.
 *
 * This exception can include a default message or a custom message provided at runtime.
 *
 * @author Eduard Wayz
 * @version 1.0
 */
public class FullStackException extends Exception {

    /**
     * Constructs a new FullStackException with a default message indicating that
     * the stack has reached its maximum size.
     */
    public FullStackException() {
        super("Reached maximum size of stack");
    }

    /**
     * Constructs a new FullStackException with a specified custom message.
     *
     * @param message the detail message explaining the exception
     */
    public FullStackException(String message) {
        super(message);
    }
}