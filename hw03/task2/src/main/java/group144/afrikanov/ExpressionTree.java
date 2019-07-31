package group144.afrikanov;

import java.util.Scanner;

/** Class for operating with expression tree */
class ExpressionTree {

    private Node root;

    public ExpressionTree(Node root) {
        this.root = root;
    }

    public ExpressionTree(Scanner expression) {
        root = new Operator(expression.next().charAt(1));
        buildTree(expression, (Operator) root);
    }

    /** A method that calculates expression */
    public int calculate() {
        return root.calculate();
    }

    /** A method that prints tree */
    public void print() {
        root.print();
    }

    /** Method builds an expression tree */
    private void buildTree(Scanner expression, Operator node) {
        String leftSymbol = expression.next();
        if (!hasInteger(leftSymbol)) {
            node.setLeft(new Operator(leftSymbol.charAt(1)));
            buildTree(expression, (Operator) node.getLeft());
        } else {
            node.setLeft(new Operand(leftSymbol));
        }
        String rightSymbol = expression.next();
        if (!hasInteger(rightSymbol)) {
            node.setRight(new Operator(rightSymbol.charAt(1)));
            buildTree(expression, (Operator) node.getRight());
        } else {
            node.setRight(new Operand(rightSymbol));
        }
    }

    /** Method checks if an expression has a digit */
    private boolean hasInteger(String expression) {
        return expression.charAt(0) >= '0' && expression.charAt(0) <= '9';
    }
}
