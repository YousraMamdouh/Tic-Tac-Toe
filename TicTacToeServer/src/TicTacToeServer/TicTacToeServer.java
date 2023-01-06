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


import java.util.Objects;

public class TicTacToeServer extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main_Window.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("TicTacToe Server");
        stage.getIcons().add(new Image("res/X.png"));
        stage.show();

    }

    public static void main(String[] args) {
        /*Testing database operations insert and select statements using DTOs*/
//        try {
//            DatabaseConnection.registerPlayer(new Player("TestSubject1", "TestSubject1@Domain.com", "TestSubject1'sPassword"));
//            DatabaseConnection.registerPlayer(new Player("TestSubject2", "TestSubject2@Domain.com", "TestSubject2'sPassword"));
//        } catch (SQLException e) {
//            System.out.println("User Name Already In Database");
//        }
//        try {
//            DatabaseConnection.insertGame(new GameHistory(22, 23, new int[]{8, 7, 6, 5, 4, 3, 2, 1, 0}, 22));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//                List<Player> players = DatabaseConnection.getPlayerList();
//        for (Player player : players) {
//            System.out.println(player.getPlayer_id() + " - " + player.getName() + " " +
//                    player.getScore() + " " + player.getEmail() + ":" + player.getPassword());
//        }
//        List<GameHistory> gameHistoryList = DatabaseConnection.getGameHistoryList();
//        for (GameHistory game : gameHistoryList) {
//            System.out.println(game.getPlayerOne() + " vs " + game.getPlayerTwo() + " " + game.getGame_id() + " winner ->> " +
//                    game.getWinnerName() + " Time : " + game.getDate());
//        }

        launch(args);
    }

}
