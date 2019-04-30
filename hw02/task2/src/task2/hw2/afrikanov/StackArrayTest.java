package task2.hw2.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackArrayTest {

    @Test
    void top() throws FullStackException {
        int current = 5;
        Stack stack = new StackArray();
        stack.push(7);
        stack.push(8);
        stack.push(5);
        assertEquals(stack.top(), current);
    }

    @Test
    void size() throws FullStackException {
        int current = 3;
        Stack stack = new StackArray();
        stack.push(7);
        stack.push(8);
        stack.push(5);
        assertEquals(stack.getSize(), current);
    }

    @Test
    void empty() throws FullStackException, EmptyStackException {
        int current = 5;
        Stack stack = new StackArray();
        stack.push(7);
        stack.pop();
        stack.push(5);
        stack.pop();
        assertEquals(stack.isEmpty(), true);
    }
}