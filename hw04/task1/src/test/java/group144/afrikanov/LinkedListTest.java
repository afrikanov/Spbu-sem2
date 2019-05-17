package group144.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void insertTest() throws IndexOutOfBoundsException, ValueAlreadyExistsException {
        LinkedList<Integer> list = new LinkedList<>();
        list.insertBack(5);
        assertEquals(5, (int)list.getValueByIndex(0));
        list.insertFront(4);
        assertEquals(4, (int)list.getValueByIndex(0));
    }

    @Test
    void emptyTest() throws ValueAlreadyExistsException, ValueNotFoundException {
        LinkedList<Character> list = new LinkedList<>();
        list.insertBack('5');
        assertFalse(list.isEmpty());
        list.removeHead();
        assertTrue(list.isEmpty());
    }

    @Test
    void getValueByIndexTest() throws ValueAlreadyExistsException, IndexOutOfBoundsException {
        LinkedList<Integer> list = new LinkedList<>();
        list.insertBack(1);
        list.insertBack(2);
        list.insertFront(3);
        assertEquals((Integer)3, list.getValueByIndex(0));
    }

    @Test
    void searchTest() throws ValueAlreadyExistsException {
        LinkedList<Integer> list = new LinkedList<>();
        list.insertBack(1);
        list.insertBack(2);
        list.insertBack(3);
        assertNull(list.search(4));
        assertNotNull(list.search(3));
    }
}