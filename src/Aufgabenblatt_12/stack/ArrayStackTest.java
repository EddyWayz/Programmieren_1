package stack;

/**
 * The ArrayStackTest class contains unit tests for the ArrayStack class.
 * It verifies the functionality of stack operations including checking if the stack is empty,
 * pushing elements, popping elements, and retrieving the top element.
 * @author Eduard Wayz (193123)
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

/**
 * Unit tests for ArrayStack class.
 */
public class ArrayStackTest {
    /**
     * Tests if a newly created ArrayStack is empty.
     */
    @Test
    public void emptyStack() {
        ArrayStack stack = new ArrayStack(10);
        Assert.assertTrue(stack.isEmpty());
        /* Oder so, aber hier nicht moeglich da private Variablen. Unten nochmal.
        boolean check = false;
        for(int i = 0; i<stack.elements.length; i++){
            if(stack.elements[i] != null) check = true;
        }
        Assert.assertTrue(check == false);
         */
    }
    /**
     * Tests the push operation of ArrayStack, including handling the stack being full.
     *
     * @throws FullStackException if the stack is full and an element cannot be added.
     */
    @Test
    public void push() throws FullStackException {
        ArrayStack stack = new ArrayStack(2);
        stack.push("a");

        ArrayStack stack2 = new ArrayStack(2);
        stack2.push("a");
        stack2.push("b");
        String failMessage = "";
        try {
            stack2.push("c");
        } catch (FullStackException e) {
            failMessage = "Der Stack ist voll";
        }

        Assert.assertEquals("Der Stack ist voll", failMessage);

    }
    /**
     * Tests the pop operation of ArrayStack, including handling the stack being empty.
     *
     * @throws FullStackException if the stack is full during setup for the test.
     */
    @Test
    public void pop() throws FullStackException {
        ArrayStack stack = new ArrayStack(10);
        String failMessage = "";
        try {
            stack.pop();
        } catch (Exception e) {
            failMessage = "Der Stack ist leer";
        }
        Assert.assertEquals("Der Stack ist leer", failMessage);

        stack.push("a");
        Assert.assertEquals("a", stack.pop());
        Assert.assertTrue(stack.isEmpty());

        stack.push("a");
        stack.push("b");
        stack.push("c");
        Assert.assertEquals("c", stack.pop());
        // Assert.assertTrue(stack.topElement == "b");  Nicht moeglich da topElement private ist
        Assert.assertFalse(stack.isEmpty());
    }
    /**
     * Tests the top operation of ArrayStack, including handling the stack being empty.
     *
     * @throws FullStackException if the stack is full during setup for the test.
     */
    @Test
    public void top() throws FullStackException{
        ArrayStack stack = new ArrayStack(10);
        String failMessage = "";
        try {
            stack.top();
        } catch (Exception e) {
            failMessage = "Der Stack ist leer";
        }
        Assert.assertEquals("Der Stack ist leer", failMessage);

        stack.push("a");

        Assert.assertEquals("a", stack.top());
    }

}