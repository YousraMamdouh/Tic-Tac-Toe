/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.util.Objects;

/**
 * @author ramy3
 */
public class EasyAIController {
    EasyAIHandler gameHandler = new EasyAIHandler();

    public EasyAIController() {
    }

    private static Stage stage;
    private Stage popUpStage;
    private Parent root;
    private Scene scene;
    @FXML
    private Button noButton;
    @FXML
    private Button yesButton;
    @FXML
    private Label player1Label;
    @FXML
    private Label result_label;
    @FXML
    private Button ok_result;
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


    @FXML
    private void setBackArrowMethod(ActionEvent e) throws IOException {
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Exit_Popup.fxml")));
        popUpStage = new Stage();
        Scene exit = new Scene(root);
        exit.setFill(Color.TRANSPARENT);
        popUpStage.setScene(exit);
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.initStyle(StageStyle.TRANSPARENT);
        popUpStage.showAndWait();

    }

    @FXML
    private void setYesButton() throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.FXML")));
        scene = new Scene(root);
        stage.setScene(scene);
        popUpStage = (Stage) yesButton.getScene().getWindow();
        stage.show();
        popUpStage.close();


    }

    @FXML
    private void setNoButton() {

        popUpStage = (Stage) noButton.getScene().getWindow();
        popUpStage.close();
    }


    @FXML
    private void cell_zero(ActionEvent ev) throws IOException {

        play(0, ev);
        showWinner();
    }

    @FXML
    private void cell_1(ActionEvent ev) throws IOException {

        play(1,ev);
        showWinner();
    }

    @FXML
    private void cell_2(ActionEvent ev) throws IOException {
        play(2,ev);
        showWinner();
    }

    @FXML
    private void cell_3(ActionEvent ev) throws IOException {
        play(3,ev);
        showWinner();
    }

    @FXML
    private void cell_4(ActionEvent ev) throws IOException {
        play(4,ev);
        showWinner();
    }

    @FXML
    private void cell_5(ActionEvent ev) throws IOException {
        play(5,ev);
        showWinner();
    }

    @FXML
    private void cell_6(ActionEvent ev) throws IOException {
        play(6,ev);
        showWinner();
    }

    @FXML
    private void cell_7(ActionEvent ev) throws IOException {
        play(7,ev);
        showWinner();
    }

    @FXML
    private void cell_8(ActionEvent ev) throws IOException {
        play(8,ev);
        showWinner();


    }


    private void showresultPopUp(String winner) throws IOException {
        stage = (Stage) player1Label.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EasyResultWindow.fxml"));
        Parent root = loader.load();
        EasyAIController controller = loader.getController();
        controller.result_label.setText(winner);
        popUpStage = new Stage();
        Scene result = new Scene(root);
        result.setFill(Color.TRANSPARENT);
        popUpStage.setScene(result);
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.initStyle(StageStyle.TRANSPARENT);
        popUpStage.showAndWait();
    }



    @FXML
    private void resultPopUp() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.FXML")));
        scene = new Scene(root);
        stage.setScene(scene);
        popUpStage = (Stage) ok_result.getScene().getWindow();
        stage.show();
        popUpStage.close();

    }


    public void drawImage(String btnId, String turn) {

        Image image;

        if (turn.equals("X")) image = new Image("/res/X.png");
        else image = new Image("/res/O.png");

        char cell = btnId.charAt(0);
        if (cell == 'z') cell = '0';

        switch (cell) {
            case '0':
                img_zero.setImage(image);
                break;
            case '1':
                img_1.setImage(image);
                break;
            case '2':
                img_2.setImage(image);
                break;
            case '3':
                img_3.setImage(image);
                break;
            case '4':
                img_4.setImage(image);
                break;
            case '5':
                img_5.setImage(image);
                break;
            case '6':
                img_6.setImage(image);
                break;
            case '7':
                img_7.setImage(image);
                break;
            case '8':
                img_8.setImage(image);
                break;
        }

    }

    public void drawPcMove(int loc) {
        if (loc == -1) {
            System.out.println("GAME OVER!");
        } else if (gameHandler.getBoard(loc).equals("N")) {
            gameHandler.setBoard("O", loc);


            Image image;

            image = new Image("/res/O.png");

            switch (loc) {
                case 0:
                    img_zero.setImage(image);
                    break;
                case 1:
                    img_1.setImage(image);
                    break;
                case 2:
                    img_2.setImage(image);
                    break;
                case 3:
                    img_3.setImage(image);
                    break;
                case 4:
                    img_4.setImage(image);
                    break;
                case 5:
                    img_5.setImage(image);
                    break;
                case 6:
                    img_6.setImage(image);
                    break;
                case 7:
                    img_7.setImage(image);
                    break;
                case 8:
                    img_8.setImage(image);
                    break;
            }
        }

    }


    private void showWinner() throws IOException {
        if (!gameHandler.winnerName().equals("N")) showresultPopUp(gameHandler.winnerName());
    }

    private void play(int loc, ActionEvent ev) {
        if (gameHandler.isEndOfGame()) {
            if (gameHandler.getBoard(loc).equals("N")) {
                drawImage(((Button) ev.getSource()).getText(), gameHandler.getTurn());
                gameHandler.setBoard(gameHandler.getTurn(), loc);
                drawPcMove(gameHandler.setPCMove());

            }

        }
    }
}
