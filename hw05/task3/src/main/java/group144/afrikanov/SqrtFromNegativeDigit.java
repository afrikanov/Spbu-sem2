package group144.afrikanov;

/** Class realizes an exception that throws in attempt to get a square root from negative number */
public class SqrtFromNegativeDigit extends Exception {
    public SqrtFromNegativeDigit(String exceptionText) {
        super(exceptionText);
    }
}
