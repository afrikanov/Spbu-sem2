package group144.afrikanov;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Controller for calculator
 */
public class Controller {

    /** Button, which removes all input information */
    @FXML
    private Button deleteAll;

    /** Button which deletes last symbol from the input */
    @FXML
    private Button deleteLast;

    /** Button which changes a sign of the input number */
    @FXML
    private Button changeSign;

    /** Text field with the result */
    @FXML
    private TextField result;

    private static double firstOperand = 0, secondOperand = 0;
    private static String operator = "$";
    private static ArrayList<String> stack = new ArrayList<>();
    private static ArrayList<String> fullExpression = new ArrayList<>();

    /**
     * Method handles the case when an operator was introduced
     * @param inputOperator - operator which will be handled
     * @return the result of expression when operator performs as "=" and nothing in other way
     * @throws DivisionByZeroException in attempt to divide by zero
     */
    private static String operatorButtonHandler(String inputOperator) throws DivisionByZeroException {
        String top = stack.get(stack.size() - 1);
        stack.add(inputOperator);
        if (inputOperator.equals("=") && operator.equals("$")) {
            return "no";
        }
        if (operator.equals("$") || top.equals("+") || top.equals("*") || top.equals("-") || top.equals("/")) {
            operator = inputOperator;
            return "no";
        }
        firstOperand = count(firstOperand, secondOperand, operator);
        secondOperand = 0;
        if (!inputOperator.equals("=")) {
            operator = inputOperator;
        }
        else {
            operator = "$";
        }
        return String.valueOf(firstOperand);
    }

    /**
     * Method handles the case when an operand was introduced
     * @param inputNumber - number which will be handled
     * @return new operand with number as last symbol
     */
    private static double numberButtonHandler(int inputNumber) {
        if (stack.size() != 0 && stack.get(stack.size() - 1).equals("=")) {
            operator = "$";
            firstOperand = 0;
            secondOperand = 0;
        }
        stack.add(String.valueOf(inputNumber));
        if (operator.equals("$")) {
            firstOperand = firstOperand * 10;
            firstOperand = (firstOperand >= 0 ? firstOperand + inputNumber : firstOperand - inputNumber);
            return firstOperand;
        }
        else {
            secondOperand = secondOperand * 10;
            secondOperand = (secondOperand >= 0 ? secondOperand + inputNumber : secondOperand - inputNumber);
            return secondOperand;
        }
    }

    /** Initialization */
    @FXML
    void initialize() {
        stack.add("0");
    }
    /**
     * Method counts the result of an expression
     * @param first - the first operand
     * @param second - the second operand
     * @param action - the operator
     * @return the result of an operation
     * @throws DivisionByZeroException when user tries to divide by zero
     */
    private static double count(double first, double second, String action) throws DivisionByZeroException {
        switch (action) {
            case "+" :
                return first + second;
            case "*" :
                return first * second;
            case "-" :
                return first - second;
            case "/" :
                if (second != 0) {
                    return first / second;
                } else {
                    throw new DivisionByZeroException("Division by zero");
                }
        }
        return 0;
    }

    /**
     * Method which counts square root from the number and throws an exception if it's negative
     * @throws SqrtFromNegativeDigit when the number is negative
     */
    private static String sqrt() throws SqrtFromNegativeDigit {
        if (operator.equals("$")) {
            if (firstOperand < 0) {
                throw new SqrtFromNegativeDigit("Square root from negative number");
            }
            firstOperand = Math.sqrt(firstOperand);
            return String.valueOf(firstOperand);
        } else {
            if (secondOperand < 0) {
                throw new SqrtFromNegativeDigit("Square root from negative number");
            }
            secondOperand = Math.sqrt(secondOperand);
            return String.valueOf(secondOperand);
        }
    }

    /** Method handles the last input symbol and launches current methods for further handling
     * @throws DivisionByZeroException in attempt to divide by zero
     * @throws SqrtFromNegativeDigit in attempt to get a square root from negative number
     */
    public static String handleExpression(ArrayList<String> fullExpression) throws DivisionByZeroException, SqrtFromNegativeDigit {
        String lastSymbol = fullExpression.get(fullExpression.size() - 1);
        if (isNumber(lastSymbol)) {
            return String.valueOf(numberButtonHandler(Integer.valueOf(lastSymbol)));
        } else if (isOperator(lastSymbol)) {
            return operatorButtonHandler(lastSymbol);
        } else if (lastSymbol.equals("sqrt")) {
            return String.valueOf(sqrt());
        } else if (lastSymbol.equals("C")) {
            return cleanAll();
        } else if (lastSymbol.equals("+-")) {
            return changeSign();
        } else {
            return cleanLast();
        }
    }

    /**
     * Method removes a symbol in current position from the string
     * @param input - string that will be handled
     * @param position - position of a symbol that will be removed
     * @return string without symbol
     */
    private static String removeCharAt(String input, int position) {
        return input.substring(0, position) + input.substring(position + 1);
    }

    /** Method removes a last number from the number */
    private static String cleanLast() {
        String stringClean;
        if (operator.equals("$")) {
            stringClean = String.valueOf(firstOperand);
        } else {
            stringClean = String.valueOf(secondOperand);
        }
        if (stringClean.length() == 3 && stringClean.charAt(stringClean.length() - 1) == '0' && stringClean.charAt(stringClean.length() - 2) == '.') {
            if (operator.equals("$")) {
                firstOperand = 0;
            } else {
                secondOperand = 0;
            }
            return "0.0";
        }
        if (stringClean.charAt(stringClean.length() - 1) == '0' && stringClean.charAt(stringClean.length() - 2) == '.') {
            stringClean = removeCharAt(stringClean, stringClean.length() - 3);
        } else {
            stringClean = removeCharAt(stringClean, stringClean.length() - 1);
        }
        if (stringClean.charAt(stringClean.length() - 1) == '.') {
            stringClean += '0';
        }
        if (operator.equals("$")) {
            firstOperand = Double.valueOf(stringClean);
        } else {
            secondOperand = Double.valueOf(stringClean);
        }
        return stringClean;
    }

    /** Method returns calculator's condition to the initial state */
    private static String cleanAll() {
        firstOperand = secondOperand = 0;
        operator = "$";
        return "0.0";
    }

    /** Method changes a sign of a number */
    private static String changeSign() {
        if (operator.equals("$")) {
            firstOperand = -firstOperand;
            return String.valueOf(firstOperand);
        } else {
            secondOperand = -secondOperand;
            return String.valueOf(secondOperand);
        }
    }

    /** Method checks whether a symbol is a number */
    private static boolean isNumber(String symbol) {
        return (symbol.charAt(0) >= '0' && symbol.charAt(0) <= '9');
    }

    /** Method checks whether a symbol is an operator */
    private static boolean isOperator(String symbol) {
        return (symbol.equals("+") || symbol.equals("*") || symbol.equals("-") || symbol.equals("/") || symbol.equals("="));
    }

    /** Method launches when any button is pressed, handle it and set the text in result field
     * @throws DivisionByZeroException in attempt to divide by zero
     * @throws SqrtFromNegativeDigit in attempt to get a square root from negative number
     */
    public void buttonPressed(ActionEvent actionEvent) throws DivisionByZeroException, SqrtFromNegativeDigit {
        Button button = (Button) actionEvent.getSource();
        fullExpression.add(button.getText());
        String nextOutput = handleExpression(fullExpression);
        if (!nextOutput.equals("no")) {
            result.setText(nextOutput);
        }
    }
}
