package group144.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueListTest {

    @Test
    void insertEqualToBack() throws ValueAlreadyExistsException {
        UniqueList<Integer> list = new UniqueList<>();
        list.insertBack(5);
        assertThrows(ValueAlreadyExistsException.class, () -> list.insertBack(5));
    }

    @Test
    void insertEqualToFrontTest() throws ValueAlreadyExistsException {
        UniqueList<Character> list = new UniqueList<>();
        list.insertFront('a');
        list.insertFront('b');
        assertThrows(ValueAlreadyExistsException.class, () -> list.insertFront('a'));
    }

    @Test
    void insertEqualAfter() throws ValueAlreadyExistsException, InvalidInputNode {
        UniqueList<Integer> list = new UniqueList<>();
        list.insertAfter(null, 5);
        LinkedList<Integer>.Node<Integer> nodeBefore = list.search(5);
        assertThrows(ValueAlreadyExistsException.class, () -> list.insertAfter(nodeBefore, 5));
    }
}