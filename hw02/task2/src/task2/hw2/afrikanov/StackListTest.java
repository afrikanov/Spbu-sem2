package task2.hw2.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackListTest {

    @Test
    void emptyStackTest() throws EmptyStackException {
        Stack<Boolean> stack = new StackList<>();
        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

    @Test
    void topTest() throws FullStackException {
        Stack<Integer> stack = new StackList<>();
        stack.push(7);
        stack.push(8);
        stack.push(5);
        assertEquals(5, stack.getTop());
    }

    @Test
    void sizeTest() throws FullStackException {
        Stack<Integer> stack = new StackList<>();
        stack.push(7);
        stack.push(8);
        stack.push(5);
        assertEquals(3, stack.getSize());
    }

    @Test
    void emptyTest() throws FullStackException, EmptyStackException {
        Stack<Integer> stack = new StackList<>();
        stack.push(7);
        stack.pop();
        stack.push(5);
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}