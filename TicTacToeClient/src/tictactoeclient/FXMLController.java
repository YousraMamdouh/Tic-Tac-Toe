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
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.stage.StageStyle;

/**
 *
 * @author ramy3
 */

public class FXMLController {
    @FXML
    Button loginButton;
    @FXML
    Button signupButton;
    @FXML
    Button loginPageButton;
    @FXML
    Button signupPageButton;

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void openLoginPage(ActionEvent event) throws IOException {

        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        scene = new Scene(root, 900, 600);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.showAndWait();

    }

    public void openSignupPage(ActionEvent event) throws IOException {
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("SignupPage.fxml"));
        scene = new Scene(root, 900, 600);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    public void loggingIn(ActionEvent event) throws IOException {

        stage = (Stage) loginPageButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void signingUp(ActionEvent event) throws IOException {

        stage = (Stage) signupPageButton.getScene().getWindow();
        stage.close();
    }

    @FXML

    public void singlePlayer(ActionEvent event) throws IOException {
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("Difficulty_Window.fxml"));
        scene = new Scene(root);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();


    }

    @FXML

    public void singlePlayer3(ActionEvent event) throws IOException {
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("GameBoard.fxml"));
        scene = new Scene(root);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();


    }
    @FXML

    public void singlePlayer4(ActionEvent event) throws IOException {
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("Profile_window.fxml"));
        scene = new Scene(root);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();


    }
}