package group144.afrikanov;

/** Class implements Quick sort technique not using multithreading*/
public class OneThreadQSort extends Sort {

    @Override
    public void sort(int[] sortableArray, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        int middleValue = sortableArray[middle];
        int i = left;
        int j = right;
        while (i <= j) {
            while (sortableArray[i] < middleValue) {
                ++i;
            }
            while (sortableArray[j] > middleValue) {
                --j;
            }
            if (i <= j) {
                swap(sortableArray, i, j);
                ++i;
                --j;
            }
        }
        if (left < j) {
            sort(sortableArray, left, j);
        }
        if (right > i) {
            sort(sortableArray, i, right);
        }
    }
}
