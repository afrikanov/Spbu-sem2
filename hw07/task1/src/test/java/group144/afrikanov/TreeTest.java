package group144.afrikanov;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void sizeTest() throws InvalidSymbolException {
        Tree tree = new Tree();
        tree.add("aa");
        tree.add("aa");
        tree.add("ab");
        tree.add("ca");
        int expectedSize = 3;
        assertEquals(expectedSize, tree.size());
    }

    @Test
    void containsTest() throws InvalidSymbolException {
        Tree tree = new Tree();
        tree.add("a");
        tree.remove("a");
        assertFalse(tree.contains("a"));
        tree.add("b");
        assertTrue(tree.contains("b"));
    }

    @Test
    void invalidString() throws InvalidSymbolException {
        Tree tree = new Tree();
        try {
            tree.add("П");
            assertFalse(false);
        }
        catch (InvalidSymbolException e) {
            assertTrue(true);
        }
    }

    @Test
    void howManyStartWithPrefix() throws InvalidSymbolException {
        Tree tree = new Tree();
        tree.add("aaa");
        tree.add("aab");
        tree.add("aac");
        tree.add("aba");
        tree.add("abc");
        assertEquals(3, tree.howManyStartWithPrefix("aa"));
        assertEquals(2, tree.howManyStartWithPrefix("ab"));
    }

    @Test
    void serializeAndDeserializeTest() throws InvalidSymbolException, IOException, ClassNotFoundException {
        Tree tree = new Tree();
        tree.add("abcd");
        tree.add("abdc");
        tree.add("acbd");
        tree.add("acdb");
        tree.add("adbc");
        FileOutputStream fout = new FileOutputStream("out.txt");
        tree.serialize(fout);
        tree.add("adcb");
        tree.remove("adbc");
        FileInputStream fin = new FileInputStream("out.txt");
        tree.deserialize(fin);
        assertTrue(tree.contains("adbc"));
        assertEquals(5, tree.size());
        assertFalse(tree.contains("adcb"));
    }
}