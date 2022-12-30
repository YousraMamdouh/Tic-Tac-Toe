package tictactoeclient;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class DifficultyWindowController {

    @FXML
    private Text levelText;
    @FXML
    private void easy() {

        System.out.println("I hEaRd SoMeOnE ClIcK tHe EaSy BuTtOn !");
        levelText.setText("Easy");

    }

    @FXML
    private void medium() {
        System.out.println("I hEaRd SoMeOnE ClIcK tHe MeDiUm BuTtOn !");
        levelText.setText("Medium");
    }

    @FXML
    private void hard() {
        System.out.println("I hEaRd SoMeOnE ClIcK tHe HaRd BuTtOn !");
        levelText.setText("Hard");
    }

    @FXML
    private void play() {
        System.out.println("NoW We'Re PlAyInG !");
    }
    @FXML
    private void back(){
        //TODO: 12/30/2022 Link this function with the previous window
        System.out.println("return back!");
    }



}
