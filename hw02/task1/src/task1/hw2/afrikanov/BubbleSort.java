package task1.hw2.afrikanov;

/**
 * Class implements Bubble sort technique
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] a, int left, int right) {
        for (int i = left; i < right - 2; ++i) {
            for (int j = left; j < right - i - 2; ++j) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    /**
     * Method swaps valued of 2 elements with certain positions
     * @param a - array with elements
     * @param firstIndex - position of the first element
     * @param secondIndex - position of the second element
     */
    private void swap(int[] a, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex)
            return;
        a[firstIndex] = a[firstIndex] + a[secondIndex];
        a[secondIndex] = a[firstIndex] - a[secondIndex];
        a[firstIndex] = a[firstIndex] - a[secondIndex];
    }
}
