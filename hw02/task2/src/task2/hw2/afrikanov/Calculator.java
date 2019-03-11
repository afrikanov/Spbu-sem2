package task2.hw2.afrikanov;

public class Calculator {

    public int count(String inputString) {
        Stack stack = new StackList();
        for (int i = 0; i < inputString.length(); i++) {
            char strVal = inputString.charAt(i);
            switch (strVal) {
                case ' ':
                    continue;
                case '+':
                    int value = stack.top();
                    stack.pop();
                    value += stack.top();
                    stack.pop();
                    stack.push(value);
                    break;
                case '*':
                    value = stack.top();
                    stack.pop();
                    value *= stack.top();
                    stack.pop();
                    stack.push(value);
                    break;
                case '-':
                    value = stack.top();
                    stack.pop();
                    value -= stack.top();
                    stack.pop();
                    stack.push(-value);
                    break;
                case '/':
                    int valSecond = stack.top();
                    stack.pop();
                    int valFirst = stack.top();
                    stack.pop();
                    stack.push(valFirst / valSecond);
                    break;
                default:
                    String newInteger = "";
                    int j = i;
                    while (j < inputString.length() && inputString.charAt(j) >= '0' && inputString.charAt(j) <= '9') {
                        newInteger += inputString.charAt(j);
                        j++;
                    }
                    i = j - 1;
                    stack.push(Integer.parseInt(newInteger));
                    break;
            }
        }
        return stack.top();
    }
}
