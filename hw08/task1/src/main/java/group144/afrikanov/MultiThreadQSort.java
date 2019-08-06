package group144.afrikanov;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/** Class implements Quick sort technique using multithreading */
public class MultiThreadQSort extends Sort {

    @Override
    public void sort(int[] sortableArray, int left, int right) {
        ForkJoinPool.commonPool().invoke(new Sorting(sortableArray, left, right));
    }

    /** Class realizes sorting of array of integers using multithreading technique*/
    private class Sorting extends RecursiveAction {

        int[] sortableArray;
        int left;
        int right;

        Sorting(int[] sortableArray, int left, int right) {
            this.sortableArray = sortableArray;
            this.left = left;
            this.right = right;
        }

        @Override
        protected void compute() {
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
            invokeAll(new Sorting(sortableArray, left, j), new Sorting(sortableArray, i, right));
        }
    }
}
