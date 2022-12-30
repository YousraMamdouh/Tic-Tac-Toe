package tictactoeclient;

import javafx.fxml.FXML;

public class DifficultyWindowController {
    private int difficultyLevel;

    @FXML
    private void easy() {

        System.out.println("I hEaRd SoMeOnE ClIcK tHe EaSy BuTtOn !");
        difficultyLevel = 1;
        System.out.println("Difficulty Level Has Been Set To "+ difficultyLevel);
    }

    @FXML
    private void medium() {
        System.out.println("I hEaRd SoMeOnE ClIcK tHe MeDiUm BuTtOn !");
        difficultyLevel = 2;
        System.out.println("Difficulty Level Has Been Set To "+ difficultyLevel);
    }

    @FXML
    private void hard() {
        System.out.println("I hEaRd SoMeOnE ClIcK tHe HaRd BuTtOn !");
        difficultyLevel = 3;
        System.out.println("Difficulty Level Has Been Set To "+ difficultyLevel);
    }


    @FXML
    private void back(){
        //TODO: 12/30/2022 Link this function with the previous window
        System.out.println("return back!");
    }



}
