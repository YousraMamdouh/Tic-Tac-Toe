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

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private Socket socket;
    private String msg;
    private final int count = 0;
    private boolean isStarted;

    public Game() {
        isStarted = false;
    }

    public void setMsg(String message) {
        msg = message;
    }

    public String getMsg() {
        return msg;
    }

    void connect(String ipAddress) {
        if (!isStarted) {

            try {
                socket = new Socket(ipAddress, 5005);
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectInputStream = new ObjectInputStream(socket.getInputStream());
            } catch (IOException e) {
                ErrorHandling.showDialog(Alert.AlertType.ERROR, "Error", "Failed to connect to server", true);
            }
            startListeining();
            isStarted = true;
        }
    }

    public void sendMsg(Document doc/*, MessageSetterListener listener*/) throws IOException, TransformerException {


        objectOutputStream.writeObject(doc);
        // listener.setMessage("");
    }

    public void startListeining() {

        new Thread(() -> {
            while (true) {
                try {

                    Document doc = (Document) objectInputStream.readObject();

                    if (doc.getDocumentElement().getTagName().equals("Success-Sign-Up")) {
                        setMsg(doc.getElementsByTagName("Message").item(0).getTextContent());

                        System.out.println(getMsg());


                    } else if (doc.getDocumentElement().getTagName().equals("Failed-Sign-Up")) {
                        setMsg(doc.getElementsByTagName("Message").item(0).getTextContent());
                        System.out.println(getMsg());
                    } else if (doc.getDocumentElement().getTagName().equals("Success-Login")) {
                        setMsg(doc.getElementsByTagName("Message").item(0).getTextContent());
                        System.out.println(getMsg());
                    } else if (doc.getDocumentElement().getTagName().equals("Failed-Login")) {
                        setMsg(doc.getElementsByTagName("Message").item(0).getTextContent());
                        System.out.println(getMsg());
                    }

                    else if (doc.getDocumentElement().getNodeName().equals("root")){
                        String msg = ModifyXMLFile.getMsg(doc);
                        String me = ModifyXMLFile.getTo(doc);
                        String other = ModifyXMLFile.getFrom(doc);
                        System.out.println(msg + me + other);
                        msg="ACCEPT";
                        ModifyXMLFile.updateElementValue(doc,me,other,msg);
                        System.out.println(msg + me + other);
                        sendMsg(doc);
                    }


                    //  if(doc !=null)
                } catch (IOException | TransformerFactoryConfigurationError | ClassNotFoundException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TransformerException e) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
                }
            }


        }).start();
    }


}

