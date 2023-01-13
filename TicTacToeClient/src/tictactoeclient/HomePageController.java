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
 * @author ramy3
 */

public class HomePageController implements Initializable/* , MessageSetterListener */{
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
    TextField emailTextField, usernameTextField;
    @FXML
    PasswordField passField, confirmPassField;
    @FXML

    Label warningLabel;
    @FXML
    Button onlineMultiplayerButton;
    private static Button multip;
    String receivedSignupMsgFromServer;
    String receivedLoginMsgFromServer;
    private Game game;


   static private Stage stage;
   static private Stage PopupStage;
    private Scene scene;
    private Parent root;

    //public static void updateWarningLabel()
//{
//    System.out.println(Game.getMsg()+"home page");
//    warningLabel.setText(Game.getMsg());
//}
    @FXML
    public void openLoginPage(ActionEvent event) throws IOException {
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        PopupStage = new Stage();
        root = FXMLLoader.load(getClass().getResource("Login_Popup.fxml"));
        scene = new Scene(root, 900, 600);
        PopupStage.setTitle("Login Page");
        PopupStage.setScene(scene);
        PopupStage.initStyle(StageStyle.UNDECORATED);
        PopupStage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        PopupStage.showAndWait();

    }

    public void openSignupPage(ActionEvent event) throws IOException {
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        PopupStage = new Stage();
        root = FXMLLoader.load(getClass().getResource("Signup_Popup.fxml"));
        scene = new Scene(root, 900, 600);
        PopupStage.setTitle("sign up Page");
        PopupStage.setScene(scene);
        PopupStage.initStyle(StageStyle.UNDECORATED);
        PopupStage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        PopupStage.showAndWait();
    }


    @FXML
    public void cancelAction(ActionEvent event) throws IOException {
        PopupStage = (Stage) cancelButton.getScene().getWindow();
        PopupStage.close();
    }

    @FXML

    public void openDifficultyWindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Difficulty_Window.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML

    public void openGameBoardWindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Multiplayer_Board.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML

    public void openProfileWindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Profile_window.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    public void loggingIn(ActionEvent event) throws IOException, ParserConfigurationException, TransformerException {
        if (emailTextField.getText().isEmpty() == false && passField.getText().isEmpty() == false) {
            Player player = new Player(emailTextField.getText(), passField.getText());
            CurrentSession.setPlayer(player);
            warningLabel.setText("logging in");
            Document document = LoggingIn_XML.validate(player);
            if(CurrentSession.getGame() == null){
                game = new Game();
                CurrentSession.setGame(game);
            } else {
                game = CurrentSession.getGame();
            }
            game.connect("localhost");
            game.sendMsg(document);

//            while(game.getMsg()==null)
//            {
//                System.out.println(game.getMsg());
//                receivedLoginMsgFromServer =game.getMsg();
//            }
//
//            warningLabel.setText(receivedLoginMsgFromServer);
//            if(game.getMsg().equals("Logged-in successfully"))
//            {
//                PopupStage = (Stage) cancelButton.getScene().getWindow();
////                Button b= (Button) stage.getScene().lookup("#loginButton");
////                b.setDisable(true);
////                stage.getScene().lookup("signupButton").setDisable(true);
////                signupButton.setDisable(true);
//                PopupStage.close();
//
//
//            }
//            else
//            {
//                emailTextField.setDisable(true);
//                passField.setDisable(true);
//
//            }
//
//            passField.clear();
//            emailTextField.clear();
//            loginPageButton.setDisable(true);



        } else {
            warningLabel.setText("email or password is missing ");
        }
    }


    @FXML
    public void signingUp(ActionEvent event) throws IOException, ParserConfigurationException, TransformerException, ClassNotFoundException {
        if (emailTextField.getText().isEmpty() == false && passField.getText().isEmpty() == false && confirmPassField.getText().isEmpty() == false && usernameTextField.getText().isEmpty() == false) {
            if (passField.getText().equals(confirmPassField.getText())) {

                Player player = new Player(usernameTextField.getText(), emailTextField.getText(), passField.getText());
                CurrentSession.setPlayer(player);
                Document document = signingup_XML.validate(player);
                if(CurrentSession.getGame() == null){
                    game = new Game();
                    CurrentSession.setGame(game);
                } else {
                    game = CurrentSession.getGame();
                }
                game.connect("localhost");
                game.sendMsg(document);

//
//                while(game.getMsg()==null)
//                {
//                    System.out.println(game.getMsg()+"home page");
//                    receivedSignupMsgFromServer =game.getMsg();
//                }
//
//                warningLabel.setText(receivedSignupMsgFromServer);
//                if(game.getMsg().equals("Signed up successfully"))
//                {
//                    PopupStage = (Stage) cancelButton.getScene().getWindow();
//                    //stage.getScene().lookup("loginButton").setDisable(true);
//                    PopupStage.close();
//                   // signupButton.setDisable(true);
//                }
//                else {
//                    emailTextField.setDisable(true);
//                    usernameTextField.setDisable(true);
//                    passField.setDisable(true);
//                    confirmPassField.setDisable(true);
//                }
//
//
//
//                usernameTextField.clear();
//                passField.clear();
//                emailTextField.clear();
//                confirmPassField.clear();
//                signupPageButton.setDisable(true);
//
//
////                stage = (Stage) onlineMultiplayerButton.getScene().getWindow();
////                signupButton.setDisable(true);

            }
            else
            {
                warningLabel.setText("Passwords are not matching");
            }
        }
        else
        {
            warningLabel.setText("Please Enter your full data!");
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //onlineMultiplayerButton.setDisable(true);

    }

//    @Override
//    public void setMessage(String msg) {
//
//    }
}

