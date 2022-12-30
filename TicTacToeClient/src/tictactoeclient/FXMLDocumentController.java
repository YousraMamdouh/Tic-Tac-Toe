/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 *
 * @author ramy3
 */
public class FXMLDocumentController implements Initializable {


    private Stage stage;


    @FXML
   private Button noButton;
   @FXML
   private Button yesButton;

    @FXML
    private void setNoButton() {

        stage = (Stage) noButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void setYesButton(){
        stage = (Stage) yesButton.getScene().getWindow();
        System.out.println("you're back to main menu");
        stage.close();
    }
    @FXML
    private void setBackArrowMethod() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ExitPopUp.fxml")));
        stage = new Stage();
        //scene = new Scene(root);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.showAndWait();

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
