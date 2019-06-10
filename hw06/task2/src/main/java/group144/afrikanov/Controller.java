package group144.afrikanov;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.security.cert.CollectionCertStoreParameters;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Controller for Sample.fxml file */
public class Controller {

    private char signWill = 'X';
    private static final int SIZE = 3;

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

    private static List<List<Button> > buttons;
    private static Character[][] buttonValue;

    /**
     * Method changes the sign on the button
     * @param sign - the initial sign on the button
     * @return Changed sign of the button
     */
    private char changeSign(Character sign) {
        if (sign == 'X') {
            return('O');
        }
        return('X');
    }

    /**
     * Method detects the winner of a game
     * @param values - game field
     * @return the winning sign
     */
    public static Character isVictory(Character[][] values) {
        Character signOnStep = ' ';
        int equals;
        for (int i = 0; i < values.length; ++i) {
            equals = 0;
            signOnStep = values[i][0];
            if (signOnStep == ' ') {
                continue;
            }
            for (int j = 1; j < values.length; ++j) {
                if (signOnStep == values[i][j]) {
                    equals++;
                }
            }
            if (equals == SIZE - 1) {
                return signOnStep;
            }
        }
        for (int j = 0; j < values.length; ++j) {
            equals = 0;
            signOnStep = values[0][j];
            if (signOnStep == ' ') {
                continue;
            }
            for (int i = 1; i < values.length; ++i) {
                if (signOnStep == values[i][j]) {
                    equals++;
                }
            }
            if (equals == SIZE - 1) {
                return signOnStep;
            }
        }
        signOnStep = values[1][1];
        if (signOnStep != ' ') {
            equals = 0;
            for (int i = 0; i < values.length; ++i) {
                if (signOnStep == values[i][i]) {
                    equals++;
                }
            }
            if (equals == SIZE) {
                return signOnStep;
            }
            equals = 0;
            for (int i = 0, j = values.length - 1; j >= 0; ++i, --j) {
                if (signOnStep == values[i][j]) {
                    equals++;
                }
            }
            if (equals == SIZE) {
                return signOnStep;
            }
        }
        int steps = 0;
        for (int i = 0; i < values.length; ++i) {
            for (int j = 0; j < values.length; ++j) {
                if (values[i][j] != ' ') {
                    steps++;
                }
            }
        }
        if (steps == SIZE * SIZE) {
            return 'D';
        }
        return ' ';
    }

    /** Method handles clicks on buttons. It stands current sign on pressed button */
    @FXML
    private void fieldClick(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button button = (Button) event.getSource();
            int iPosition = -1;
            int jPosition = -1;
            for (int i = 0; i < SIZE; ++i) {
                for (int j = 0; j < SIZE; ++j) {
                    if (buttons.get(i).get(j) == button) {
                        iPosition = i;
                        jPosition = j;
                        break;
                    }
                }
            }
            String signNow = button.getText();
            if (signNow.equals(" ")) {
                signNow = String.valueOf(signWill);
                signWill = changeSign(signWill);
                button.setText(signNow);
                buttons.get(iPosition).get(jPosition).setText(String.valueOf(signNow));
                buttonValue[iPosition][jPosition] = signNow.charAt(0);
            }
            Character winSign = isVictory(buttonValue);
            if (winSign == 'X' || winSign == 'O') {
                endGame();
                winner.setText("Winner : " + winSign);
                return;
            }
            if (winSign == 'D') {
                endGame();
                winner.setText("Draw");
            }
        }
    }

    /** Method ends the game and makes buttons unable to be clicked */
    private static void endGame() {
        buttons.stream().peek(e -> e.stream().peek(element -> element.setDisable(true)).collect(Collectors.toList())).collect(Collectors.toList());
    }

    /** Method returns all fields to the initial condition */
    @FXML
    private void newGame(ActionEvent actionEvent) {
        for (int i = 0; i < buttons.size(); ++i) {
            for (int j = 0; j < buttons.size(); ++j) {
                buttons.get(i).get(j).setText(String.valueOf(' '));
            }
        }
        for (int i = 0; i < buttonValue.length; ++i) {
            for (int j = 0; j < buttonValue.length; ++j) {
                buttonValue[i][j] = ' ';
            }
        }
        signWill = 'X';
        winner.setText("The game is in progress");
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                buttons.get(i).get(j).setDisable(false);
            }
        }
    }

    /** Initialization method */
    @FXML
    private void initialize() {
        buttons = new ArrayList<>();
        buttons.add(Arrays.asList(button1, button2, button3));
        buttons.add(Arrays.asList(button4, button5, button6));
        buttons.add(Arrays.asList(button7, button8, button9));
        buttonValue = new Character[][]
                {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
    }
}
