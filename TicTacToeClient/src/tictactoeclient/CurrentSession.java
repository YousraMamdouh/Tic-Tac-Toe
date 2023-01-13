package tictactoeclient;

import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CurrentSession {
    private static CurrentSession currentSession;
    private Player player;
    private int[] recordedGame;
    private Stage currentStage;
    private Game game;
    private List<GameHistory> gameHistoryList;
    private List<Player> playerList;

    private CurrentSession() {
    }

    static {
        try {
            currentSession = new CurrentSession();
        } catch (Exception e) {
            throw new RuntimeException("Couldn't Create Instance of \"CurrentSession\"");
        }
    }

    public static synchronized CurrentSession getInstance() {
        if (currentSession == null) {
            currentSession = new CurrentSession();
        }
        return currentSession;
    }

    public static Player getPlayer() {
        return currentSession.player;
    }

    public static void setPlayer(Player player) {
        currentSession.player = player;
    }

    public static int[] getRecordedGame() {
        return currentSession.recordedGame;
    }

    public static void setRecordedGame(int[] recordedGame) {
        currentSession.recordedGame = recordedGame;
    }

    public static Stage getCurrentStage() {
        return currentSession.currentStage;
    }

    public static void setCurrentStage(Stage currentStage) {
        currentSession.currentStage = currentStage;
    }

    public static Game getGame() {
        return currentSession.game;
    }

    public static void setGame(Game game) {
        currentSession.game = game;
    }


    public static List<Player> getPlayersList() {
        return currentSession.playerList;
    }

    public static void setPlayersList(List<Player> list) {
        currentSession.playerList = list;
    }
    public static List<GameHistory> getGameHistoryList() {
        return currentSession.gameHistoryList;
    }

    public static void setGameHistoryList(List<GameHistory> list) {
        currentSession.gameHistoryList = list;
    }

}