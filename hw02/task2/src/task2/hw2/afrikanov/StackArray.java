package task2.hw2.afrikanov;

public class StackArray implements Stack{

    final int MAXN = (int)1e5;
    private int[] stack = new int[MAXN];
    private int top = 0;
    private int size = 0;

    @Override
    public void push(int value) {
        stack[size] = value;
        top = value;
        size++;
    }

    @Override
    public void pop() {
        if (empty()) {
            return;
        }
        size--;
        stack[size] = 0;
        if (size > 0) {
            top = stack[size - 1];
        }
        else {
            top = -1;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int top() {
        if (size != 0) {
            return stack[size - 1];
        }
        else  {
            return -1;
        }
    }

    @Override
    public boolean empty() {
        return size == 0;
    }
}
