package group144.afrikanov;

/** * Class implements methods of a list. */
public class LinkedList<T> {

    Node head = null, tail = null;
    private int size = 0;

    /**
     * Method adds a new node after certain.
     * @param item - node after which new item should be
     * @param value - value which is need to add
     */
    public void insertAfter(Node item, T value) throws ValueAlreadyExistsException {
        Node newItem = new Node(value, null, null);
        newItem.next = item.next;
        newItem.previous = item;
        item.next = newItem;
        newItem.next.previous = newItem;
        size++;
    }

    /**
     * Method inserts an element after all other
     * @param value - value which is need to add
     */
    public void insertBack(T value) throws ValueAlreadyExistsException {
        Node newItem = new Node(value, null, null);
        if (tail == null) {
            head = tail = newItem;
        }
        else {
            tail.next = newItem;
            newItem.previous = tail;
            tail = newItem;
        }
        ++size;
    }

    /**
     * Method inserts an element before all other
     * @param value - value which is need to add
     */
    public void insertFront(T value) throws ValueAlreadyExistsException {
        Node newItem = new Node(value, null, null);
        if (head == null) {
            head = tail = newItem;
        }
        else {
            head.previous = newItem;
            newItem.next = head;
            head = newItem;
        }
        ++size;
    }

    /**
     * Method removes a node after certain.
     * @param item - node which should be removed
     */
    public void removeNode(Node item) {
        item.previous.next = item.next;
        item.next.previous = item.previous;
    }

    /**
     * Method removes the first node with certain value.
     * @param value - value which is need to add
     */
    public void removeByValue(T value) throws ValueNotFoundException {
        Node certainNode = search(value);
        if (certainNode != null) {
            certainNode.previous.next = certainNode.next;
            certainNode.next.previous = certainNode.previous;
        }
    }

    /**
     * Method removes a head of a list.
     * @throws ValueNotFoundException when the value is not found
     */
    void removeHead() throws ValueNotFoundException {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
            --size;
        }
        else {
            throw new ValueNotFoundException();
        }
    }

    /**
     * Method removes a tail of a list.
     * @throws ValueNotFoundException when the value is not found
     */
    void removeTail() throws ValueNotFoundException {
        if (tail != null) {
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            }
            --size;
        }
        else {
            throw new ValueNotFoundException();
        }
    }

    boolean empty() {
        return size == 0;
    }

    /**
     * @param index of the element we want to get
     * @return current value
     * @throws IndexOutOfBoundsException when index is out of bounds
     */
    T getValueByIndex(int index) throws IndexOutOfBoundsException {
        if ((index >= size) || (index < 0)) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node result = head;
            for (int i = 0; i < index; ++i) {
                result = result.next;
            }
            return result.value;
        }
    }

    /**
     * @param index of the element we want to get
     * @return current Node
     * @throws IndexOutOfBoundsException when index is out of bounds
     */
    public Node getNodeByIndex(int index) throws IndexOutOfBoundsException{
        if ((index >= size) || (index < 0)) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node result = head;
            for (int i = 0; i < index; ++i) {
                result = result.next;
            }
            return result;
        }
    }

    /**
     * Method searches a node with certain value.
     * @param value we want to find
     * @return Found node or null if it doesn't exist.
     */
    Node search(T value) {
        Node item = head;
        while (item != null && value != item.value) {
            item = item.next;
        }
        return item;
    }

    /** * Class implements structure with 2 fields : value and link on the next element. */
    class Node {

        T value;
        Node next;
        private Node previous;

        Node(T value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
