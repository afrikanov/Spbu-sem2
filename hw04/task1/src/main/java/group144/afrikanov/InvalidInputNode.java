package group144.afrikanov;

/**
 * Class realizes an exception which throws if the input node is wrong
 */
public class InvalidInputNode extends Exception {
    public InvalidInputNode(String exceptionText) {
        super(exceptionText);
    }
}
