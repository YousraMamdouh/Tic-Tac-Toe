/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;

/**
 *
 * @author ramy3
 */

public class FXMLController  {
   @FXML
    Button loginButton;
   @FXML
   Button signupButton;

private Stage stage;
private Parent root;
private Scene scene;


   @FXML
    public void openLoginPage(ActionEvent event) throws IOException {
    stage = new Stage();
    root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
    scene=new Scene(root,900,600);
    stage.setTitle("Login Page");
    stage.setScene(scene);
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.showAndWait();



    }




    public void openSignupPage(ActionEvent event) throws IOException{


     stage = new Stage();
     root = FXMLLoader.load(getClass().getResource("SignupPage.fxml"));
     scene=new Scene(root,900,600);
     stage.setTitle("Login Page");
     stage.setScene(scene);
     stage.initModality(Modality.APPLICATION_MODAL);
     stage.showAndWait();
    }




}
