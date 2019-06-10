package group144.afrikanov;

import java.io.IOException;
import java.net.ServerSocket;

/** Class for starting server app */
public class MainServer {

    private static final int port = 1111;

    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            App.main(TicTacToe.Player.X, serverSocket.accept(), null);
        } catch (IOException e) {
            System.out.println("Problems with creating socket");
            e.printStackTrace();
        }
    }
}
