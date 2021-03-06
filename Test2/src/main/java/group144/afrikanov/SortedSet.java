package group144.afrikanov;

import java.util.LinkedList;

/** Class that implements the data structure which saves elements in sorted order */
public class SortedSet<T> implements ListsComorator<T> {

    public LinkedList<LinkedList<T>> list;

    SortedSet() {}

    SortedSet(LinkedList<LinkedList<T>> list) {
        this.list = list;
        sort(this.list, 0, list.size());
    }

    @Override
    public int compare(LinkedList<T> first, LinkedList<T> second) {
        if(first.size() < second.size()) {
            return -1;
        }
        if (first.size() > second.size()) {
            return 1;
        }
        return 0;
    }

    /** Method realized the sorting method */
    public void sort(LinkedList<LinkedList<T>> list, int left, int right) {
        for (int i = left + 1; i < right; ++i) {
            for (int j = left; j < right - i; ++j) {
                if (compare(list.get(j), list.get(j + 1)) > 0) {
                    swap(list, j, j + 1);
                }
            }
        }
    }

    /** Method swaps to elements */
    private void swap(LinkedList<LinkedList<T>> list, int firstIndex, int secondIndex) {
        LinkedList<T> intermediateValue = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, intermediateValue);
    }

    /** Method prints the result order of input arrays */
    public void print() {
        for (var listElement : list) {
            for (var value : listElement) {
                System.out.println(value + " ");
            }
            System.out.println();
        }
    }
}
