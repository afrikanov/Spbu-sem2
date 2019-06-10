package task2.hw2.afrikanov;

/* Class realizes the exception, that throws when the stack is empty */
public class EmptyStackException extends Exception {
    public EmptyStackException(String exceptionText) {
        super(exceptionText);
    }
}
