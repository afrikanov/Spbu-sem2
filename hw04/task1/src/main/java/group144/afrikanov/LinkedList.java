package group144.afrikanov;

import java.io.IOException;

/** Class implements methods of a list. */
public class LinkedList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public int getSize() {
        return size;
    }

    /**
     * Method inserts an element after all other
     * @param value - value which is need to add
     */
    public void insertBack(T value) {
        tail = new Node<T>(value, null, tail);
        if (head == null) {
            head = tail;
        } else {
            tail.previous.next = tail;
        }
        size++;
    }

    /**
     * Method inserts an element before all other
     * @param value - value which is need to add
     */
    public void insertFront(T value) {
        head = new Node<>(value, head, null);
        if (tail == null) {
            tail = head;
        } else {
            head.next.previous = head;
        }
        size++;
    }

    /**
     * Method removes a node after certain.
     * @param item - node which should be removed
     */
    public void removeNode(Node<T> item) {
        item.previous.next = item.next;
        item.next.previous = item.previous;
        size--;
    }

    /**
     * Method removes the first node with certain value.
     * @param value - value which is need to add
     * @throws ValueNotFoundException when the value is not found
     */
    public void removeByValue(T value) throws ValueNotFoundException {
        Node<T> certainNode = search(value);
        if (certainNode != null) {
            removeNode(certainNode);
        } else {
            throw new ValueNotFoundException("value not found");
        }
    }

    /**
     * Method removes a head of a list.
     * @throws ValueNotFoundException when the value is not found
     */
    public void removeHead() throws ValueNotFoundException {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
            size--;
        } else {
            throw new ValueNotFoundException("value not found");
        }
    }

    /**
     * Method removes a tail of a list.
     * @throws ValueNotFoundException when the value is not found
     */
    public void removeTail() throws ValueNotFoundException {
        if (tail != null) {
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            }
            size--;
        } else {
            throw new ValueNotFoundException("value not found");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param index of the element we want to get
     * @return current value
     * @throws IndexOutOfBoundsException when index is out of bounds
     */
    public T getValueByIndex(int index) throws IndexOutOfBoundsException {
        if ((index >= size) || (index < 0)) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        return getNodeByIndex(index).value;
    }

    /**
     * @param index of the element we want to get
     * @return current Node
     * @throws IndexOutOfBoundsException when index is out of bounds
     */
    public Node<T> getNodeByIndex(int index) throws IndexOutOfBoundsException {
        if ((index >= size) || (index < 0)) {
            throw new IndexOutOfBoundsException("index is out of bounds");
        }
        Node<T> result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    /**
     * Method searches a node with certain value.
     * @param value we want to find
     * @return Found node or null if it doesn't exist.
     */
    public Node<T> search(T value) {
        Node<T> item = head;
        while (item != null && value != item.value) {
            item = item.next;
        }
        return item;
    }

    /** Class implements structure with 2 fields : value and link on the next element. */
    private class Node<Type> {

        private Type value;
        private Node<Type> next;
        private Node<Type> previous;

        Node(Type value, Node<Type> next, Node<Type> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
