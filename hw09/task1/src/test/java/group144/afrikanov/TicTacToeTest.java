package group144.afrikanov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void getPlayerTest() {
        TicTacToe game = new TicTacToe();
        game.nextTurn(0, 0);
        assertEquals(TicTacToe.Player.O, game.getPlayer());
        game.nextTurn(1, 1);
        assertEquals(TicTacToe.Player.X, game.getPlayer());
        game.nextTurn(1, 1);
        assertEquals(TicTacToe.Player.X, game.getPlayer());
    }

    @Test
    public void nextTurn() {
        TicTacToe game = new TicTacToe();
        game.nextTurn(0, 0);
        game.nextTurn(0, 1);
        assertEquals(TicTacToe.Player.X, game.getPlayer());
        game.nextTurn(0, 0);
        assertEquals(TicTacToe.Player.X, game.getPlayer());
        game.nextTurn(0, 2);
        assertFalse(game.isFinished());
    }

    @Test
    public void hasWinner() {
        TicTacToe game = new TicTacToe();
        game.nextTurn(0, 0);
        assertFalse(game.hasWinner());
        game.nextTurn(1, 0);
        assertFalse(game.hasWinner());
        game.nextTurn(0, 1);
        assertFalse(game.hasWinner());
        game.nextTurn(2, 0);
        assertFalse(game.hasWinner());
        game.nextTurn(0, 2);
        assertTrue(game.hasWinner());
    }

    @Test
    public void isFinished() {
        TicTacToe game = new TicTacToe();
        game.nextTurn(0, 0);
        game.nextTurn(0, 1);
        game.nextTurn(0, 2);
        game.nextTurn(1, 0);
        game.nextTurn(1, 1);
        game.nextTurn(1, 2);
        assertFalse(game.isFinished());
        game.nextTurn(2, 1);
        game.nextTurn(2, 2);
        game.nextTurn(2, 0);
        assertTrue(game.isFinished());
    }
}
