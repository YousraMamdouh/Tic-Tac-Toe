package TicTacToeServer;

import com.sun.corba.se.spi.activation.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameServer implements Runnable {

    private static Thread serverThread;
    private static ServerSocket serverSocket;
    private static int port;
    private static Boolean isRunning = true;
    public static Thread getServer() {
        return serverThread;
    }
    private GameServer(int port) {
        this.port =port;
        isRunning = true;
        serverThread = new Thread(new GameServer(port));
        serverThread.start();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                if (isRunning) {
                    Socket s = serverSocket.accept();
                    new ClientHandler(s);

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void stop() {
        isRunning = false;
        if(serverSocket == null) return;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

