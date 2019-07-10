package task1.test1.afrikanov;

/**
 * Class that implements exception, that throws, when the queue is empty
 */
public class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        super("The queue is empty!");
    }
}
