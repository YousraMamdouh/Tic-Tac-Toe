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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.Document;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author ramy3
 */

public class HomePageController implements Initializable {
    @FXML
    Button loginButton;
    @FXML
    Button signupButton;
    @FXML
    Button loginPageButton;
    @FXML
    Button signupPageButton;
    @FXML
    Button cancelButton;
    @FXML
    TextField emailTextField,usernameTextField;
    @FXML
    PasswordField passField,confirmPassField;
    @FXML
    Label warningLabel;
    @FXML
    Button onlineMultiplayerButton;
    private static Button multip;





    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void openLoginPage() throws IOException {

        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("Login_Popup.fxml"));
        scene = new Scene(root, 900, 600);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.showAndWait();

    }

    public void openSignupPage(ActionEvent event) throws IOException {
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("Signup_Popup.fxml"));
        scene = new Scene(root, 900, 600);
        stage.setTitle("sign up Page");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.showAndWait();
    }



    @FXML
    public void cancelAction(ActionEvent event) throws IOException
    {
        stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML

    public void openDifficultyWindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Difficulty_Window.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();
    }

    @FXML

    public void openGameBoardWindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Multiplayer_Board.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();



    }
    @FXML

    public void openProfileWindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Profile_window.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    public void loggingIn(ActionEvent event) throws IOException, ParserConfigurationException, TransformerException {
        if(emailTextField.getText().isEmpty()==false&&passField.getText().isEmpty()==false)
        {
            Player player= new Player(emailTextField.getText(), passField.getText());
            warningLabel.setText("logging in");
           Document document= LoggingIn_XML.validate(player);
           Game.connect("localhost");
           Game.sendMsg(document);

        }
        else {
            warningLabel.setText("email or password is missing ");
        }
    }


    @FXML
    public void signingUp(ActionEvent event) throws IOException, ParserConfigurationException, TransformerException, ClassNotFoundException {
        if(emailTextField.getText().isEmpty()==false&&passField.getText().isEmpty()==false&&confirmPassField.getText().isEmpty()==false&&usernameTextField.getText().isEmpty()==false)
        {
            if(passField.getText().equals(confirmPassField.getText())) {

                Player player=new Player(0, usernameTextField.getText(), 0,0, emailTextField.getText(), passField.getText());
                warningLabel.setText("singing up");
                Document document= signingup_XML.validate(player);
                Game.connect("localhost");
                Game.sendMsg(document);

                usernameTextField.clear();
                passField.clear();
                emailTextField.clear();
                confirmPassField.clear();

            }
            else {
                warningLabel.setText("Passwords are not matching");
            }
        }
        else {
            warningLabel.setText("Please Enter your full data!");
        }


    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //onlineMultiplayerButton.setDisable(true);

    }
}

