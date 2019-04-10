package group144.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest<T> {

    @Test
    void emptyTest() throws ValueAlreadyExistsException, ValueNotFoundException {
        LinkedList<Integer> list = new LinkedList<>();
        list.insertBack(5);
        list.removeHead();
        assertEquals(true, list.empty());
    }

    @Test
    void getValueByIndexTest() throws ValueAlreadyExistsException, IndexOutOfBoundsException {
        LinkedList<Integer> list = new LinkedList<>();
        list.insertBack(1);
        list.insertBack(2);
        list.insertFront(3);
        System.out.println(list.head.value);
        assertEquals((Integer)3, list.getValueByIndex(0));
    }

    @Test
    void searchTest() throws ValueAlreadyExistsException {
        LinkedList<Integer> list = new LinkedList<>();
        list.insertBack(1);
        list.insertBack(2);
        list.insertBack(3);
        list.insertBack(3);
        assertEquals((Integer)3, list.search(3).next.value);
    }
}