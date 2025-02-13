package Aufgabenblatt_12.stack;

/**
 * An interface for a stack that stores String elements.
 * Provides operations for adding, removing, and accessing elements. (LIFO)
 * @author Edaurd Wayz (193123)
 */

public interface StringStack {

    /**
     * Adds an element to the top of the stack.
     *
     * @param element the element to be added to the stack
     */
    void push(String element) throws FullStackException;

    /**
     * Removes and returns the top element of the stack.
     * If the stack is empty, returns null.
     *
     * @return the removed top element, or null if the stack is empty
     */
    String pop();

    /**
     * Returns the top element of the stack without removing it.
     * If the stack is empty, returns null.
     *
     * @return the top element, or null if the stack is empty
     */
    String top();

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

}
