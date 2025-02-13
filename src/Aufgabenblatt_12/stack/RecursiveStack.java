package Aufgabenblatt_12.stack;

import java.util.EmptyStackException;

/**
 * An implementation of the StringStack interface using a recursive structure.
 * This stack follows the Last In, First Out (LIFO) principle, where each instance
 * represents a node in the stack, holding the top element and a reference to the
 * lower stack.
 *
 * @author Eduard Wayz
 * @version 1.0
 */
public class RecursiveStack implements StringStack {

    private String topElement;
    private RecursiveStack lowerStack;

    /**
     * Constructs an empty RecursiveStack.
     */
    public RecursiveStack() {
        topElement = null;
        lowerStack = null;
    }

    /**
     * Copy constructor to create a new RecursiveStack based on an existing one.
     *
     * @param original the RecursiveStack to be copied
     */
    private RecursiveStack(RecursiveStack original) {
        this.topElement = original.topElement;
        this.lowerStack = original.lowerStack;
    }

    /**
     * Adds an element to the top of the stack.
     * If the stack is empty, the element is added as the top element.
     * Otherwise, the current stack becomes the lower stack, and the new element
     * becomes the new top element.
     *
     * @param element the element to be added to the stack
     */
    @Override
    public void push(String element) {
        if (topElement == null) {
            topElement = element;
        } else {
            lowerStack = new RecursiveStack(this);
            this.topElement = element;
        }
    }

    /**
     * Removes and returns the top element of the stack.
     * If the stack is empty, an {@link EmptyStackException} is thrown.
     *
     * @return the removed top element
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public String pop() {
        if (topElement == null) {
            throw new EmptyStackException();
        }
        String topElement = this.topElement;
        if (lowerStack != null) {
            this.topElement = lowerStack.topElement;
            lowerStack = lowerStack.lowerStack;
        } else {
            this.topElement = null;
        }
        return topElement;
    }

    /**
     * Returns the top element of the stack without removing it.
     * If the stack is empty, an {@link EmptyStackException} is thrown.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public String top() {
        if (!isEmpty()) {
            return topElement;
        } else {
            throw new EmptyStackException();
        }
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return topElement == null;
    }
}