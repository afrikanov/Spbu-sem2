package group144.afrikanov;

/**
 * Class realizes an exception which throws if list already contains the value
 */
public class ValueAlreadyExistsException extends RuntimeException {
    public ValueAlreadyExistsException(String exceptionText) {
        super(exceptionText);
    }
}
