package group144.afrikanov;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button button00;

    @FXML
    private Button button01;

    @FXML
    private Button button02;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button20;

    @FXML
    private Button button21;

    @FXML
    private Button button22;

    @FXML
    private Label nextTurnLabel;

    /** Array contains all buttons contains X or O */
    public Button[][] buttonArray;

    /** Objects realizing all game  */
    public TicTacToe game;

    /** Initialization method */
    public void initialize() {
        buttonArray = new Button[][]{{button00, button01, button02},
                {button10, button11, button12},
                {button20, button21, button22}};
    }

    /**
     * Returns the row of clicked button
     *
     * @param event event of click
     * @return the row of clicked button
     */
    public int getEventSourceRow(ActionEvent event) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (event.getSource().equals(buttonArray[i][j])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Returns the column of clicked button
     *
     * @param event event of click
     */
    public int getEventSourceColumn(ActionEvent event) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (event.getSource().equals(buttonArray[row][column])) {
                    return column;
                }
            }
        }
        return -1;
    }

    /**
     * Changes text at button
     *
     * @param row the row of button
     * @param column the column of button
     */
    public void updateButton(int row, int column) {
        buttonArray[row][column].setText(game.nextTurn(row, column));
    }

    /**
     * Method for action when user wants to put X or O by a button click
     *
     * @param event action event
     */
    @FXML
    public void nextTurn(ActionEvent event) {
        int row = getEventSourceRow(event);
        int column = getEventSourceColumn(event);
        updateButton(row, column);
    }

    /**
     * Method for action when user clicks New Game Button
     *
     * @param event action event
     */
    @FXML
    public void newGameButtonEvent(ActionEvent event) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Start new game");
        confirmation.setContentText("Click OK to start new game");
        confirmation.showAndWait();
        if (confirmation.getResult() == ButtonType.OK) {
            newGame();
        }
    }

    /** Starts a new game */
    public void newGame() {
        game = new TicTacToe();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonArray[i][j].setText("");
            }
        }
    }

    /** Updates the text on label showing current player */
    public void updateLabel(String message) {
        nextTurnLabel.setText(message);
    }
}