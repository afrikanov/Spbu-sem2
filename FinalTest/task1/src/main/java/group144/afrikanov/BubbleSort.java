package group144.afrikanov;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.swap;

/** Class realizes a method which sorts a list using a given comparator using a bubble sort technique */
public class BubbleSort<Type> implements ComparatorSorter<Type> {

    @Override
    public <Type> List<Type> sort(Comparator<Type> comparator, List<Type> list) throws NullComparatorException {
        if (comparator == null) {
            throw new NullComparatorException("Null comparator");
        }
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        List<Type> sortedList = new ArrayList<>(list);
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i; j++) {
                Type leftElement = sortedList.get(j);
                Type rightElement = sortedList.get(j + 1);
                if (comparator.compare(leftElement, rightElement) > 0) {
                    swap(sortedList, j, j + 1);
                }
            }
        }
        return sortedList;
    }
}
