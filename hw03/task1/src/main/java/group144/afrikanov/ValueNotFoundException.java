package group144.afrikanov;

/** Exception throws, if the value is not found */
class ValueNotFoundException extends Exception {
    ValueNotFoundException(String exceptionText) {
        super(exceptionText);
    }
}