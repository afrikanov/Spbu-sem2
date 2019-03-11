package task1.hw2.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sortRandom() {
        int[] actuals = {5, 3, 8, 7, 11, 1, 4};
        int[] expecteds = {1, 3, 4, 5, 7, 8, 11};
        Sort sorter = new BubbleSort();
        sorter.sort(actuals, 0, actuals.length - 1);
        assertArrayEquals(actuals, expecteds);
    }

    @Test
    void sortReversed() {
        int[] actuals = {6, 4, 2, 0, -2};
        int[] expecteds = {-2, 0, 2, 4, 6};
        Sort sorter = new BubbleSort();
        sorter.sort(actuals, 0, actuals.length - 1);
        assertArrayEquals(actuals, expecteds);
    }

    @Test
    void SortEqual() {
        int[] actuals = {1, 1, 1, 1, -1};
        int[] expecteds = {-1, 1, 1, 1, 1};
        Sort sorter = new BubbleSort();
        sorter.sort(actuals, 0, actuals.length - 1);
        assertArrayEquals(actuals, expecteds);
    }
}