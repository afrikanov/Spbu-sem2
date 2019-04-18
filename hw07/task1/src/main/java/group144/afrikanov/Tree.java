package group144.afrikanov;

import java.io.*;

/**
 * Class implements methods of bor
 */
class Tree implements Serializable {

    private final int ALPHABET_SIZE = 26;
    private Node root = new Node();
    private int treeSize = 0;

    /**
     * Method returns the size of bor
     */
    int size() {
        return treeSize;
    }

    /**
     * Method checks certain element in your bor
     * @param element - string which should be added
     * @return true if bor contains an element, false otherwise
     * @throws InvalidSymbolException if string includes invalid symbol
     */
    boolean contains(String element) throws InvalidSymbolException {
        if (invalidString(element))
            throw new InvalidSymbolException();
        Node nodeNow = root;
        for (int i = 0; i < element.length(); ++i) {
            if (nodeNow == null) {
                return false;
            }
            char symbol = element.charAt(i);
            nodeNow = nodeNow.next[symbol - 'a'];
        }
        return nodeNow != null && nodeNow.isTerminal;
    }

    /**
     * Method checks an element on correctness
     * @param element - string, that should be checked
     * @return true if string is invalid, false otherwise
     */
    boolean invalidString(String element) {
        for (int i = 0; i < element.length(); ++i) {
            if (element.charAt(i) > 'z' || element.charAt(i) < 'a') {
                return true;
            }
        }
        return false;
    }

    /**
     * Method adds an element to bor
     * @param element - string that should be added
     * @return false if bor contains an element, true otherwise
     * @throws InvalidSymbolException if string includes invalid symbol
     */
    boolean add(String element) throws InvalidSymbolException {
        if (contains(element)) {
            return false;
        }
        ++treeSize;
        Node nodeNow = root;
        for (int i = 0; i < element.length(); ++i) {
            char symbol = element.charAt(i);
            int symbolPosition = symbol - 'a';
            if (nodeNow.next[symbolPosition] != null) {
                nodeNow = nodeNow.next[symbolPosition];
            }
            else {
                Node newNode = new Node();
                nodeNow.next[symbolPosition] = newNode;
                nodeNow = nodeNow.next[symbolPosition];
            }
            nodeNow.nodeSize++;
        }
        nodeNow.isTerminal = true;
        return true;
    }

    /**
     * Method removes a string from bor
     * @param element - string that should be deleted
     * @return true if bor contains an element, false otherwise
     * @throws InvalidSymbolException if string includes invalid symbol
     */
    boolean remove(String element) throws InvalidSymbolException {
        if (!contains(element)) {
            return false;
        }
        --treeSize;
        Node nodeNow = root;
        for (int i = 0; i < element.length(); ++i) {
            char symbol = element.charAt(i);
            int symbolPosition = symbol - 'a';
            nodeNow = nodeNow.next[symbolPosition];
            nodeNow.nodeSize--;
        }
        nodeNow.isTerminal = false;
        return true;
    }

    /**
     * Method counts an amount of strings with common prefix
     * @param prefix - common prefix of some strings
     * @return amount of strings with common certain prefix
     */
    int howManyStartWithPrefix(String prefix) {
        Node nodeNow = root;
        for (int i = 0; i < prefix.length(); ++i) {
            if (nodeNow == null) {
                return 0;
            }
            char symbol = prefix.charAt(i);
            int symbolPosition = symbol - 'a';
            nodeNow = nodeNow.next[symbolPosition];
        }
        return nodeNow == null ? 0 : nodeNow.nodeSize;
    }

    /**
     * Method writes an object to a stream to save it
     * @param out - output stream
     * @throws IOException if operations are failed
     */
    void serialize(OutputStream out) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(this);
    }

    /**
     * Method sets the input data from the stream to bor
     * @param in - input stream
     * @throws IOException if operations are failed
     * @throws ClassNotFoundException if file .class is out of classpath
     */
    void deserialize(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        Tree tree = (Tree) objectInputStream.readObject();
        root = tree.root;
    }

    /**
     * Class for working with the bor
     */
    class Node implements Serializable {
        boolean isTerminal = false;
        Node[] next = new Node[ALPHABET_SIZE];
        int nodeSize = 0;
    }
}
