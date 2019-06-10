package group144.afrikanov;

/** Class for performing tic-tac-toe game logic */
public class TicTacToe {

    /** Enum of player types */
    public enum Player {X, O}

    /** Enum of states button can have */
    private enum ButtonState {X, O, NO}

    private ButtonState[][] buttons;

    private Player currentPlayer = Player.X;

    public TicTacToe() {
        buttons = new ButtonState[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = ButtonState.NO;
            }
        }
    }

    /** Returns the current player, which turn is been waiting */
    public Player getPlayer() {
        return currentPlayer;
    }

    /**
     * Realizes the action when user wants to change X or O value of game field.
     *
     * @param row row of field from 0 to 2
     * @param column column of field from 0 to 2
     * @return the new text for field pressed
     */
    public String nextTurn(int row, int column) {
        String result;
        if (buttons[row][column] == ButtonState.NO) {
            buttons[row][column] = (currentPlayer == Player.X) ? ButtonState.X : ButtonState.O;
            result = (currentPlayer == Player.X) ? "X" : "O";
            currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
        } else {
            result = (buttons[row][column] == ButtonState.X) ? "X" : "O";
        }
        return result;
    }

    /** Returns true if there are some three same symbols in one line */
    public boolean hasWinner() {
        boolean result = false;
        for (int i = 0; i < 3; i++) {
            result |= buttons[i][0] == buttons[i][1] &&
                    buttons[i][1] == buttons[i][2] &&
                    buttons[i][0] != ButtonState.NO;
        }
        for (int column = 0; column < 3; column++) {
            result |= buttons[0][column] == buttons[1][column] &&
                    buttons[1][column] == buttons[2][column] &&
                    buttons[0][column] != ButtonState.NO;
        }
        result |= buttons[0][0] == buttons[1][1] &&
                buttons[1][1] == buttons[2][2] &&
                buttons[0][0] != ButtonState.NO;
        result |= buttons[0][2] == buttons[1][1] &&
                buttons[1][1] == buttons[2][0] &&
                buttons[0][2] != ButtonState.NO;
        return result;
    }

    /** Return true if all fields are filled or there are some three same symbols in one line */
    public boolean isFinished() {
        boolean result = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result &= buttons[i][j] != ButtonState.NO;
            }
        }
        return result || hasWinner();
    }
}