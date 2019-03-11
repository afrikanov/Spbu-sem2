package task2.hw1.afrikanov;

/** * Class implements methods of a list. */
public class List {

    private Node head = new Node(0, null);
    private int size = 0;

    /**
     * Method adds a new node after certain.
     * @param item
     * @param newItem
     */
    public void insertAfter(Node item, Node newItem) {
        newItem.next = item.next;
        item.next = newItem;
        size++;
    }

    /**
     * Method removes a node after certain.
     * @param item
     */
    public void removeAfter(Node item) {
        if (item.next != null) {
            item.next = item.next.next;
            size--;
        }
    }

    /** * Method removes a head of a list. */
    public void removeHead() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    public boolean empty() {
        return size == 0;
    }

    /**
     * Method searches a node with certain value.
     * @param value
     * @return Found node or null if it doesn't exist.
     */
    public Node search(int value) {
        Node item = head;
        while (item != null && value != item.value) {
            item = item.next;
        }
        return item;
    }

    /** * Class implements structure with 2 fields : value and link on the next element. */
    class Node {
        private int value;
        private Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
