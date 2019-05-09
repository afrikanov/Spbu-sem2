package group144.afrikanov;

import java.io.IOException;

/** Class implements methods of a list without equal elements. */
public class UniqueList<T> extends LinkedList<T> {

    /**
     * Method inserts an element after all other
     * @param value - value which is need to add
     * @throws ValueAlreadyExistsException when the value is already exists
     */
    @Override
    public void insertBack(T value) throws ValueAlreadyExistsException {
        if (super.search(value) == null) {
            super.insertBack(value);
        } else {
            throw new ValueAlreadyExistsException("value already exists");
        }
    }

    /**
     * Method inserts an element before all other
     * @param value - value which is need to add
     */
    @Override
    public void insertFront(T value) throws ValueAlreadyExistsException {
        if (super.search(value) == null) {
            super.insertFront(value);
        } else {
            throw new ValueAlreadyExistsException("value already exists");
        }
    }
}