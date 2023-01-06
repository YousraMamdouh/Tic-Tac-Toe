package tictactoeclient;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.logging.Logger;

public class GameClient extends Thread {

    private static BufferedReader inputStream;
    private static PrintStream outputStream;
    private static Socket socket;

    public static void connect(String ipAddress, int portNumber) {
        try {
            socket = new Socket(InetAddress.getByName(ipAddress), portNumber);
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputStream = new PrintStream(socket.getOutputStream());

        } catch (IOException e) {
            ErrorHandling.showDialog(Alert.AlertType.ERROR, "Error", "Failed to connect to server", true);
        }
        startListening();
    }

    public static void sendRequest(String line) {
        outputStream.println(line);
    }


    public static void startListening() {
        new Thread(() ->
        {
            try {
                while (socket != null && !(socket.isClosed())) {
                    String str = inputStream.readLine();
                    System.out.println(str);
                    //ha3mel eh ba2a yattar lama tegely msg
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
