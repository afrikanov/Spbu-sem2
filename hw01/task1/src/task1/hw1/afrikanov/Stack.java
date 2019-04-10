package task1.hw1.afrikanov;

/** * Class implements methods of Stack. */
public class Stack {

    private Node head = new Node(0, null);
    private int size = 0;

    /**
     * Method adds an element to the end.
     * @param value - value of a new element
     */
    public void push(int value) {
        head = new Node(value, head);
        size++;
    }

    /** * Method erases an element from the end. */
    public void pop() {
        if (empty()) {
            return;
        }
        head = head.next;
        size--;
    }

    /**
     * Method gets an element from the top of stack
     * @return value from the top
     */
    public int top() {
        return head.value;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    /** * Class implements structure with 2 fields : value and link on the next element. */
    private class Node {
        private int value;
        private Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
