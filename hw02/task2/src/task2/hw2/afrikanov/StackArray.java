package task2.hw2.afrikanov;

public class StackArray<Type> implements Stack<Type> {

    private final int MAX_SIZE = (int)1e5;
    private Type[] stack = (Type[]) new Object[MAX_SIZE];
    private Type top = null;
    private int size = 0;

    @Override
    public void push(Type value) throws FullStackException {
        if (size == MAX_SIZE) {
            throw new FullStackException();
        }
        stack[size] = value;
        top = value;
        size++;
    }

    @Override
    public Type pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        Type previousTop = stack[size];
        stack[size] = null;
        top = (size > 0 ? stack[size - 1] : null);
        return previousTop;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Type top() {
        if (size != 0) {
            return stack[size - 1];
        }
        else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
