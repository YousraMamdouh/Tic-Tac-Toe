/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class TicTacToeClient extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Difficulty_Window.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("TicTacToe");
        stage.getIcons().add(new Image("res/O.png"));
        stage.show();

    public void start(Stage stage) throws Exception{

            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene homePage = new Scene(root, 1135, 725);
            stage.setTitle("Tic Tac Toe");
            stage.setScene(homePage);
            stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
