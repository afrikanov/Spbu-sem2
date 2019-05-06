package task2.hw2.afrikanov;

import org.junit.jupiter.api.Test;

import java.net.Inet4Address;

import static org.junit.jupiter.api.Assertions.*;

class StackArrayTest {

    @Test
    void fullStackTest() throws FullStackException {
        Stack<Character> stack = new StackArray<>();
        for (int i = 0; i < (int)1e5; ++i) {
            stack.push('a');
        }
        assertThrows(FullStackException.class, () -> stack.push('b'));
    }

    @Test
    void emptyStackTest() throws EmptyStackException {
        Stack<Boolean> stack = new StackArray<>();
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void topTest() throws FullStackException {
        Stack<Integer> stack = new StackArray<>();
        stack.push(7);
        stack.push(8);
        stack.push(5);
        assertEquals(5, stack.getTop());
    }

    @Test
    void sizeTest() throws FullStackException {
        Stack<Integer> stack = new StackArray<>();
        stack.push(7);
        stack.push(8);
        stack.push(5);
        assertEquals(3, stack.getSize());
    }

    @Test
    void emptyTest() throws FullStackException, EmptyStackException {
        int current = 5;
        Stack<Integer> stack = new StackArray<>();
        stack.push(7);
        stack.pop();
        stack.push(5);
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}