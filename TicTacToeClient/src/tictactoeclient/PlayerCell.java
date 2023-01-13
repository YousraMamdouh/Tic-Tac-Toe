package tictactoeclient;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;


public class PlayerCell {
    private final ImageView playerStatus;
    private final Label playerName;
    private final Label playerScore;
    public PlayerCell(int status, String userName, String score) {
        String path = "res/" + status + ".png";
        playerStatus = new ImageView(new Image(path));
        playerStatus.setFitHeight(30d);
        playerStatus.setFitWidth(120d);
        playerName = new Label(userName);
        playerName.setMinWidth(300d);
        playerScore = new Label(score);
    }

    public ImageView getPlayerStatus() {
        return playerStatus;
    }

    public Label getPlayerName() {
        return playerName;
    }

    public Label getPlayerScore() {
        return playerScore;
    }
//needs to get the players list from a reference
  public static List<PlayerCell> getReadyList() {
        List<PlayerCell> statsList = new ArrayList<>();
//        statsList.add(new PlayerCell(2, "User Name", "Score"));
//        for (Player p : DatabaseConnection.getPlayerList()) {
//            statsList.add(new PlayerCell(p.getStatus(), p.getName(), String.valueOf(p.getScore())));
//        }
      statsList.add(new PlayerCell(0, "sara rady","20"));
      statsList.add(new PlayerCell(1, "ramy","10"));
      statsList.add(new PlayerCell(-1, "youssra","5"));

return statsList;
   }
}
