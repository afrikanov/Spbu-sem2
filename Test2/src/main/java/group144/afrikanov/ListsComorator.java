package group144.afrikanov;

import java.util.Comparator;
import java.util.LinkedList;

/** Interface implements the method which compares 2 arguments */
public interface ListsComorator<T> extends Comparator<LinkedList<T>>{
    int compare (LinkedList<T> first, LinkedList<T> second);
}
