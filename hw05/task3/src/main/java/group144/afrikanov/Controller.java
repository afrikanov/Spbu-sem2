package group144.afrikanov;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.ArrayList;

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

    private double firstOperand = 0, secondOperand = 0;
    private String operator = "$";
    private ArrayList<String> stack = new ArrayList<>();

    /**
     * Method which handles a situation, when the button with operator pressed
     * @param actionEvent - event variable
     * @throws DivisionByZeroException when user tries to divide by zero
     */
    public void operatorButtonPressed(ActionEvent actionEvent) throws DivisionByZeroException {
        if (actionEvent.getSource() instanceof Button) {
            Button button = (Button)actionEvent.getSource();
            String inputOperator = String.valueOf(button.getText());
            String top = stack.get(stack.size() - 1);
            if (operator.equals("$")) {
                operator = inputOperator;
                stack.add(inputOperator);
                return;
            }
            if (top.equals("+") || top.equals("*") || top.equals("-") || top.equals("/")) {
                operator = inputOperator;
                stack.add(inputOperator);
                return;
            }
            firstOperand = count(firstOperand, secondOperand, operator);
            secondOperand = 0;
            result.setText(String.valueOf(firstOperand));
            if (!inputOperator.equals("=")) {
                operator = inputOperator;
            }
            else {
                operator = "$";
            }
            stack.add(inputOperator);
        }
    }

    /**
     * Method which handles a situation, when the button with operand pressed
     * @param actionEvent - event variable
     */
    public void numberButtonPressed(ActionEvent actionEvent) {
        if (actionEvent.getSource() instanceof Button) {
            Button button = (Button)actionEvent.getSource();
            int inputNumber = Integer.valueOf(button.getText());
            if (stack.size() != 0 && stack.get(stack.size() - 1).equals("=")) {
                operator = "$";
                firstOperand = 0;
            }
            if (operator.equals("$")) {
                if (firstOperand >= 0) {
                    firstOperand = firstOperand * 10 + inputNumber;
                }
                else {
                    firstOperand = firstOperand * 10 - inputNumber;
                }
                result.setText(String.valueOf(firstOperand));
            }
            else {
                if (secondOperand >= 0) {
                    secondOperand = secondOperand * 10 + inputNumber;
                }
                else {
                    secondOperand = secondOperand * 10 - inputNumber;
                }
                result.setText(String.valueOf(secondOperand));
            }
            stack.add(String.valueOf(inputNumber));
        }
    }

    /** Initialization */
    @FXML
    void initialize() {

        stack.add("0");

        deleteAll.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Method which deletes all input information
             * @param event - event variable
             */
            @Override
            public void handle(ActionEvent event) {
                firstOperand = secondOperand = 0;
                operator = "$";
                result.setText("0");
            }
        });

        deleteLast.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Method which deletes last element from the input
             * @param event - event variable
             */
            @Override
            public void handle(ActionEvent event) {
                if (operator.equals("$")) {
                    firstOperand /= 10;
                    int i = (int) firstOperand;
                    firstOperand = Double.valueOf(i);
                    result.setText(Double.toString(firstOperand));
                } else {
                    secondOperand /= 10;
                    int i = (int) secondOperand;
                    secondOperand = Double.valueOf(i);
                    result.setText(Double.toString(secondOperand));
                }
            }
        });

        changeSign.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Method which changes the sign of the input number
             * @param event - event variable
             */
            @Override
            public void handle(ActionEvent event) {
                if (operator.equals("$")) {
                    firstOperand *= -1;
                    result.setText(Double.toString(firstOperand));
                } else {
                    secondOperand *= -1;
                    result.setText(Double.toString(secondOperand));
                }
            }
        });
    }

    /**
     * Method counts the result of an expression
     * @param first - the first operand
     * @param second - the second operand
     * @param action - the operator
     * @return the result of an operation
     * @throws DivisionByZeroException when user tries to divide by zero
     */
    private double count(double first, double second, String action) throws DivisionByZeroException {
        switch (action) {
            case "+" :
                return first + second;
            case "*" :
                return first * second;
            case "-" :
                return first - second;
            case "/" :
                if (second != 0) {
                    return Double.valueOf(first) / Double.valueOf(second);
                }
                else {
                    throw new DivisionByZeroException();
                }
        }
        return 0;
    }

    /**
     * Method which counts square root from the Number and throws an exception
     * @param actionEvent - event variable
     * @throws SqrtFromNegativeDigit when the number is negative
     */
    public void sqrt (ActionEvent actionEvent) throws SqrtFromNegativeDigit {
        if (actionEvent.getSource() instanceof Button) {
            Button button = (Button) actionEvent.getSource();
            double number = Double.valueOf(result.getText());
            if (number < 0) {
                throw new SqrtFromNegativeDigit();
            }
            else {
                result.setText(String.valueOf(Math.sqrt(number)));
                if (operator.equals("$")) {
                    firstOperand = Math.sqrt(firstOperand);
                }
                else {
                    secondOperand = Math.sqrt(secondOperand);
                }
                System.out.println(firstOperand + " " + secondOperand);
            }
        }
    }
}
