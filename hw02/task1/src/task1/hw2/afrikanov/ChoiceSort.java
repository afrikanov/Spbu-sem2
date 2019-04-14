package task1.hw2.afrikanov;

/**
 * Class implements Choice sort technique
 */
public class ChoiceSort implements Sort {

    @Override
    public void sort(int[] a, int left, int right) {
        for (int i = left; i < right - 1; ++i) {
            int pos = i;
            for (int j = i + 1; j < right; ++j) {
                if (a[j] < a[pos]) {
                    pos = j;
                }
            }
            swap(a, i, pos);
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

