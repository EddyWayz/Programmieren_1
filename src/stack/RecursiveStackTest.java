/**
 * The RecursiveStackTest class contains unit tests for the RecursiveStack class.
 * It verifies the functionality of the stack operations including creation,
 * copying, pushing, popping, and retrieving the top element.
 * @author Eduard Wayz (193123)
 */

package stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Unit tests for RecursiveStack class.
 */
public class RecursiveStackTest {

    /**
     * Tests if a newly created RecursiveStack is empty.
     */
    @Test
    public void emptyStack() {
        RecursiveStack stack = new RecursiveStack();
        Assert.assertTrue(stack.isEmpty());
        /* Oder so, aber hier nicht moeglich da private Variablen. Unten nochmal
        Assert.assertTrue(stack.topElement == null && stack.lowerStack == null);
         */
    }

    /**
     * Tests the copy constructor of RecursiveStack.
     *
     * Note: This test is not functional due to the private access modifier on the copy constructor
     * and the lowerStack variable. A solution has not been implemented.
     */
    @Test
    public void CopyConstructor() {
        RecursiveStack stack = new RecursiveStack();
        /*
        Dieser Teil funktioniert nicht, da ich durch den Zugriffsmodifikator private nicht auf den Copy Constructor und
        nicht auf die Variable lowerStack zugreifen kann. Mir ist aber keine Loesung eingefallen, weshalb ich das so
        stehen lassen hab.

        RecursiveStack stackCopy = new RecursiveStack(stack);
        Assert.assertFalse(stack == stackCopy);
        Assert.assertEquals(stack.lowerStack, stackCopy);
        */

    }
    /**
     * Tests the push operation of RecursiveStack.
     */
    @Test
    public void push() {
        RecursiveStack stack = new RecursiveStack();
        stack.push("a");

        RecursiveStack stack2 = new RecursiveStack();
        stack2.push("a");
        stack2.push("b");
        stack2.push("c");
    }
    /**
     * Tests the pop operation of RecursiveStack, including edge cases where the stack is empty.
     */
    @Test
    public void pop() {
        RecursiveStack stack = new RecursiveStack();
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
     * Tests the top operation of RecursiveStack, including edge cases where the stack is empty.
     */
    @Test
    public void top() {
        RecursiveStack stack = new RecursiveStack();
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