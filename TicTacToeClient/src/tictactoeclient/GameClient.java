package tictactoeclient;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GameClient extends Thread {
    private static BufferedReader inputStream;
    private static PrintWriter outputStream;
    private static Socket socket;

    static void connect(String ipAddress, int portNumber){
        try{
            socket = new Socket(ipAddress, portNumber);
            outputStream = new PrintWriter(socket.getOutputStream(), true);
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e) {
            ErrorHandling.showDialog(Alert.AlertType.ERROR, "Error", "Failed to connect to server", true);
        }
        GameClient.startListeining();
    }
    public static void sendMsg(String line){
        outputStream.println(line);

    }

    public static void startListeining (){
        new Thread(() ->
        {
            try {
                while (socket != null && !(socket.isClosed())) {
                    String str = inputStream.readLine();
                    System.out.println("Server replied "+ str );
                    //ha3mel eh yatar
                }
            } catch (IOException ex) {
                Logger.getLogger(GameClient.class.getName()).log(Level.SEVERE, null, ex);
            }


        }).start();
    }




}
