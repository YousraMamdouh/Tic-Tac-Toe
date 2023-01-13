/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToeServer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.Objects;

public class TicTacToeServer extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main_Window.fxml")));
        Scene scene = new Scene(root);
        //  GameServer.connect(5005);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("TicTacToe Server");
        stage.getIcons().add(new Image("res/X.png"));
        stage.show();

    }

    public static void main(String[] args) {
        /*Testing database operations insert and select statements using DTOs*/

        launch(args);
    }

}
