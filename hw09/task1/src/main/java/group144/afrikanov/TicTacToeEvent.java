package group144.afrikanov;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** Class realizing objects contains information about actions need to be sent */
public class TicTacToeEvent implements Serializable {

    private TicTacToeEventAction ticTacToeEventAction;
    private TicTacToe.Player sender;
    private ActionType actionType;

    /** Type of action will be send */
    public enum ActionType {NEW_GAME, CLICK_ON_FIELD, EXIT_GAME}

    /**
     * Creates TicTacToeEvent
     *
     * @param ticTacToeEventAction action will be sent
     * @param sender player who makes this action
     * @param actionType type of action will be send
     */
    public TicTacToeEvent(TicTacToeEventAction ticTacToeEventAction, TicTacToe.Player sender, ActionType actionType) {
        this.ticTacToeEventAction = ticTacToeEventAction;
        this.actionType = actionType;
        this.sender = sender;
    }

    /**
     * Receive TicTacToeEvent from stream
     *
     * @param stream the source TicTacToeEvent will be received from
     */
    public TicTacToeEvent(ObjectInputStream stream) {
        TicTacToeEvent ticTacToeEvent = read(stream);
        while (ticTacToeEvent == null) {
            ticTacToeEvent = read(stream);
        }
        this.ticTacToeEventAction = ticTacToeEvent.ticTacToeEventAction;
        this.sender = ticTacToeEvent.sender;
        this.actionType = ticTacToeEvent.actionType;
    }

    /**
     * Send TicTacToeEvent to given stream
     *
     * @param stream action will be sent in
     * @throws IOException if something wrong with connection
     */
    public void send(ObjectOutputStream stream) throws IOException {
        stream.writeObject(this);
        stream.flush();
    }

    /**
     * Returns action of TicTacToeEvent
     *
     * @return action of TicTacToeEvent
     */
    public TicTacToeEventAction geTicTacToetEventAction() {
        return ticTacToeEventAction;
    }

    /** Returns action type of TicTacToeEvent */
    public ActionType getActionType() {
        return actionType;
    }

    /** Interface of action will be sent */
    public interface TicTacToeEventAction {}

    /** Action when player clicks new game button */
    public static class NewGameClickAction implements TicTacToeEventAction, Serializable {}

    /** Action when player closes the game */
    public static class ExitGameClickAction implements TicTacToeEventAction, Serializable {}

    private TicTacToeEvent read(ObjectInputStream stream) {
        try {
            return (TicTacToeEvent) stream.readObject();
        } catch (IOException e) {
            System.out.println("Something wrong with connection");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** Action when player clicks field button */
    public static class ClickOnFieldAction implements TicTacToeEventAction, Serializable {
        private int row;
        private int column;

        public ClickOnFieldAction(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }
}
