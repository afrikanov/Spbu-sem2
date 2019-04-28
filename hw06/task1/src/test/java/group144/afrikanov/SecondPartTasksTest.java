package group144.afrikanov;

import org.junit.jupiter.api.Test;

import java.util.*;
import static group144.afrikanov.SecondPartTasks.*;
import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

public class SecondPartTasksTest {

    @Test
    public void testFindQuotes() {
        assertEquals(findQuotes(Arrays.asList("ab", "ac", "c"), "a"), Arrays.asList("ab", "ac"));
        assertEquals(findQuotes(Arrays.asList("abcd", "abcde", "abcdef"), "abcde"), Arrays.asList("abcde", "abcdef"));
    }

    @Test
    public void testPiDividedBy4() {
        final double DELTA = 1e-3;
        assertEquals(piDividedBy4(), PI / 4, DELTA);
    }

    @Test
    public void testFindPrinter() {
        Map<String, List<String>> compositions = new HashMap<>();
        compositions.put("Esenin", Arrays.asList("aa", "bb", "cc"));
        compositions.put("Chehov", Arrays.asList("ab", "ac", "ad"));
        compositions.put("Pushkin", Arrays.asList("ba", "bc", "bdd"));
        assertEquals("Pushkin", findPrinter(compositions));
        compositions.put("Tolstoy", Arrays.asList("a1a2a3a4", "b5b6b7b8", "c1c2c3"));
        assertEquals("Tolstoy", findPrinter(compositions));
    }

    @Test
    public void testCalculateGlobalOrder() {
        List<Map<String, Integer>> orders = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            orders.add(new HashMap<>());
        }
        orders.get(0).put("Apples", 100);
        orders.get(0).put("Chocolates", 50);
        orders.get(0).put("Tomatoes", 20);
        orders.get(0).put("Sausages", 1);
        orders.get(1).put("Apples", 110);
        orders.get(1).put("Chocolates", 60);
        orders.get(1).put("Tomatoes", 30);
        orders.get(1).put("Sausages", 11);
        orders.get(2).put("Apples", 120);
        orders.get(2).put("Chocolates", 70);
        orders.get(2).put("Tomatoes", 40);
        orders.get(2).put("Sausages", 21);
        Map<String, Integer> answer = new HashMap<>();
        answer.put("Apples", 330);
        answer.put("Chocolates", 180);
        answer.put("Tomatoes", 90);
        answer.put("Sausages", 33);
        assertEquals(answer, SecondPartTasks.calculateGlobalOrder(orders));
    }
}