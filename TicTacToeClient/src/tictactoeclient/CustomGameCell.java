package tictactoeclient;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class CustomGameCell extends ListCell<GameCell> {
    @Override
    protected void updateItem(GameCell game, boolean empty) {
        super.updateItem(game, empty);
        if (empty) {
            setGraphic(null);
        } else {
            HBox hBox = new HBox(50);
            hBox.alignmentProperty().set(Pos.BASELINE_LEFT);
            hBox.setAlignment(Pos.BASELINE_LEFT);
            hBox.getChildren().addAll(
                    game.getPlayerOne(),
                    game.getPlayerTwo(),
                    game.getWinner(),
                    game.getTimeStamp());
            setGraphic(hBox);
        }
    }

}