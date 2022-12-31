/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;


public class TicTacToeClient extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.fxml")));
        Scene homePage = new Scene(root);
        stage.setScene(homePage);
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe");
        stage.getIcons().add(new Image("res/O.png"));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
