package tictactoeclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class DifficultyWindowController {

    private int difficultyLevel;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private void easy(ActionEvent e) throws IOException {
        difficultyLevel = 1;
        System.out.println("Difficulty Level Has Been Set To " + difficultyLevel);
        toEasyAiBoard(e);
    }

    @FXML
    private void medium(ActionEvent e) throws IOException {
        difficultyLevel = 2;
        System.out.println("Difficulty Level Has Been Set To " + difficultyLevel);
        toMediumAiBoard(e);
    }

    @FXML
    private void hard(ActionEvent e) throws IOException {
        difficultyLevel = 3;
        System.out.println("Difficulty Level Has Been Set To " + difficultyLevel);
        toGameBoard(e);
    }


    @FXML
    private void prevView(ActionEvent e) throws IOException {
        System.out.println("return back!");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.FXML")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    private void toGameBoard(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameBoardHard.FXML")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void toEasyAiBoard(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EasyAiGameBoard.FXML")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
private void toMediumAiBoard(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MediumLevelGameBoard.FXML")));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
