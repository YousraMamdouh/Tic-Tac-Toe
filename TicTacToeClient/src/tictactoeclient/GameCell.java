package tictactoeclient;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;


public class GameCell {
    private final Label playerOne;
    private final Label playerTwo;
    private final Label winner;
    private final Label timeStamp;
    public GameCell(String playerOne, String playerTwo, String Winner,String timeStamp) {
        this.playerOne = new Label(playerOne);
        this.playerTwo = new Label(playerTwo);
        this.playerOne.setMinWidth(120);
        this.playerTwo.setMinWidth(120);
        this.winner = new Label(Winner);
        this.winner.setMinWidth(120);
        this.timeStamp = new Label(timeStamp);
        this.timeStamp.setMinWidth(120);
    }

    public Label getPlayerOne() {
        return playerOne;
    }

    public Label getPlayerTwo() {
        return playerTwo;
    }

    public Label getWinner() {
        return winner;
    }

    public Label getTimeStamp() {
        return timeStamp;
    }

    //needs to get the players list from a reference
    public static List<GameCell> getReadyList() {
        List<GameCell> statsList = new ArrayList<>();
        statsList.add(new GameCell("Player One", "Player Two", "Winner", "Time Stamp"));
        for (GameHistory g : CurrentSession.getGameHistoryList()) {
            statsList.add(new GameCell(g.getPlayerOne(),g.getPlayerTwo(), g.getWinnerName(), g.getDate()));
        }
        return statsList;
    }
}
