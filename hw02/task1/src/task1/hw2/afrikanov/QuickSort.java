package task1.hw2.afrikanov;

public class QuickSort implements Sort {

    int left, right;

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

    private void swap(int[] a, int first, int second) {
        if (first == second)
            return;
        a[first] = a[first] + a[second];
        a[second] = a[first] - a[second];
        a[first] = a[first] - a[second];
    }
}
