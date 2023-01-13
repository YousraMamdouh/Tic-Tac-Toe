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

    private  ObjectInputStream objectInputStream;
    private  ObjectOutputStream objectOutputStream;
    private  Socket socket;


    public void connect(String ipAddress) {
        try {
            socket = new Socket(ipAddress, 5005);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            ErrorHandling.showDialog(Alert.AlertType.ERROR, "Error", "Failed to connect to server", true);
        }
        this.startListeining();
    }

    public  void sendMsg(Document doc) throws IOException, TransformerException {


        objectOutputStream.writeObject(doc);
    }

    public  void startListeining() {

        new Thread(() -> {
            while (true) {
                try {


                    Document doc = (Document) objectInputStream.readObject();
                    String username = doc.getElementsByTagName("username").item(0).getTextContent();
                    System.out.println(username);


                } catch (IOException | TransformerFactoryConfigurationError | ClassNotFoundException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        }).start();
    }


}

