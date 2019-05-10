package group144.afrikanov;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortedSetTest {

    @Test
    void sort() {
        LinkedList<LinkedList<String>> allStrings = new LinkedList<>();
        String line11 = "123";
        String line12 = "13";
        LinkedList<String> list1 = new LinkedList<>();
        list1.add(line11);
        list1.add(line12);
        String line21 = "123";
        String line22 = "123";
        String line23 = "1232";
        LinkedList<String> list2 = new LinkedList<>();
        list2.add(line21);
        list2.add(line22);
        list2.add(line23);
        allStrings.add(list1);
        allStrings.add(list2);
        SortedSet<String> set = new SortedSet<>(allStrings);
        LinkedList<LinkedList<String>> expected = new LinkedList<>();
        expected.add(list1);
        expected.add(list2);
        assertEquals(expected, set.list);
    }
}