package Aufgabenblatt_12.stack;

import java.util.EmptyStackException;

/**
 * An implementation of the StringStack interface using an array.
 * This stack follows the Last In, First Out (LIFO) principle.
 * When the stack is full, it throws a FullStackException.
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class ArrayStack implements StringStack {

    private String[] elements;
    private int currentSize;

    /**
     * Constructor to initialize the stack with a specified capacity.
     *
     * @param capacity the maximum number of elements the stack can hold
     */
    public ArrayStack(int capacity) {
        elements = new String[capacity];
        currentSize = 0;
    }

    /**
     * Adds an element to the top of the stack.
     * If the stack is full, a {@link FullStackException} is thrown.
     *
     * @param element the element to be added to the stack
     * @throws FullStackException if the stack has reached its maximum capacity
     */
    @Override
    public void push(String element) throws FullStackException {
        if (currentSize == elements.length) {
            throw new FullStackException("Stack full: maximum capacity is " + elements.length);
        } else {
            elements[currentSize] = element;
            currentSize++;
        }
    }

    /**
     * Removes and returns the top element of the stack.
     * Throws an {@link EmptyStackException} if the stack is empty.
     *
     * @return the removed top element
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        String topValue = top();
        elements[currentSize - 1] = null;
        currentSize--;
        return topValue;
    }

    /**
     * Returns the top element of the stack without removing it.
     * Throws an {@link EmptyStackException} if the stack is empty.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public String top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[currentSize - 1];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}