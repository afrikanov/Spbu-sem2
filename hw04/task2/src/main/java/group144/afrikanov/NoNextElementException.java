package group144.afrikanov;

/** Class realizes an exception that throws when next element after a certain does not exist */
public class NoNextElementException extends RuntimeException {
    public NoNextElementException(String exceptionText) {
        super(exceptionText);
    }
}
