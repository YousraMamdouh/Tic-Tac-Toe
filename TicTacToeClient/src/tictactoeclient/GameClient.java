package tictactoeclient;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

class Game extends Thread {

    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private Socket socket;
    private static String msg;
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
                    }else if(doc.getDocumentElement().getTagName().equals("players")){

                        List<Player> playerList = PlayerDoc.docToPlayerList(doc);
                        CurrentSession.setPlayersList(playerList);
                    }else if(doc.getDocumentElement().getTagName().equals("Recorded_Games")){

                        List<GameHistory> gameHistoryList = GameDoc.docToGameList(doc);
                        CurrentSession.setGameHistoryList(gameHistoryList);
                    }

                    else if (doc.getDocumentElement().getNodeName().equals("root")){
                        String msg = ModifyXMLFile.getMsg(doc);
                        String me = ModifyXMLFile.getTo(doc);
                        String other = ModifyXMLFile.getFrom(doc);

                        if (msg =="request"){
                            msg="accept";
                            ModifyXMLFile.updateElementValue(doc,me,other,msg);
                            sendMsg(doc);
                        }

                        Platform.runLater(()->{
                            try {
                               // profileController.myInstance2.requestRecived();
                                profileController.myInstance2.switchToGame();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });


                    }
                    else if(doc.getDocumentElement().getNodeName().equals("move")){
                        setMsg(doc.getElementsByTagName("msg").item(0).getTextContent());
//                        Platform.runLater(()->{
//                            try {
//                                // profileController.myInstance2.requestRecived();
//                                profileController.myInstance.switchToGame();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        });

                    }
                } catch (IOException | TransformerFactoryConfigurationError | ClassNotFoundException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TransformerException e) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
                }
            }


        }).start();
    }


}

