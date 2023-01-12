package tictactoeclient;

import javafx.stage.Stage;

public class CurrentSession {
    private static CurrentSession currentSession;
    private static Player player;
    private static int[] recordedGame;
    private static Stage currentStage;


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
        return player;
    }

    public static void setPlayer(Player player) {
        CurrentSession.player = player;
    }

    public static int[] getRecordedGame() {
        return recordedGame;
    }

    public static void setRecordedGame(int[] recordedGame) {
        CurrentSession.recordedGame = recordedGame;
    }

    public static Stage getCurrentStage() {
        return currentStage;
    }

    public static void setCurrentStage(Stage currentStage) {
        CurrentSession.currentStage = currentStage;
    }
}