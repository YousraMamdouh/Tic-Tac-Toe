package TicTacToeServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameServer {

    private ServerSocket serverSocket;
    private  Boolean isRunning = true;

    public GameServer() {
        isRunning = true;
    }

     void connect(int portNumber) {
        new Thread(() -> {

            try {
                serverSocket = new ServerSocket(portNumber);
                while (true) {
                    Socket client = serverSocket.accept();
                    System.out.println("New client connected :" + client.getRemoteSocketAddress());
                    new ClientHandler(client);
                }
            } catch (IOException ex) {
                Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }).start();


    }


    public  void stop() {
        isRunning = false;
        if (serverSocket == null) return;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

