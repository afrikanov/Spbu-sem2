package task2.hw2.afrikanov;

/* Class realizes the exception, that throws when the stack is full */
public class FullStackException extends Exception {
    public FullStackException(String exceptionTest) {
        super(exceptionTest);
    }
}
