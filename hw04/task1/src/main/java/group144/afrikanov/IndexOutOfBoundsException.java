package group144.afrikanov;

/**
 * Class realizes an exception which throws if the index is out of bounds
 */
public class IndexOutOfBoundsException extends Exception {
    public IndexOutOfBoundsException(String exceptionText) {
        super(exceptionText);
    }
}
