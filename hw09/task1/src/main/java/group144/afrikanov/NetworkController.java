package group144.afrikanov;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/** Controller class for FXML file */
public class NetworkController extends Controller {

    @FXML
    protected Button newGameButton;

    /** Enum realizing status of current app */
    public enum Status {MY_TURN, WAITING_FOR_TURN, EXITING}

    /** Status of current app */
    public Status status;

    private TicTacToe.Player player;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    /** Action when current player closes the game */
    public void exitAction() {
        TicTacToeEvent exitEvent = new TicTacToeEvent(new TicTacToeEvent.ExitGameClickAction(), player, TicTacToeEvent.ActionType.EXIT_GAME);
        sendEvent(exitEvent);
    }

    /** Starts a new game */
    @Override
    public void newGame() {
        super.newGame();
        if (player == TicTacToe.Player.O) {
            setSnooze(true);
            updateLabel("Waiting...");
            status = Status.WAITING_FOR_TURN;
            waitForAnotherPlayer();
        } else {
            status = Status.MY_TURN;
            setSnooze(false);
            updateLabel("Your turn");
        }
    }

    /**
     * Method sets up controller options before the app showing
     *
     * @param player the player of this app
     * @param socket socket data will be transferred
     * @throws IOException if something wrong with socket
     */
    public void setOptions(TicTacToe.Player player, Socket socket) throws IOException {
        this.player = player;
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());
        newGame();
    }

    /**
     * Changes controls availability
     *
     * @param isDisabled true to disable controls, false to make them available
     */
    public void setSnooze(boolean isDisabled) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonArray[i][j].setDisable(isDisabled);
            }
        }
        newGameButton.setDisable(isDisabled);
    }

    /** Evaluates when game is over, for instance, when somebody wins or it is draw */
    public void endGame() {
        Alert finishMessage = new Alert(Alert.AlertType.INFORMATION);
        finishMessage.setTitle("Game over");
        if (game.hasWinner()) {
            finishMessage.setContentText("Player " + (game.getPlayer() == TicTacToe.Player.X ? "O" : "X") + " wins!");
        } else {
            finishMessage.setContentText("Draw!");
        }
        finishMessage.showAndWait();
        newGame();
    }

    /**
     * Evaluates TicTacToeEvent from other player
     *
     * @param TicTacToeEvent received from other player
     */
    public void evaluate(TicTacToeEvent TicTacToeEvent) {
        switch (TicTacToeEvent.getActionType()) {
            case NEW_GAME:
                Alert finishMessage = new Alert(Alert.AlertType.INFORMATION);
                finishMessage.setTitle("Game over");
                finishMessage.setContentText("Your opponent started new game");
                finishMessage.showAndWait();
                newGame();
                break;
            case CLICK_ON_FIELD:
                setSnooze(false);
                TicTacToeEvent.ClickOnFieldAction clickOnFieldAction = (TicTacToeEvent.ClickOnFieldAction) TicTacToeEvent.geTicTacToetEventAction();
                status = Status.MY_TURN;
                updateLabel("Your turn");
                updateButton(clickOnFieldAction.getRow(), clickOnFieldAction.getColumn());
                if (game.isFinished()) {
                    endGame();
                }
                break;
            case EXIT_GAME:
                Alert exitMessage = new Alert(Alert.AlertType.INFORMATION);
                exitMessage.setTitle("Game over");
                exitMessage.setContentText("Your opponent left the game.\nAfter clicking OK it will be closed");
                exitMessage.showAndWait();
                status = Status.EXITING;
                Platform.exit();
                break;
        }
    }

    /** Action when played clicks field button */
    @Override
    public void nextTurn(ActionEvent event) {
        int row = getEventSourceRow(event);
        int column = getEventSourceColumn(event);
        if (buttonArray[row][column].textProperty().get().equals("")) {
            TicTacToeEvent ticTacToeEvent = new TicTacToeEvent(new TicTacToeEvent.ClickOnFieldAction(row, column), player, TicTacToeEvent.ActionType.CLICK_ON_FIELD);
            updateLabel("Waiting...");
            setSnooze(true);
            sendEvent(ticTacToeEvent);
            updateButton(row, column);
            if (game.isFinished()) {
                endGame();
            } else {
                waitForAnotherPlayer();
            }
            status = Status.WAITING_FOR_TURN;
        }
    }

    /** Action when new game button is clicked */
    @FXML
    public void newGameButtonEvent(ActionEvent event) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Start new game");
        confirmation.setContentText("Click OK to start new game");
        confirmation.showAndWait();
        if (confirmation.getResult() == ButtonType.OK) {
            TicTacToeEvent ticTacToeEvent = new TicTacToeEvent(new TicTacToeEvent.NewGameClickAction(), player, TicTacToeEvent.ActionType.NEW_GAME);
            setSnooze(true);
            sendEvent(ticTacToeEvent);
            newGame();
        }
    }

    /**
     * Send action to another player
     *
     * @param event action should be sent
     */
    public void sendEvent(TicTacToeEvent event) {
        try {
            if (inputStream.available() == 0) {
                event.send(outputStream);
            } else {
                evaluate((TicTacToeEvent) inputStream.readObject());
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    /** Creates a thread waiting for another player actions */
    public void waitForAnotherPlayer() {
        new Thread(() -> {
            TicTacToeEvent newEvent = new TicTacToeEvent(inputStream);
            Platform.runLater(() -> evaluate(newEvent));
        }).start();
    }
}