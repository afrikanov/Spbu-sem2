package task1.hw2.afrikanov;

public class BubbleSort implements Sort {

    int left, right;

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

    private void swap(int[] a, int first, int second) {
        if (first == second)
            return;
        a[first] = a[first] + a[second];
        a[second] = a[first] - a[second];
        a[first] = a[first] - a[second];
    }
}
