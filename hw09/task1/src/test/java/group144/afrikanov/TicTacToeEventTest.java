package group144.afrikanov;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeEventTest {

    @Test
    public void sendTest() throws IOException, ClassNotFoundException {
        TicTacToeEvent ticTacToeEvent = new TicTacToeEvent(new TicTacToeEvent.ExitGameClickAction(), TicTacToe.Player.X, TicTacToeEvent.ActionType.EXIT_GAME);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        ticTacToeEvent.send(objectOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        TicTacToeEvent received = (TicTacToeEvent) objectInputStream.readObject();
        assertEquals(received.getActionType(), ticTacToeEvent.getActionType());
    }
}