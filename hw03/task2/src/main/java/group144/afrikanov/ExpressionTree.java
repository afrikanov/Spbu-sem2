package group144.afrikanov;

/**
 * Class for operating with expression tree
 */
class ExpressionTree {

    private Node root;

    /**
     * Method creates an expression tree.
     * @param expression - the input expression
     * @throws InvalidTreeException if your expression is an invalid brackets sequence.
     */
    ExpressionTree(String expression) throws InvalidTreeException {
        String expression1 = upgradeString(expression);
        if (correctBracketSequence(expression1)) {
            root = new Operator(expression1);
        }
        else {
            throw new InvalidTreeException();
        }
    }

    /**
     * Method calculates your expression
     * @return result of an expression
     * @throws InvalidTreeException if your expression tree is incorrect (the tree has a incorrect symbol)
     */
    int calculate() throws InvalidTreeException {
        return root.calculate();
    }

    /**
     * Method prints your expression tree
     */
    void print() {
        root.print();
    }

    /**
     * Method checks if the expression is the correct brackets sequence
     * @param expression - the input expression
     * @return true if the expression is a correct brackets sequence, false otherwise
     */
    private boolean correctBracketSequence(String expression) {
        int amount = 0;
        char[] charArray = expression.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char element = charArray[i];
            if (element == '(') {
                ++amount;
            }
            if (element == ')') {
                --amount;
            }
            if (amount < 0) {
                return false;
            }
        }
        return amount == 0;
    }

    /**
     * Method changes a started string to a certain format
     * @param oldString - the input string, which will be changed
     * @return formatted String
     */
    private String upgradeString(String oldString) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < oldString.length(); ++i) {
            if (oldString.charAt(i) != ' ') {
                if (oldString.charAt(i) >= '0' && oldString.charAt(i) <= '9') {
                    StringBuilder newInteger = new StringBuilder(String.valueOf(oldString.charAt(i)));
                    ++i;
                    while (i < oldString.length() && oldString.charAt(i) >= '0' && oldString.charAt(i) <= '9') {
                        newInteger.append(String.valueOf(oldString.charAt(i)));
                        ++i;
                    }
                    --i;
                    newString.append(newInteger).append(" ");
                }
                else {
                    newString.append(String.valueOf(oldString.charAt(i))).append(" ");
                }
            }
        }
        return newString.toString();
    }
}
