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
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author ramy3
 */
public class GameBoardController implements Initializable {


    private static Stage stage;
    private Stage popUpStage;
    private Parent root;
    private Scene scene;
    @FXML
    private Button noButton;
    @FXML
    private Button yesButton;


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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


}
