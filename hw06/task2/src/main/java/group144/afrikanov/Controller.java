package group144.afrikanov;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/** Controller for Sample.fxml file */
public class Controller {

    private char signWill = 'X';

    @FXML
    private Label winner;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    private Button[][] buttons;

    /**
     * Method changes the sign on the button
     * @param sign - the initial sign on the button
     * @return Changed sign of the button
     */
    private char changeSign(Character sign) {
        if (sign == 'X') {
            return('O');
        }
        else {
            return('X');
        }
    }

    /**
     * Method detects the winner of a game
     * @return the winning sign
     */
    private String isVictory() {
        if (!button1.getText().equals("") && button1.getText().equals(button2.getText()) &&
                button1.getText().equals(button3.getText())) {
            return button1.getText();
        }
        if (!button4.getText().equals("") && button4.getText().equals(button5.getText()) &&
                button4.getText().equals(button6.getText())) {
            return button4.getText();
        }
        if (!button7.getText().equals("") && button7.getText().equals(button8.getText()) &&
                button7.getText().equals(button9.getText())) {
            return button7.getText();
        }
        if (!button1.getText().equals("") && button1.getText().equals(button4.getText()) &&
                button1.getText().equals(button7.getText())) {
            return button1.getText();
        }
        if (!button2.getText().equals("") && button2.getText().equals(button5.getText()) &&
                button2.getText().equals(button8.getText())) {
            return button2.getText();
        }
        if (!button3.getText().equals("") && button3.getText().equals(button6.getText()) &&
                button6.getText().equals(button9.getText())) {
            return button3.getText();
        }
        if (!button1.getText().equals("") && button1.getText().equals(button5.getText()) &&
                button1.getText().equals(button9.getText())) {
            return button1.getText();
        }
        if (!button3.getText().equals("") && button3.getText().equals(button5.getText()) &&
                button3.getText().equals(button7.getText())) {
            return button3.getText();
        }
        return "";
    }

    /**
     * Method handles clicks on buttons. It stands current sign on pressed button
     * @param event - action event variable
     */
    @FXML
    void fieldClick(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button button = (Button) event.getSource();
            String signNow = button.getText();
            if (signNow.equals("")) {
                signNow = String.valueOf(signWill);
                signWill = changeSign(signWill);
                button.setText(signNow);
            }
            String winSign = isVictory();
            if (!winSign.equals("")) {
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        buttons[i][j].setDisable(true);
                    }
                }
                winner.setText("Winner : " + winSign);
            }
        }
    }

    /**
     * Method returns all fields to the initial condition
     * @param actionEvent - action event variable
     */
    @FXML
    public void newGame(ActionEvent actionEvent) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                buttons[i][j].setText("");
            }
        }
        signWill = 'X';
        winner.setText("Winner :");
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                buttons[i][j].setDisable(false);
            }
        }
    }

    /** Initialization method */
    @FXML
    void initialize() {
        buttons = new Button[][]{{button1, button2, button3},
                {button4, button5, button6},
                {button7, button8, button9}};
    }
}
