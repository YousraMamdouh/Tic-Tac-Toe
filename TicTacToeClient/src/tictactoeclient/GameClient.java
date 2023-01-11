package tictactoeclient;

import javafx.scene.control.Alert;
import org.w3c.dom.Document;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class Game extends Thread {

    private static ObjectInputStream objectInputStream;
    private static ObjectOutputStream objectOutputStream;
    private static Socket socket;
    private static final int count = 0;

    static void connect(String ipAddress) {
        try {
            socket = new Socket(ipAddress, 1234);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            ErrorHandling.showDialog(Alert.AlertType.ERROR, "Error", "Failed to connect to server", true);
        }
        Game.startListeining();
    }

    public static void sendMsg(Document doc) throws IOException, TransformerException {


        objectOutputStream.writeObject(doc);
    }

    public static void startListeining() {

        new Thread(() -> {
            while (true) {
                try {

                    Document doc = (Document) objectInputStream.readObject();


                    //  if(doc !=null)
                    System.out.println("Sara");


                } catch (IOException | TransformerFactoryConfigurationError | ClassNotFoundException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        }).start();
    }


}

