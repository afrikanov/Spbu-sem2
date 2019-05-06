package task2.hw2.afrikanov;

/** Class implements a stack basing on a list */
public class StackList<Type> implements Stack<Type> {

    private Node<Type> head = null;
    private int size = 0;

    @Override
    public void push(Type value) {
        head = new Node<>(value, head);
        size++;
    }

    @Override
    public Type pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("The stack is empty");
        }
        Type previousTop = head.value;
        head = head.next;
        size--;
        return previousTop;
    }

    @Override
    public Type getTop() {
        return head == null ? null : head.value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /* Class implements structure with 2 fields : value and link on the next element. */
    private class Node<T> {
        private Type value;
        private Node<T> next;

        Node(Type value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
