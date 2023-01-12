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
        GameServer.connect(5005);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("TicTacToe Server");
        stage.getIcons().add(new Image("res/X.png"));
        stage.show();

    }

    public static void main(String[] args) {
        /*Testing database operations insert and select statements using DTOs*/
//        try {
//            DatabaseConnection.registerPlayer(new Player("TestSubject17", "Email", "990"));
////            DatabaseConnection.registerPlayer(new Player("TestSubject2", "TestSubject2@Domain.com", "TestSubject2'sPassword"));
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
        //3os testing
//Player p1 = new Player("Mohamed",0,1,200,"myEmail");
        //Player p2 = new Player("Khaled",0,1,100,"hello");
//        Player p1 = new Player("noob",0,1,200,"noob@DB.com");
//        Player p2 = new Player("Pro",0,1,200,"pro@EA.com");
//        Player p3 = new Player("Ramy",0,1,200,"Ramy@er.com");

//        try {DatabaseConnection.updateScore(50,"noob");
//            DatabaseConnection.updateScore(99999,"Pro");
//            DatabaseConnection.updateScore(250,"Ramy");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DatabaseConnection.setStatus(0,"Mohamed");
//            DatabaseConnection.setStatus(0,"Ramy");
//            DatabaseConnection.setStatus(1,"Pro");
//            DatabaseConnection.setStatus(-1,"Khaled");
//            DatabaseConnection.setStatus(-1,"noob");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }



        launch(args);
    }

}
