package group144.afrikanov;

public class ValueAlreadyExistsException extends RuntimeException {
    public ValueAlreadyExistsException() {
        super("Value already exists");
    }
}
