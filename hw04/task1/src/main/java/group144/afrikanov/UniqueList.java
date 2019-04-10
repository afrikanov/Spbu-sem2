package group144.afrikanov;

public class UniqueList<T> extends LinkedList<T> {

    /**
     * Method adds a new node after certain.
     * @param item - node after which new item should be
     * @param value - value which is need to add
     * @throws ValueAlreadyExistsException when the value already exists
     */
    @Override
    public void insertAfter(Node item, T value) throws ValueAlreadyExistsException {
        if (super.search(value) != null) {
            super.insertAfter(item, value);
        }
        else {
            throw new ValueAlreadyExistsException();
        }
    }

    /**
     * Method inserts an element after all other
     * @param value - value which is need to add
     * @throws ValueAlreadyExistsException when the value is already exists
     */
    @Override
    public void insertBack(T value) throws ValueAlreadyExistsException {
        if (super.search(value) != null) {
            super.insertBack(value);
        }
        else {
            throw new ValueAlreadyExistsException();
        }
    }

    /**
     * Method inserts an element before all other
     * @param value - value which is need to add
     * @throws ValueAlreadyExistsException when the value is already exists
     */
    @Override
    public void insertFront(T value) throws ValueAlreadyExistsException {
        if (super.search(value) != null) {
            super.insertFront(value);
        }
        else {
            throw new ValueAlreadyExistsException();
        }
    }

    /**
     * Method removes the first node with certain value.
     * @param value - value which is need to add
     * @throws ValueNotFoundException when the value is not found
     */
    @Override
    public void removeByValue(T value) throws ValueNotFoundException {
        if (super.search(value) != null) {
            super.removeByValue(value);
        }
        else {
            throw new ValueNotFoundException();
        }
    }
}