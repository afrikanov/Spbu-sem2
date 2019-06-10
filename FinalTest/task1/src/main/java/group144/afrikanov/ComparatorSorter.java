package group144.afrikanov;

import java.util.Comparator;
import java.util.List;

/** Interface implements sorting using a comparator */
public interface ComparatorSorter<Type> {
    /**
     * Method realizes sorting a list using a given comparator
     * @param comparator - used comparator
     * @param list - the list that will become sorted
     * @param <Type> - type of values of the list
     * @return a sorted list
     * @throws NullComparatorException throws when the comparator is null
     */
    <Type> List<Type> sort(Comparator<Type> comparator, List<Type> list) throws NullComparatorException;
}
