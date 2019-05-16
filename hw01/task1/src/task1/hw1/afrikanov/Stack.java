package task1.hw1.afrikanov;

/** Class implements methods of Stack. */
public class Stack<Type> {

    private Node head = null;
    private int size = 0;

    /**
     * Method adds an element to the end.
     * @param value - value of a new element
     */
    public void push(Type value) {
        head = new Node(value, head);
        size++;
    }

    /** Method erases an element from the end. */
    public Type pop() {
        if (isEmpty()) {
            return null;
        }
        Type previousTop = head.value;
        head = head.next;
        size--;
        return previousTop;
    }

    /**
     * Method gets an element from the top of stack
     * @return value from the top
     */
    public Type top() {
        return head == null ? null : head.value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** Class implements structure with 2 fields : value and link on the next element. */
    private class Node {
        private Type value;
        private Node next;

        Node(Type value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
