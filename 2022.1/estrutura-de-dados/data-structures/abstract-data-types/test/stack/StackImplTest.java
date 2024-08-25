package test.stack;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import src.stack.StackImpl;
import src.stack.exceptions.StackOverflowException;
import src.stack.exceptions.StackUnderflowException;

public class StackImplTest {

    private static final int STACK_SIZE = 10;
    private StackImpl<Integer> stack = new StackImpl<Integer>(STACK_SIZE);


    @Test
    public void testPushEmptyStack() {
        this.stack.push(1);
        assertEquals(Integer.valueOf(1), this.stack.peek());
    }

    @Test
    public void testPushStackOverflowException() {
        for (int i = 0; i < STACK_SIZE; i++) {
            this.stack.push(i);
        }
        assertThrows(StackOverflowException.class, () -> {
            this.stack.push(5);
        });
    }

    @Test
    public void testPop() {
        this.stack.push(1);
        assertEquals(1, this.stack.pop());
    }

    @Test
    public void testPopStackUnderflowException() {
        assertThrows(StackUnderflowException.class, () -> {
            this.stack.pop();
        });
    }

    @Test
    public void testPeek() {
        this.stack.push(1);
        this.stack.push(2);
        assertEquals(2, this.stack.peek());
        this.stack.pop();
        assertEquals(1, this.stack.peek());
    }

    @Test
    public void testPeekStackUnderflowException() {
        assertThrows(StackUnderflowException.class, () -> {
            this.stack.peek();
        });
    }

    @Test
    public void testIsEmpty() {
        assertTrue(this.stack.isEmpty());
        this.stack.push(1);
        assertFalse(this.stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(this.stack.isFull());

        for (int i = 0; i < STACK_SIZE; i++) {
            this.stack.push(i);
        }

        assertTrue(this.stack.isFull());

    }

}
