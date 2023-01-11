package TicTacToeServer;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameHistory {
    private int game_id;
    private String playerOne;
    private String playerTwo;
    private int[] order;
    private String winnerName;
    private String date;
    private SimpleDateFormat dateFormat;

    public GameHistory(int game_id, String playerOne, String playerTwo, int[] order, String winnerName, Timestamp date) {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.game_id = game_id;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.order = order;
        this.winnerName = winnerName;
        this.date = dateFormat.format(date);
    }
    public GameHistory(String playerOne, String playerTwo, int[] order, String winnerName){
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

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public int[] getOrder() {
        return order;
    }

    public void setOrder(int[] order) {
        this.order = order;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = dateFormat.format(date);
    }
}
