package group144.afrikanov;

public class Operator extends Node {

    /**
     * Method makes an arithmetic tree. Starts from an full expression in the root.
     * @param expression - String with an expression
     * @throws InvalidTreeException when the tree is invalid
     */
    Operator(String expression) throws InvalidTreeException {
        String[] expressionArray = expression.split(" ");
        if (expressionArray[0].equals("(")) {
            value = expressionArray[1];
            StringBuilder leftChild = new StringBuilder();
            StringBuilder rightChild = new StringBuilder();
            int leftChildRightBorder = makeChildBorders(2, expressionArray);
            int rightChildRightBorder = makeChildBorders(leftChildRightBorder + 1, expressionArray);
            for (int i = 2; i <= leftChildRightBorder; ++i) {
                leftChild.append(expressionArray[i]);
                if (i < leftChildRightBorder) {
                    leftChild.append(" ");
                }
            }
            for (int i = leftChildRightBorder + 1; i <= rightChildRightBorder; ++i) {
                rightChild.append(expressionArray[i]);
                if (i < rightChildRightBorder) {
                    rightChild.append(" ");
                }
            }
            if (leftChild.charAt(0) == '(') {
                this.leftNode = new Operator(leftChild.toString());
            }
            else {
                this.leftNode = new Operand(leftChild.toString());
            }
            if (rightChild.charAt(0) == '(') {
                this.rightNode = new Operator(rightChild.toString());
            }
            else {
                this.rightNode = new Operand(rightChild.toString());
            }
        }
        else {
            throw new InvalidTreeException();
        }
    }

    /**
     * Method returns a right border of an operand for a certain operator
     * @param leftBorder - index, which from method makes a child
     * @param expressionArray - the array with expression elements
     * @throws InvalidTreeException when the tree is invalid
     */
    private int makeChildBorders(int leftBorder, String[] expressionArray) throws InvalidTreeException {
        int amountOfBrackets = 0;
        for (int i = leftBorder; i < expressionArray.length; ++i) {
            if (expressionArray[i].equals("(")) {
                ++amountOfBrackets;
            }
            else if (expressionArray[i].equals(")")) {
                --amountOfBrackets;
            }
            if (amountOfBrackets == 0) {
                return i;
            }
        }
        throw new InvalidTreeException();
    }

    /**
     * Method calculates the expression bypassing the tree
     * @return the result of an expression
     * @throws InvalidTreeException if the tree is invalid
     */
    @Override
    public int calculate() throws InvalidTreeException {
        switch (value) {
            case ("+"):
                return leftNode.calculate() + rightNode.calculate();
            case ("-"):
                return leftNode.calculate() - rightNode.calculate();
            case ("*"):
                return leftNode.calculate() * rightNode.calculate();
            case ("/"):
                return leftNode.calculate() / rightNode.calculate();
        }
        throw new InvalidTreeException();
    }

    /*** Method prints an expression in certain format */
    @Override
    public void print() {
        System.out.print("( " + value + " ");
        leftNode.print();
        System.out.print(" ");
        rightNode.print();
        System.out.print(" )");
    }
}
