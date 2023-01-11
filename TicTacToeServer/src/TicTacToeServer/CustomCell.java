package TicTacToeServer;

import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class CustomCell extends ListCell<PlayerCell> {
    @Override
    protected void updateItem(PlayerCell player, boolean empty) {
        super.updateItem(player, empty);
        if (empty) {
            setGraphic(null);
        } else {
            HBox hBox = new HBox(50);
            hBox.alignmentProperty().set(Pos.BASELINE_LEFT);
            hBox.setAlignment(Pos.BASELINE_LEFT);
            hBox.getChildren().addAll(
                    player.getPlayerStatus(),
                    player.getPlayerName(),
                    player.getPlayerScore());
            setGraphic(hBox);
        }
    }

}
