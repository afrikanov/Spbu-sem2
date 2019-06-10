package group144.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final int SIZE = (int)1e5 + 7;

    @Test
    void testAdding() {
        HashTable hashTable = new HashTable(new PolynomialHashFunction());
        hashTable.add("123");
        assertTrue(hashTable.contains("123"));
    }

    @Test
    void testDeleting() throws Exception {
        HashTable hashTable = new HashTable(new XorHashFunction());
        hashTable.add("abc");
        hashTable.delete("abc");
        assertFalse(hashTable.contains("abc"));
    }

    @Test
    void testMaxLength() {
        HashTable hashTable = new HashTable(new MultiplyHashFunction());
        hashTable.add("Hello");
        hashTable.add("Hello");
        hashTable.add("Hello");
        hashTable.add("Bye");
        hashTable.add("Bye");
        assertEquals(3, hashTable.getMaxListSize());
    }
}