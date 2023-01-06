/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;


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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MultiplayerModeController implements Initializable {
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
    private ImageView img_zero;
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
    private final List<ImageView> imageViews;
    private static Stage stage;
    private Stage popUpStage;

    public MultiplayerModeController() {
        imageViews = new ArrayList<>();
        currentGame = new MultiplayerGame();
        isX = true;
    }

    @FXML
    private void exitPopup() throws IOException {
        stage = (Stage) player2Label.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MP_exit.fxml")));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MP_result.fxml"));
        Parent root = loader.load();
        MultiplayerModeController controller = loader.getController();
        controller.winnerLabel.setText(winner);
        createPopup(root);
    }

    @FXML
    private void exitGame(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.FXML")));
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
        int cell = Integer.parseInt(((Button) ae.getSource()).getText());
        turnSwitch(cell);
    }


    private void statusChecker() {
        String result = currentGame.gameState();
        System.out.println(result);
        if (!result.equals("n")) {
            try {
                resultPopup(result + " Wins!");
            } catch (IOException e) {
                System.out.println("Error Loading Window");
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
        imageViews.add(img_zero);
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

                imageViews.get(cell).setImage(new Image("res/X.png"));
            } else {

                imageViews.get(cell).setImage(new Image("res/O.png"));
            }
            isX = !isX;
            playerOne_Turn.setVisible(isX);
            playerTwo_Turn.setVisible(!isX);
            statusChecker();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setNamesOnBoard();
        containImgViews();
    }
}
