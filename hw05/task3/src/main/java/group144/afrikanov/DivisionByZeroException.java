package group144.afrikanov;

/** Class realizes an exception that throws in attempt to divide by zero  */
public class DivisionByZeroException extends RuntimeException {
    public DivisionByZeroException(String exceptionText) {
        super(exceptionText);
    }
}
