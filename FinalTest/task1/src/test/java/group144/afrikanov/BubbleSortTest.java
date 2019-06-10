package group144.afrikanov;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private Random random = new Random();
    private static final int RANDOM_SIZE = (int)1e4;
    private BubbleSort<Integer> intSorter = new BubbleSort<>();
    private Comparator<Integer> intComparator = Integer::compareTo;
    private BubbleSort<String> stringSorter = new BubbleSort<>();
    private Comparator<String> stringComparator = String::compareTo;

    @Test
    public void emptyListTest() throws NullComparatorException {
        List<Integer> list = new ArrayList<>();
        assertEquals(new ArrayList<Integer>(), intSorter.sort(intComparator, list));
    }

    @Test
    public void exceptionTest() throws NullComparatorException {
        assertThrows(NullComparatorException.class, () -> intSorter.sort(null, new ArrayList<>()));
    }

    @Test
    public void sortedListTest() throws NullComparatorException {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> sortedList = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(sortedList, intSorter.sort(intComparator, list));
    }

    @Test
    public void equalListTest() throws NullComparatorException {
        List<Integer> list = Arrays.asList(10, 10, 10, 10);
        List<Integer> sortedList = Arrays.asList(10, 10, 10, 10);
        assertEquals(sortedList, intSorter.sort(intComparator, list));
    }

    @Test
    public void oneElementTest() throws NullComparatorException {
        List<Integer> list = Arrays.asList(10);
        List<Integer> sortedList = Arrays.asList(10);
        assertEquals(sortedList, intSorter.sort(intComparator, list));
    }

    @Test
    public void reversedListTest() throws NullComparatorException {
        List<String> list = Arrays.asList("6", "5", "4", "3", "2", "1");
        List<String> sortedList = Arrays.asList("1", "2", "3", "4", "5", "6");
        assertEquals(sortedList, stringSorter.sort(stringComparator, list));
    }

    @Test
    public void randomListTest() throws NullComparatorException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < RANDOM_SIZE; i++) {
            list.add(random.nextInt());
        }
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        assertEquals(sortedList, intSorter.sort(intComparator, list));
    }

    @Test
    public void myStringLenghtComparatorTest() throws NullComparatorException {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        BubbleSort<String> mySorter = new BubbleSort<>();
        List<String> list = new ArrayList<>(Arrays.asList("ace", "zs", "b"));
        List<String> sortedList = new ArrayList<>(Arrays.asList("b", "zs", "ace"));
        assertEquals(sortedList, mySorter.sort(comparator, list));
    }

    @Test
    public void myStringSymbolComparatorTest() throws NullComparatorException {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0) - o2.charAt(0);
            }
        };
        BubbleSort<String> mySorter = new BubbleSort<>();
        List<String> list = new ArrayList<>(Arrays.asList("b", "zs", "ace"));
        List<String> sortedList = new ArrayList<>(Arrays.asList("ace", "b", "zs"));
        assertEquals(sortedList, mySorter.sort(comparator, list));
    }

    @Test
    public void myStringLastNumberComparatorTest() throws NullComparatorException {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 % 10 - o2 % 10;
            }
        };
        BubbleSort<Integer> mySorter = new BubbleSort<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(999, 88, 7));
        List<Integer> sortedList = new ArrayList<>(Arrays.asList(7, 88, 999));
        assertEquals(sortedList, mySorter.sort(comparator, list));
    }
}