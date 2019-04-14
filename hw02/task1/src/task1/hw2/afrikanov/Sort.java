package task1.hw2.afrikanov;

/**
 * Interface with the sorting function
 */
public interface Sort {

    /**
     * Method sorts an array
     * @param a - sortable array
     * @param left - left border of sortable interval of array
     * @param right - right border of sortable interval of array
     */
    void sort(int[] a, int left, int right);
}
