package group144.afrikanov;

/** Class realizes the sorting function */
public abstract class Sort {
    /**
     * Method sorts an array
     * @param sortableArray - sortable array
     * @param left - left border of sortable interval of array
     * @param right - right border of sortable interval of array
     */
    public abstract void sort(int[] sortableArray, int left, int right);

    /**
     * Method swaps valued of 2 elements with certain positions
     * @param a - array with elements
     * @param firstIndex - position of the first element
     * @param secondIndex - position of the second element
     */
    public static void swap(int[] a, int firstIndex, int secondIndex) {
        if (firstIndex == secondIndex)
            return;
        a[firstIndex] = a[firstIndex] + a[secondIndex];
        a[secondIndex] = a[firstIndex] - a[secondIndex];
        a[firstIndex] = a[firstIndex] - a[secondIndex];
    }
}
