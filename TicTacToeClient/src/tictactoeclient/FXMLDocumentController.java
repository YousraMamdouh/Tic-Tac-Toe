/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author saraeltlt
 */
public class FXMLDocumentController {
    private Stage stage;

    
    private Scene scene;
    private Parent root;
    public void switchToProfile(ActionEvent event ) throws IOException{
      
        stage  = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    
    }
     public void switchToRequest(ActionEvent event ) throws IOException{
         
      
       Parent root = FXMLLoader.load(getClass().getResource("/tictactoeclient/Request_popup.fxml"));
        stage = new Stage();
        
        scene = new Scene(root);
        stage.setScene(scene);
         stage.initModality(Modality.APPLICATION_MODAL);
         stage.initOwner( requestButton.getScene().getWindow());
         stage.initStyle(StageStyle.UNDECORATED);
         stage.initStyle(StageStyle.TRANSPARENT);
         scene.setFill(Color.TRANSPARENT);
     
        stage.showAndWait(); 
        
    }
    
    private Label label;
    @FXML
    private Label userNameLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Button logoutButton;
    @FXML
    private Button requestButton;
     @FXML
     private Button cancelButton;
     
     private AnchorPane anchorPane;
    
   
    
}
