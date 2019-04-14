package task1.hw2.afrikanov;

/**
 * Class implements Quick sort technique
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        int middleValue = a[middle];
        int i = left;
        int j = right;
        while (i <= j) {
            while (a[i] < middleValue) {
                ++i;
            }
            while (a[j] > middleValue) {
                --j;
            }
            if (i <= j) {
                swap(a, i, j);
                ++i;
                --j;
            }
        }
        if (left < j) {
            sort(a, left, j);
        }
        if (right > i) {
            sort(a, i, right);
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
