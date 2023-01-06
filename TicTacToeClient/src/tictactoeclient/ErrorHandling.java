package tictactoeclient;

import javafx.application.Platform;
import javafx.scene.control.Alert;

public class ErrorHandling {
    public static void showDialog(Alert.AlertType type, String title, String content, Boolean exit){
        Platform.runLater(()->{
            Alert alert = new Alert(type);
            alert.setTitle(title);
            alert.setHeaderText(title);
            alert.setResizable(true);
            alert.setContentText(content);
            alert.showAndWait();
            if(exit) Platform.exit();
        });
    }
}
