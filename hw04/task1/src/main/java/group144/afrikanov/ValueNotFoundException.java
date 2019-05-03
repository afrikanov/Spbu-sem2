package group144.afrikanov;

public class ValueNotFoundException extends RuntimeException {
    public ValueNotFoundException() {
        super("Value not found");
    }
}
