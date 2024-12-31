/**
 * An implementation of the StringStack interface using an array.
 * This stack follows the Last In, First Out (LIFO) principle.
 * When the stack is full, the bottom element is removed to make space.
 *
 * @author Eduard Wayz
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
     * If the stack is full, the bottom element is removed to make space.
     *
     * @param element the element to be added to the stack
     */
    @Override
    public void push(String element) {
        if (currentSize == elements.length) {
            for (int i = 1; i < elements.length; i++) {
                elements[i - 1] = elements[i];
            }
            elements[currentSize-1] = element;

        } else {
            elements[currentSize] = element;
            currentSize++;
        }

    }

    /**
     * Removes and returns the top element of the stack.
     * If the stack is empty, returns null.
     *
     * @return the removed top element, or null if the stack is empty
     */
    @Override
    public String pop() {
        if(isEmpty()) return null;
        String topValue = top();
        elements[currentSize-1] = null;
        currentSize--;
        return topValue;
    }

    /**
     * Returns the top element of the stack without removing it.
     * If the stack is empty, returns null.
     *
     * @return the top element, or null if the stack is empty
     */
    @Override
    public String top() {
        if(isEmpty()) return null;
        return elements[currentSize-1];
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
