package tictactoeclient;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

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

    public static void acceptDialog(Alert.AlertType type, String title, String content){

        Platform.runLater(()->{

            Alert alert = new Alert(type);
            alert.setTitle(title);
            alert.setContentText(content);
            Optional<ButtonType> result = alert.showAndWait();


        });

    }




}
