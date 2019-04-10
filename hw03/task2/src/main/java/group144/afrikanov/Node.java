package group144.afrikanov;


/**
 * Class for operating with node in tree
 */
abstract class Node {

    Node leftNode = null, rightNode = null;
    String value;

    /**
     * Method calculates node from expression tree
     * @throws InvalidTreeException if the tree is invalid
     */
    abstract public int calculate() throws InvalidTreeException;

    /**
     * Method prints a node
     */
    abstract public void print();
}
