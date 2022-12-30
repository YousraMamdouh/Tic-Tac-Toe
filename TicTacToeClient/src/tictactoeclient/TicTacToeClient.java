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
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class TicTacToeClient extends Application {

    @Override
    public void start(Stage stage) throws Exception{

            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene homePage = new Scene(root, 1135, 725);
            stage.setTitle("Tic Tac Toe");
            stage.setScene(homePage);
            stage.show();

    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
