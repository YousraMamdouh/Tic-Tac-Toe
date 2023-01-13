package tictactoeclient;

import javafx.stage.Stage;

import java.net.Socket;

public class CurrentSession {
    private static CurrentSession currentSession;
    private static Player player;
    private static int[] recordedGame;
    private static Stage currentStage;
    private static Socket socket;


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

    public static CurrentSession getCurrentSession() {
        return currentSession;
    }

    public static void setCurrentSession(CurrentSession currentSession) {
        CurrentSession.currentSession = currentSession;
    }

    public static Socket getSocket() {
        return socket;
    }

    public static void setSocket(Socket socket) {
        CurrentSession.socket = socket;
    }
}