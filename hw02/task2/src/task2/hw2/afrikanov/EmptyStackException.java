package task2.hw2.afrikanov;

public class EmptyStackException extends Exception {
    public EmptyStackException() {
        super("The stack is empty");
    }
}
