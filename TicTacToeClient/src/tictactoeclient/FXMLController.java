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
   @FXML
   Button loginPageButton;
   @FXML
   Button signupPageButton;

private Stage stage1,stage2;
private Scene scene1,scene2;
private Parent root1,root2;

   @FXML
    public void openLoginPage(ActionEvent event) throws IOException {

     stage1 = new Stage();
     root1 = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
     scene1 = new Scene(root1, 900, 600);
     stage1.setTitle("Login Page");
     stage1.setScene(scene1);
     stage1.initModality(Modality.APPLICATION_MODAL);
     stage1.showAndWait();

    }

    public void openSignupPage(ActionEvent event) throws IOException{
    stage2 = new Stage();
     root2= FXMLLoader.load(getClass().getResource("SignupPage.fxml"));
     scene2=new Scene(root2,900,600);
     stage2.setTitle("Login Page");
     stage2.setScene(scene2);
     stage2.initModality(Modality.APPLICATION_MODAL);
     stage2.showAndWait();
    }
@FXML
    public void loggingIn(ActionEvent event) throws IOException{

 stage1=(Stage)loginPageButton.getScene().getWindow();
 stage1.close();
}

@FXML
public void signingUp(ActionEvent event) throws IOException{

 stage2=(Stage)signupPageButton.getScene().getWindow();
 stage2.close();
}




}
