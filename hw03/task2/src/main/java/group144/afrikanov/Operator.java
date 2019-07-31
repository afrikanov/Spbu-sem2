package group144.afrikanov;

public class Operator implements Node {

    private Node leftNode;
    private Node rightNode;
    private char value;

    public Node getLeft() {
        return leftNode;
    }

    public Node getRight() {
        return rightNode;
    }

    public void setLeft(Node newChild) {
        leftNode = newChild;
    }

    public void setRight(Node newChild) {
        rightNode = newChild;
    }

    public Operator(char operator) {
        this.value = operator;
    }

    public Operator(char value, Node leftNode, Node rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /**
     * Method calculates the expression bypassing the tree
     * @return the result of an expression
     */
    @Override
    public int calculate() {
        switch (value) {
            case ('+'):
                return leftNode.calculate() + rightNode.calculate();
            case ('-'):
                return leftNode.calculate() - rightNode.calculate();
            case ('*'):
                return leftNode.calculate() * rightNode.calculate();
            case ('/'):
                return leftNode.calculate() / rightNode.calculate();
        }
        return 0;
    }

    /** Method prints an expression in certain format */
    @Override
    public void print() {
        System.out.print("( " + value + " ");
        leftNode.print();
        System.out.print(" ");
        rightNode.print();
        System.out.print(" )");
    }
}
