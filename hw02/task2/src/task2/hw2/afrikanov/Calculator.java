package task2.hw2.afrikanov;

/* Class implements computing function of calculator */
public class Calculator {

    /**
     * Method counts the expression value
     * @param inputString - string with an expression
     * @return the result of an expression
     */
    public int count(String inputString) throws FullStackException, EmptyStackException {
        Stack<Integer> stack = new StackList<>();
        for (int i = 0; i < inputString.length(); i++) {
            char strVal = inputString.charAt(i);
            if (strVal == ' ') {
                continue;
            }
            if (strVal != '+' && strVal != '*' && strVal != '-' && strVal != '/') {
                StringBuilder newInteger = new StringBuilder();
                int j = i;
                while (j < inputString.length() && inputString.charAt(j) >= '0' && inputString.charAt(j) <= '9') {
                    newInteger.append(inputString.charAt(j));
                    j++;
                }
                i = j - 1;
                stack.push(Integer.parseInt(newInteger.toString()));
                continue;
            }
            int value = stack.top();
            stack.pop();
            switch (strVal) {
                case '+':
                    value += stack.top();
                    break;
                case '*':
                    value *= stack.top();
                    break;
                case '-':
                    value -= stack.top();
                    value *= -1;
                    break;
                case '/':
                    value = stack.top() / value;
                    break;
            }
            stack.pop();
            stack.push(value);
        }
        return stack.top();
    }
}
