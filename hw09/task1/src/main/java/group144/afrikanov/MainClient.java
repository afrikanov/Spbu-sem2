package group144.afrikanov;

import java.io.IOException;
import java.net.Socket;
import java.util.InputMismatchException;

/** Class for starting client app */
public class MainClient {

    private static final int port = 1111;

    public static void main(String[] args) {
        Socket socket;
        try {
            socket = new Socket("localhost", port);
            App.main(TicTacToe.Player.O, socket, null);
        } catch (IOException e) {
            System.out.println("Port is not open");
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Wrong value");
        }
    }
}