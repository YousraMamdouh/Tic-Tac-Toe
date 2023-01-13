package tictactoeclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * @author ramy3
 */
public class MediumLevelController implements Initializable {


    private static Stage stage;
    private Stage popUpStage;

    private Parent root;
    MediumLevelController controller;
    private Scene scene;
    @FXML
    Button resetGameButton;
    @FXML

    public  MediaView media;


    private static final String MEDIA_URL="Loser.mp4";
    private MediaPlayer mediaPlayer=new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL).toExternalForm()));
    @FXML
    Label winnerLabel;

    @FXML
    private Button noButton;
    @FXML
    private Button yesButton;
    @FXML
    private Button cell_zero, cell_1, cell_2, cell_3, cell_4, cell_5, cell_6, cell_7, cell_8;
    @FXML
    private ImageView img_zero, img_1, img_2, img_3, img_4, img_5, img_6, img_7, img_8;
    @FXML
    private Label player1Label;
    @FXML
  Image img_X = new Image("/res/X.png");
  Image img_O = new Image("/res/O.png");
  ImageView randomView = new ImageView();
  int turn = 0;
  int gameOver = 0;
    @FXML
    private void setBackArrowMethod(ActionEvent e) throws IOException {
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MediumLevelExit.fxml")));
        popUpStage = new Stage();
        Scene exit = new Scene(root);
        exit.setFill(Color.TRANSPARENT);
        popUpStage.setScene(exit);
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.initStyle(StageStyle.TRANSPARENT);
        popUpStage.showAndWait();
    }
    @FXML
    private void setYesButton() throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.FXML")));
        scene = new Scene(root);
        stage.setScene(scene);
        popUpStage = (Stage) yesButton.getScene().getWindow();
        stage.show();
        popUpStage.close();
    }

    @FXML
    private void returnToHomePage(ActionEvent e) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.FXML")));
        scene = new Scene(root);
        stage.setScene(scene);
        popUpStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.show();
        popUpStage.close();
    }

    @FXML
    private void setNoButton() {

        popUpStage = (Stage) noButton.getScene().getWindow();
        popUpStage.close();
    }

    @FXML
    private void drawOnCell_zero() {
        img_zero.setImage(img_X);
        cell_zero.setText("X");
        cell_zero.setDisable(true);
        play();
    }

    @FXML
    private void drawOnCell_1() {
        img_1.setImage(img_X);
        cell_1.setText("X");
        cell_1.setDisable(true);
        play();
    }

    @FXML
    private void drawOnCell_2()
    {
        img_2.setImage(img_X);
        cell_2.setText("X");
        cell_2.setDisable(true);
        play();
    }

    @FXML
    private void drawOnCell_3()
    {
        img_3.setImage(img_X);
        cell_3.setText("X");
        cell_3.setDisable(true);
        play();
    }

    @FXML
    private void drawOnCell_4()
    {
        img_4.setImage(img_X);
        cell_4.setText("X");
        cell_4.setDisable(true);
        play();
    }

    @FXML
    private void drawOnCell_5()
    {img_5.setImage(img_X);
        cell_5.setText("X");
        cell_5.setDisable(true);
        play();
    }

    @FXML
    private void drawOnCell_6() {
        img_6.setImage(img_X);
        cell_6.setText("X");
        cell_6.setDisable(true);
        play();
    }

    @FXML
    private void drawOnCell_7()
    {
        img_7.setImage(img_X);
        cell_7.setText("X");
        cell_7.setDisable(true);
        play();
    }

    @FXML
    private void drawOnCell_8()
    {
        img_8.setImage(img_X);
        cell_8.setText("X");
        cell_8.setDisable(true);
        play();
    }

    private void isWinner() {

        for (int i = 0; i < 8; i++) {
            String line;
            switch (i) {
                case 0:
                    line = cell_zero.getText() + cell_1.getText() + cell_2.getText();
                    break;
                case 1:
                    line = cell_3.getText() + cell_4.getText() + cell_5.getText();
                    break;
                case 2:
                    line = cell_6.getText() + cell_7.getText() + cell_8.getText();
                    break;
                case 3:
                    line = cell_zero.getText() + cell_4.getText() + cell_8.getText();
                    break;
                case 4:
                    line = cell_2.getText() + cell_4.getText() + cell_6.getText();
                    break;
                case 5:
                    line = cell_zero.getText() + cell_3.getText() + cell_6.getText();
                    break;
                case 6:
                    line = cell_1.getText() + cell_4.getText() + cell_7.getText();
                    break;
                case 7:
                    line = cell_2.getText() + cell_5.getText() + cell_8.getText();
                    break;
                default:
                    line = null;
            }

            if (line.equals("XXX")) {
                gameOver = 1;
                System.out.println("You won!");
                try {
                    showResultPopup("You Won!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            } else if (line.equals("OOO")) {
                gameOver = 1;
                System.out.println("Cpu won");
                try {
                    showResultPopup("Loser!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }

        if (gameOver == 0 && turn == 9) {
            System.out.println("tie");
            try {
                showResultPopup("It's a tie!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public ImageView generateRandomView() {
        Random rand = new Random();
        int cpuPosition = rand.nextInt(9) + 1;
        switch (cpuPosition) {
            case 1:
                return img_zero;
            case 2:
                return img_1;
            case 3:
                return img_2;
            case 4:
                return img_3;
            case 5:
                return img_4;
            case 6:
                return img_5;
            case 7:
                return img_6;
            case 8:
                return img_7;
            case 9:
                return img_8;
        }
        return null;
    }

    public void draw_O() {
        randomView = generateRandomView();
        do {
            randomView = generateRandomView();
        } while (randomView.getImage() != null);

        if (randomView == img_zero) {
            cell_zero.setDisable(true);
            cell_zero.setText("O");
            img_zero.setImage(img_O);
        } else if (randomView == img_1) {
            cell_1.setDisable(true);
            cell_1.setText("O");
            img_1.setImage(img_O);
        } else if (randomView == img_2) {
            cell_2.setDisable(true);
            cell_2.setText("O");
            img_2.setImage(img_O);
        } else if (randomView == img_3) {
            cell_3.setDisable(true);
            cell_3.setText("O");
            img_3.setImage(img_O);
        } else if (randomView == img_4) {
            cell_4.setDisable(true);
            cell_4.setText("O");
            img_4.setImage(img_O);
        } else if (randomView == img_5) {
            cell_5.setDisable(true);
            cell_5.setText("O");
            img_5.setImage(img_O);
        } else if (randomView == img_6) {
            cell_6.setDisable(true);
            cell_6.setText("O");
            img_6.setImage(img_O);
        } else if (randomView == img_7) {
            cell_7.setDisable(true);
            cell_7.setText("O");
            img_7.setImage(img_O);
        } else if (randomView == img_8) {
            cell_8.setDisable(true);
            cell_8.setText("O");
            img_8.setImage(img_O);
        }
    }

//    private void showResultPopup() {
//        stage = (Stage) player1Label.getScene().getWindow();
//            try {
//             root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MediumLevelResult.fxml")));
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            popUpStage = new Stage();
//            Scene exit = new Scene(root);
//            exit.setFill(Color.TRANSPARENT);
//            popUpStage.setScene(exit);
//            popUpStage.initStyle(StageStyle.UNDECORATED);
//            popUpStage.initStyle(StageStyle.TRANSPARENT);
//            exit.setFill(Color.TRANSPARENT);
//            popUpStage.showAndWait();
//
//
//        }
    private void createPopup(Parent root) {
        Scene popup = new Scene(root);
        popup.setFill(Color.TRANSPARENT);
        popUpStage = new Stage();
        popUpStage.setScene(popup);
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.initStyle(StageStyle.TRANSPARENT);
        popUpStage.showAndWait();

    }

    private void showResultPopup(String winner) throws IOException {

        stage = (Stage) player1Label.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MediumLevelResult.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        controller.winnerLabel.setText(winner);
        controller.mediaPlayer.setAutoPlay(true);
        controller.media.setMediaPlayer(mediaPlayer);
        System.out.println("every thing is okay");
        createPopup(root);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      //  media = new MediaPlayer(mediaPlayer);

    }

    private boolean isCloseToWin() {

        if ((cell_zero.getText() + cell_1.getText()).equals("XX") && cell_2.getText().equals("2")) {
            cell_2.setDisable(true);
            cell_2.setText("O");
            img_2.setImage(img_O);
            return true;

        } else if ((cell_2.getText() + cell_1.getText()).equals("XX") && cell_3.getText().equals("3")) {
            cell_3.setDisable(true);
            cell_3.setText("O");
            img_3.setImage(img_O);


            return true;
        } else if ((cell_2.getText() + cell_zero.getText()).equals("XX") && cell_1.getText().equals("1")) {
            cell_1.setDisable(true);
            cell_1.setText("O");
            img_1.setImage(img_O);

            return true;
        } else if ((cell_3.getText() + cell_4.getText()).equals("XX") && cell_5.getText().equals("5")) {
            cell_5.setDisable(true);
            cell_5.setText("O");
            img_5.setImage(img_O);

            return true;
        } else if ((cell_4.getText() + cell_5.getText()).equals("XX") && cell_3.getText().equals("3")) {
            cell_3.setDisable(true);
            cell_3.setText("O");
            img_3.setImage(img_O);

            return true;
        } else if ((cell_3.getText() + cell_5.getText()).equals("XX") && cell_4.getText().equals("4")) {
            cell_4.setDisable(true);
            cell_4.setText("O");
            img_4.setImage(img_O);

            return true;
        } else if ((cell_6.getText() + cell_7.getText()).equals("XX") && cell_8.getText().equals("8")) {
            cell_8.setDisable(true);
            cell_8.setText("O");
            img_8.setImage(img_O);

            return true;
        } else if ((cell_7.getText() + cell_8.getText()).equals("XX") && cell_6.getText().equals("6")) {
            cell_6.setDisable(true);
            cell_6.setText("O");
            img_6.setImage(img_O);

            return true;
        } else if ((cell_6.getText() + cell_8.getText()).equals("XX") && cell_7.getText().equals("7")) {
            cell_7.setDisable(true);
            cell_7.setText("O");
            img_7.setImage(img_O);

            return true;
        } else if ((cell_6.getText() + cell_zero.getText()).equals("XX") && cell_3.getText().equals("3")) {
            cell_3.setDisable(true);
            cell_3.setText("O");
            img_3.setImage(img_O);

            return true;
        } else if ((cell_zero.getText() + cell_3.getText()).equals("XX") && cell_6.getText().equals("6")) {
            cell_6.setDisable(true);
            cell_6.setText("O");
            img_6.setImage(img_O);

            return true;
        } else if ((cell_6.getText() + cell_3.getText()).equals("XX") && cell_zero.getText().equals("zero")) {
            cell_zero.setDisable(true);
            cell_zero.setText("O");
            img_zero.setImage(img_O);

            return true;
        } else if ((cell_1.getText() + cell_4.getText()).equals("XX") && cell_7.getText().equals("7")) {
            cell_7.setDisable(true);
            cell_7.setText("O");
            img_7.setImage(img_O);

            return true;
        } else if ((cell_1.getText() + cell_7.getText()).equals("XX") && cell_4.getText().equals("4")) {
            cell_4.setDisable(true);
            cell_4.setText("O");
            img_4.setImage(img_O);

            return true;
        } else if ((cell_4.getText() + cell_7.getText()).equals("XX") && cell_1.getText().equals("1")) {
            cell_1.setDisable(true);
            cell_1.setText("O");
            img_1.setImage(img_O);

            return true;
        } else if ((cell_2.getText() + cell_5.getText()).equals("XX") && cell_8.getText().equals("8")) {
            cell_8.setDisable(true);
            cell_8.setText("O");
            img_8.setImage(img_O);

            return true;
        } else if ((cell_8.getText() + cell_5.getText()).equals("XX") && cell_2.getText().equals("2")) {
            cell_2.setDisable(true);
            cell_2.setText("O");
            img_2.setImage(img_O);

            return true;
        } else if ((cell_2.getText() + cell_8.getText()).equals("XX") && cell_5.getText().equals("5")) {
            cell_5.setDisable(true);
            cell_5.setText("O");
            img_5.setImage(img_O);

            return true;
        } else if ((cell_zero.getText() + cell_4.getText()).equals("XX") && cell_8.getText().equals("8")) {
            cell_8.setDisable(true);
            cell_8.setText("O");
            img_8.setImage(img_O);

            return true;
        } else if ((cell_8.getText() + cell_zero.getText()).equals("XX") && cell_4.getText().equals("4")) {
            cell_4.setDisable(true);
            cell_4.setText("O");
            img_4.setImage(img_O);

            return true;
        } else if ((cell_4.getText() + cell_8.getText()).equals("XX") && cell_zero.getText().equals("zero")) {
            cell_zero.setDisable(true);
            cell_zero.setText("O");
            img_zero.setImage(img_O);

            return true;
        } else if ((cell_2.getText() + cell_4.getText()).equals("XX") && cell_6.getText().equals("6")) {
            cell_6.setDisable(true);
            cell_6.setText("O");
            img_6.setImage(img_O);
            return true;
        } else if ((cell_6.getText() + cell_4.getText()).equals("XX") && cell_2.getText().equals("2")) {
            cell_2.setDisable(true);
            cell_2.setText("O");
            img_2.setImage(img_O);

            return true;
        } else if ((cell_2.getText() + cell_6.getText()).equals("XX") && cell_4.getText().equals("4")) {
            cell_4.setDisable(true);
            cell_4.setText("O");
            img_4.setImage(img_O);

            return true;
        }


        return false;
    }

   private void play() {
        turn++;
        isWinner();
        if (turn < 8 && gameOver == 0) {
            if (!isCloseToWin() ) {
                draw_O();
            }
            turn++;
            isWinner();

        }
    }


}