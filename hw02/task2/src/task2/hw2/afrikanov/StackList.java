package task2.hw2.afrikanov;

public class StackList implements Stack {

    private Node head = new Node(0, null);
    private int size = 0;

    @Override
    public void push(int value) {
        head = new Node(value, head);
        size++;
    }

    @Override
    public void pop() {
        if (empty()) {
            return;
        }
        head = head.next;
        size--;
    }

    @Override
    public int top() {
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    /**
     * Class implements structure with 2 fields : value and link on the next element.
     */
    class Node {
        private int value;
        private Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
