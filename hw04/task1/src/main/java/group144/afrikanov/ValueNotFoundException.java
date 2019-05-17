package group144.afrikanov;

/**
 * Class realizes an exception which throws if list does not contains the value
 */
public class ValueNotFoundException extends Exception {
    public ValueNotFoundException(String exceptionText) {
        super(exceptionText);
    }
}
