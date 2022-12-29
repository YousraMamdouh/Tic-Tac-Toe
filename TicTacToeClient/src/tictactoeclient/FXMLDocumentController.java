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
import javafx.stage.Stage;

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
   private Scene scene;
   private Parent root ;

    @FXML
    private void noButtonClicked() throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameBoard.fxml")));
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void setBackArrowMethod() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ExitPopUp.fxml")));
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
