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
        SpinnerValueFactory<Integer> valuesFirst = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9, 0);
        SpinnerValueFactory<Integer> valuesSecond = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9, 0);
        firstOperand.setValueFactory(valuesFirst);
        secondOperand.setValueFactory(valuesSecond);
        ChangeListener<Character> changeListenerChar = new ChangeListener<>() {

            /** Method which recounts an expression when operator changes */
            @Override
            public void changed(ObservableValue<? extends Character> observable, Character oldValue, Character newValue) {
                String answer = count(firstOperand.getValue(), secondOperand.getValue(), operator.getValue());
                if (answer != null) {
                    result.setText(answer);
                }
                else {
                    result.setText("Wrong");
                }
            }
        };
        ChangeListener<Integer> changeListenerInt = new ChangeListener<Integer>() {

            /** Method which recounts an expression when operands change */
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                String answer = count(firstOperand.getValue(), secondOperand.getValue(), operator.getValue());
                if (answer != null) {
                    result.setText(answer);
                }
                else {
                    result.setText("Wrong");
                }
            }
        };
        operator.getSelectionModel().selectedItemProperty().addListener(changeListenerChar);
        firstOperand.valueProperty().addListener(changeListenerInt);
        secondOperand.valueProperty().addListener(changeListenerInt);
    }

    /**
     * Method which rewrites the label after changing parameters and recounting the result.
     * @param first - the first operand
     * @param second - the second operand
     * @param action - the operator
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

