package tictactoeclient;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameHistory {
    private int game_id;
    private int playerOne;
    private int playerTwo;
    private int[] order;
    private int winnerName;
    private String date;
    private SimpleDateFormat dateFormat;

    public GameHistory(int game_id, int playerOne, int playerTwo, int[] order, int winnerName, Timestamp date) {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.game_id = game_id;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.order = order;
        this.winnerName = winnerName;
        this.date = dateFormat.format(date);
    }
    public GameHistory(int playerOne, int playerTwo, int[] order, int winnerName){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.order = order;
        this.winnerName = winnerName;
    }


    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(int playerOne) {
        this.playerOne = playerOne;
    }

    public int getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(int playerTwo) {
        this.playerTwo = playerTwo;
    }

    public int[] getOrder() {
        return order;
    }

    public void setOrder(int[] order) {
        this.order = order;
    }

    public int getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(int winnerName) {
        this.winnerName = winnerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = dateFormat.format(date);
    }
}
