package group144.afrikanov;

/** Class realizes an exception which throws when user tries to add a string with symbols that are unable to be added */
public class InvalidSymbolException extends Exception {
    InvalidSymbolException(String exceptionText) {
        super(exceptionText);
    }
}
