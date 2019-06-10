package group144.afrikanov;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

public class AVLTreeTest {

    @Test
    public void sizeTest() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(5);
        assertEquals(1, tree.size());
        tree.add(6);
        assertEquals(2, tree.size());
    }

    @Test
    public void printTest() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(1);
        String expected = "1 5 6 7 ";
        assertEquals(expected, tree.print());
        assertEquals(tree.getRootKey(), (Integer)6);
    }

    @Test
    public void isEmptyTest() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(5);
        assertFalse(tree.isEmpty());
        tree.remove(5);
        assertTrue(tree.isEmpty());
        tree.print();
    }

    @Test
    public void addTest() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(5);
        tree.add(6);
        tree.add(5);
        assertEquals(2, tree.size());
    }

    @Test
    public void containsTest() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(5);
        tree.add(6);
        tree.add(4);
        assertTrue(tree.contains(6));
        tree.remove(6);
        assertFalse(tree.contains(6));
    }

    @Test
    public void toArrayTest () {
        AVLTree<String> tree = new AVLTree<>();
        tree.add("a");
        tree.add("b");
        String[] result = new String[]{"a", "b"};
        assertArrayEquals(result, tree.toArray());
    }

    @Test
    public void clearTest() {
        AVLTree<Integer> tree = new AVLTree<>();
        assertTrue(tree.isEmpty());
        tree.add(10);
        tree.add(11);
        tree.add(12);
        assertFalse(tree.isEmpty());
        tree.clear();
        assertTrue(tree.isEmpty());
    }

    @Test
    public void addAllTest() {
        AVLTree<Integer> tree = new AVLTree<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(90);
        list.add(91);
        tree.add(92);
        assertTrue(tree.addAll(list));
        assertEquals(3, tree.size());
    }

    @Test
    public void iteratorNextTest() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(777);
        tree.add(888);
        Iterator<Integer> iterator = tree.iterator();
        assertTrue(iterator.hasNext());
        assertEquals((Integer)777, iterator.next());
        assertEquals((Integer)888, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorExceptionTest() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.add(777);
        tree.add(888);
        Iterator<Integer> iterator = tree.iterator();
        for (int i = 0; i < tree.size(); ++i) {
            iterator.next();
        }
        Assertions.assertThrows(NoNextElementException.class, () -> iterator.next());
    }
}