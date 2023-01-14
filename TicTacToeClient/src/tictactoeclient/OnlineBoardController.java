/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class OnlineBoardController implements Initializable {
    private final MultiplayerGame currentGame;
    private boolean isX;
    @FXML
    private Label winnerLabel;
    @FXML
    private Label player1Label;
    @FXML
    private Label player2Label;
    @FXML
    private Label playerOne_Turn;
    @FXML
    private Label playerTwo_Turn;
    @FXML
    private ImageView img_0;
    @FXML
    private ImageView img_1;
    @FXML
    private ImageView img_2;
    @FXML
    private ImageView img_3;
    @FXML
    private ImageView img_4;
    @FXML
    private ImageView img_5;
    @FXML
    private ImageView img_6;
    @FXML
    private ImageView img_7;
    @FXML
    private ImageView img_8;
    @FXML
    private Label recordingLabel;
    private final List<ImageView> imageViews;
    private static Stage stage;
    private static Stage popUpStage;
    private int i;


    public OnlineBoardController() {
        imageViews = new ArrayList<>();
        currentGame = new MultiplayerGame();
        isX = CurrentSession.getIsPlayerOne();
    }


    private void resetBoard() {
        isX = true;
        i = 0;
        for (ImageView iv : imageViews) {
            iv.setImage(null);
        }
        currentGame.resetBoard();
    }

    @FXML
    private void playRecord() {
        resetBoard();
        int[] record = CurrentSession.getRecordedGame();
        new Thread(() -> {
            try {
                while (i < 9 && record[i] >= 0) {
                    Platform.runLater(() -> {
                        System.out.println(i);
                        turnSwitch(record[i]);
                        i++;
                    });
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @FXML
    private void exitPopup() throws IOException {
        stage = (Stage) player2Label.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("OB_exit.fxml")));
        createPopup(root);
    }

    private void createPopup(Parent root) {
        Scene popup = new Scene(root);
        popup.setFill(Color.TRANSPARENT);
        popUpStage = new Stage();
        popUpStage.setScene(popup);
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.initStyle(StageStyle.TRANSPARENT);
        popUpStage.showAndWait();
    }

    private void resultPopup(String winner) throws IOException {
        stage = (Stage) player2Label.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OB_result.fxml"));
        Parent root = loader.load();
        MultiplayerModeController controller = loader.getController();
        controller.winnerLabel.setText(winner);
        try {
            //returns a Game Document should call a function to send to server

            CurrentSession.getGame().sendMsg(GameDoc.gameToDoc(currentGame.getGame()));
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
        createPopup(root);
    }

    @FXML
    private void exitGame(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        popUpStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.show();
        popUpStage.close();
    }

    @FXML
    private void closePopup(ActionEvent e) {
        popUpStage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        popUpStage.close();
    }

    @FXML
    private void setMove(ActionEvent ae) {
        if (isX) {
            int cell = Integer.parseInt(((Button) ae.getSource()).getText());
            turnSwitch(cell);
            try {
                CurrentSession.getGame().sendMsg(composeMsg(CurrentSession.getPlayer().getName(), CurrentSession.getCurrentOpponent().getName(), String.valueOf(cell), "move"));
                isX = false;
                CurrentSession.getGame().startListeining();
                int celle = Integer.parseInt(CurrentSession.getGame().getMsg());
                turnSwitch(celle);
                isX=true;
            } catch (TransformerException | IOException e) {
                e.printStackTrace();
            }
        } else {
            int p2cell = CurrentSession.getOpponentMove();
            turnSwitch(p2cell);
            isX = true;
        }

    }


    private void statusChecker() {
        String result = currentGame.gameState();
        System.out.println(result);
        if (!result.equals("n")) {
            try {
                resultPopup(result + " Wins!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setNamesOnBoard() {
        if (player2Label != null) {
            player1Label.setText(currentGame.getPlayerOne());
            player2Label.setText(currentGame.getPlayerTwo());
        }
    }

    private void containImgViews() {
        imageViews.add(img_0);
        imageViews.add(img_1);
        imageViews.add(img_2);
        imageViews.add(img_3);
        imageViews.add(img_4);
        imageViews.add(img_5);
        imageViews.add(img_6);
        imageViews.add(img_7);
        imageViews.add(img_8);
    }

    private void turnSwitch(int cell) {
        if (currentGame.setPlay(cell)) {
            if (isX) {
                isX = false;
                imageViews.get(cell).setImage(new Image("res/X.png"));
            } else {
                imageViews.get(cell).setImage(new Image("res/O.png"));
            }
            playerOne_Turn.setVisible(isX);
            playerTwo_Turn.setVisible(!isX);
            statusChecker();
        }
    }

    @FXML
    private void recordButton(ActionEvent ae) {
        Button button = (Button) ae.getSource();
        if (currentGame.recordSwitch()) {
            button.setText("Dont Save Record");
            recordingLabel.setText("Game Will Be Saved");
            recordingLabel.setTextFill(Color.GREEN);
        } else {
            button.setText("Save Record");
            recordingLabel.setText("Game Will not Be Saved");
            recordingLabel.setTextFill(Color.RED);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setNamesOnBoard();
        containImgViews();
    }

    private static Document createDoc() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return builder.newDocument();
    }

    private Document composeMsg(String from, String to, String msg, String header) {
        Document doc = createDoc();
        Element root = doc.createElement(header);
        Element child = (Element) (doc.createElement("from")).appendChild(doc.createTextNode(from));
        root.appendChild(child);
        child = (Element) (doc.createElement("to")).appendChild(doc.createTextNode(to));
        root.appendChild(child);
        child = (Element) (doc.createElement("msg")).appendChild(doc.createTextNode(msg));
        root.appendChild(child);
        doc.appendChild(root);
        return doc;
    }

    private String[] decomposeMsg(Document doc) {
        String[] message = new String[4];
        Element e = doc.getDocumentElement();
        message[0] = e.getElementsByTagName("from").item(0).getTextContent();
        message[1] = e.getElementsByTagName("to").item(0).getTextContent();
        message[2] = e.getElementsByTagName("msg").item(0).getTextContent();
        message[3] = e.getTagName();
        System.out.println("DOC = " + message[3] + " " + message[0] + " " + message[1] + " " + message[2]);
        return message;
    }


}
