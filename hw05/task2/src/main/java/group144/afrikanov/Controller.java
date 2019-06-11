package group144.afrikanov;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;

public class Controller {

    /** The spinner with operator */
    @FXML
    private ChoiceBox<Character> operator;

    /** The spinner with first operand */
    @FXML
    private Spinner<Integer> firstOperand;

    /** The spinner with second operand */
    @FXML
    private Spinner<Integer> secondOperand;

    /** Label with the result of an expression */
    @FXML
    private Label result;

    /** Initialization */
    @FXML
    void initialize() {
        ObservableList<Character> items = FXCollections.observableArrayList('+', '-', '*', '/');
        operator.setItems(items);
        operator.setValue('+');
        SpinnerValueFactory<Integer> valuesFirst = new SpinnerValueFactory.IntegerSpinnerValueFactory(-9, 9, 0);
        SpinnerValueFactory<Integer> valuesSecond = new SpinnerValueFactory.IntegerSpinnerValueFactory(-9, 9, 0);
        firstOperand.setValueFactory(valuesFirst);
        secondOperand.setValueFactory(valuesSecond);
        ChangeListener changeListener = new ChangeListener() {

            /** Method changes the result of the expression when situation changes */
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                String answer = count(firstOperand.getValue(), secondOperand.getValue(), operator.getValue());
                if (answer != null) {
                    result.setText(answer);
                }
                else {
                    result.setText("Wrong");
                }
            }
        };
        operator.getSelectionModel().selectedItemProperty().addListener(changeListener);
        firstOperand.valueProperty().addListener(changeListener);
        secondOperand.valueProperty().addListener(changeListener);
    }

    /**
     * Method which gives the result of expression
     * @param first - the first operand
     * @param second - the second operand
     * @param action - the operator
     * @return answer - result of expression
     */
    public static String count(int first, int second, char action) {
        switch (action) {
            case '+' :
                return Integer.toString(first + second);
            case '*' :
                return Integer.toString(first * second);
            case '-' :
                return Integer.toString(first - second);
            case '/' :
                if (second != 0) {
                    return Double.toString((double) first / (double) second);
                }
                else {
                    return null;
                }
        }
        return null;
    }
}

