package tictactoeclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class DifficultyWindowController implements Initializable {
    public DifficultyWindowController() {
        difficulties = new ArrayList<>();
    }

    private Stage stage;
    private final List<Parent> difficulties;

    @FXML
    private void levelSwitch(ActionEvent e){
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        int window = Integer.parseInt(((Button) e.getSource()).getText());
        switchScenes(difficulties.get(window));
    }

    private void switchScenes(Parent root) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void containRoots() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.FXML")));
        difficulties.add(root);
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EasyAiGameBoard.FXML")));
        difficulties.add(root);
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MediumLevelGameBoard.FXML")));
        difficulties.add(root);
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameBoardHard.FXML")));
        difficulties.add(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            containRoots();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
