package group144.afrikanov;

/** Class realizes an exception which throws when user tries to use null comparator */
public class NullComparatorException extends Exception {
    public NullComparatorException(String exceptionText) {
        super(exceptionText);
    }
}
