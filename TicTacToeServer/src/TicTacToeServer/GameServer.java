package TicTacToeServer;

import com.sun.corba.se.spi.activation.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameServer {
    private static ServerSocket server;
    private static int port;
    private static Boolean isRunning = true;

    static void connect(int portNumber){
        port = portNumber;
        try {
            server = new ServerSocket(port);
            //server.setReuseAddress(true);
            while (true) {

                if (isRunning) {
                    Socket client = server.accept();
                    System.out.println("New client connected"+ client.getInetAddress().getHostAddress());
                    ClientHandler clientSock= new ClientHandler(client);
                    new Thread(clientSock).start();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void stop() {
        isRunning = false;
        if(server == null) return;
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

