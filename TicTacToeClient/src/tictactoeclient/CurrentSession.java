package tictactoeclient;

import javafx.stage.Stage;

import java.util.List;

public class CurrentSession {
    private static CurrentSession currentSession;
    private Player player;
    private Player currentOpponent;
    private int[] recordedGame;
    private Stage currentStage;
    private Game game;
    private List<GameHistory> gameHistoryList;
    private List<Player> playerList;
    private int inComingMove;
    private boolean isPlayerOne;

    private CurrentSession() {
        isPlayerOne=  false;
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

    public static Player getCurrentOpponent() {
        return currentSession.currentOpponent;
    }

    public static void setCurrentOpponent(Player player) {
        currentSession.currentOpponent = player;
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
    public static boolean isAvailable(){
        return currentSession.player.getStatus()==1;
    }


    public static int getOpponentMove() {
        return currentSession.inComingMove;
    }

    public static void setOpponentMove(int cell) {
        currentSession.inComingMove = cell;
    }

    public static boolean getIsPlayerOne() {
        return currentSession.isPlayerOne;
    }

    public static void setPlayerOne() {
        currentSession.isPlayerOne = true;
    }

}