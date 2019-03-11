package task1.hw2.afrikanov;

public class ChoiceSort implements Sort {

    int left, right;

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

    private void swap(int[] a, int first, int second) {
        if (first == second)
            return;
        a[first] = a[first] + a[second];
        a[second] = a[first] - a[second];
        a[first] = a[first] - a[second];
    }
}

