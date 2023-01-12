package TicTacToeServer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class CustomCellListener implements ChangeListener<PlayerCell> {
    @Override
    public void changed(ObservableValue<? extends PlayerCell> observable, PlayerCell oldValue, PlayerCell newValue) {
        if (newValue != null)
            System.out.println("Clicked On : " + newValue.getPlayerName().getText());
    }

}