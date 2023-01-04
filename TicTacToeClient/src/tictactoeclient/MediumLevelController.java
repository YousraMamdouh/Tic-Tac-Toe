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
    private Scene scene;

    @FXML
    private Button noButton;
    @FXML
    private Button yesButton;
    @FXML
    Button cell_zero,cell_1,cell_2,cell_3,cell_4,cell_5,cell_6,cell_7,cell_8;
    @FXML
    ImageView img_zero,img_1,img_2,img_3,img_4,img_5,img_6,img_7,img_8;
    int turn=0;
    int gameOver=0;
@FXML
        private Label player1Label;
    Image img_X=new Image("/res/X.png");
    Image img_O=new Image("/res/O.png");
    ImageView randomView=new ImageView();
    @FXML
    Label yourTurn_x,yourTurn_y,winnerLabel;

    @FXML
    Button resetGameButton;

    @FXML
    public void setBackArrowMethod(ActionEvent e) throws IOException {
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
    public void returnToHomePage(ActionEvent e) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.FXML")));
        scene = new Scene(root);
        stage.setScene(scene);
        popUpStage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.show();
        popUpStage.close();
    }
    @FXML
    private void setNoButton() {

        popUpStage = (Stage) noButton.getScene().getWindow();
        popUpStage.close();
    }

    @FXML
    public void drawOnCell_zero()
    {

        yourTurn_y.setText("Your Turn");
        yourTurn_x.setText("");
        img_zero.setImage(img_X);
        cell_zero.setText("X");
        cell_zero.setDisable(true);
        turn++;
        isWinner();
        //showResultPopup();

        if(turn<8&&gameOver==0) {
            yourTurn_y.setText("your turn");
            yourTurn_x.setText("");
            draw_O();
            turn++;
            isWinner();
          //  showResultPopup();
        }

    }@FXML
    public void drawOnCell_1()
    {
        yourTurn_x.setText("your turn");
        yourTurn_y.setText("");
        img_1.setImage(img_X);
        cell_1.setText("X");
        cell_1.setDisable(true);
        turn++;

        isWinner();

       // showResultPopup();

        if(turn<8&&gameOver==0) {
            yourTurn_y.setText("your turn");
            yourTurn_x.setText("");
            draw_O();
            isWinner();

            isWinner();

            //showResultPopup();

        }

    }@FXML
    public void drawOnCell_2()
    {
        yourTurn_x.setText("your turn");
        yourTurn_y.setText("");
        img_2.setImage(img_X);
        cell_2.setText("X");
        cell_2.setDisable(true);
        turn++;
        isWinner();
     //   showResultPopup();
        if(turn<8&&gameOver==0) {
            yourTurn_y.setText("your turn");
            yourTurn_x.setText("");
            draw_O();
            turn++;

            isWinner();

         //   showResultPopup();
        }
    }@FXML
    public void drawOnCell_3()
    {

        yourTurn_x.setText("your turn");
        yourTurn_y.setText("");
        img_3.setImage(img_X);
        cell_3.setText("X");
        cell_3.setDisable(true);
        turn++;

        isWinner();

       // showResultPopup();


        if(turn<8&&gameOver==0){
            yourTurn_y.setText("your turn");
            yourTurn_x.setText("");
            draw_O();
            turn++;

            isWinner();

            //showResultPopup();

        }


    }@FXML
    public void drawOnCell_4()
    {

        yourTurn_x.setText("your turn");
        yourTurn_y.setText("");
        img_4.setImage(img_X);
        cell_4.setText("X");
        cell_4.setDisable(true);
        turn++;

        isWinner();

      //  showResultPopup();


        if(turn<8&&gameOver==0){
            yourTurn_y.setText("your turn");
            yourTurn_x.setText("");
            draw_O();
            turn++;

            isWinner();

         //   showResultPopup();

        }

    }@FXML
    public void drawOnCell_5()
    {
        yourTurn_x.setText("your turn");
        yourTurn_y.setText("");
        img_5.setImage(img_X);
        cell_5.setText("X");
        cell_5.setDisable(true);
        turn++;

        isWinner();

      //  showResultPopup();

        if(turn<8&&gameOver==0){
            yourTurn_x.setText("");
            yourTurn_y.setText("your turn");
            draw_O();
            turn++;

            isWinner();

           // showResultPopup();

        }


    }@FXML
    public void drawOnCell_6()
    {

        yourTurn_x.setText("your turn");
        yourTurn_y.setText("");
        img_6.setImage(img_X);
        cell_6.setText("X");
        cell_6.setDisable(true);
        turn++;

        isWinner();

       // showResultPopup();


        if(turn<8&&gameOver==0){
            yourTurn_y.setText("your turn");
            yourTurn_x.setText("");
            draw_O();
            turn++;

            isWinner();

           // showResultPopup();

        }

    }@FXML
    public void drawOnCell_7()
    {

        yourTurn_x.setText("your turn");
        yourTurn_y.setText("");
        img_7.setImage(img_X);
        cell_7.setText("X");
        cell_7.setDisable(true);
        turn++;

        isWinner();

     //   showResultPopup();


        if(turn<8&&gameOver==0){
            yourTurn_y.setText("your turn");
            yourTurn_x.setText("");
            draw_O();
            turn++;

            isWinner();

            //showResultPopup();

        }


    }@FXML
    public void drawOnCell_8()
    {
        yourTurn_x.setText("your turn");
        yourTurn_y.setText("");
        img_8.setImage(img_X);
        cell_8.setText("X");

        isWinner();

      //  showResultPopup();


        if(turn<8&&gameOver==0){
            yourTurn_y.setText("your turn");
            yourTurn_x.setText("");
            draw_O();
            turn++;

            isWinner();

          //  showResultPopup();

        }

        turn++;
        cell_8.setDisable(true);

    }




    public void isWinner()
    { int tieFlag=0;
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
            //o winner
            if (line.equals("XXX")) {
                tieFlag = 1;
                gameOver=1;
                System.out.println("You won!");
                showResultPopup();
                //winnerLabel.setText("You won!");



            }

            else if (line.equals("OOO")) {
                tieFlag = 1;
                gameOver=1;
                System.out.println("Cpu won");
                showResultPopup();
                //  winnerLabel.setText("You lose!");

            }

        }
        if(tieFlag==0&&turn==9)
        {
            gameOver=1;
            System.out.println("tie");
            showResultPopup();
        }

    }
    public ImageView generateRandomView(){
        Random rand=new Random();
        int cpuPosition=rand.nextInt(9)+1;

        switch(cpuPosition)  {
            case 1: return img_zero;
            case 2:return img_1;
            case 3:return img_2;
            case 4:return img_3;
            case 5:return img_4;
            case 6:return img_5;
            case 7:return img_6;
            case 8:return img_7;
            case 9:return img_8;



        }
        return null;
    }
    public void draw_O(){
        randomView= generateRandomView();
        do{
            randomView= generateRandomView();
        }while (randomView.getImage()!=null);

        if(randomView==img_zero){cell_zero.setDisable(true);cell_zero.setText("O");img_zero.setImage(img_O);}
        else if(randomView==img_1){cell_1.setDisable(true);cell_1.setText("O");img_1.setImage(img_O);}
        else if(randomView==img_2){cell_2.setDisable(true);cell_2.setText("O");img_2.setImage(img_O);}
        else if(randomView==img_3){cell_3.setDisable(true);cell_3.setText("O");img_3.setImage(img_O);}
        else if(randomView==img_4){cell_4.setDisable(true);cell_4.setText("O");img_4.setImage(img_O);}
        else if(randomView==img_5){cell_5.setDisable(true);cell_5.setText("O");img_5.setImage(img_O);}
        else if(randomView==img_6){cell_6.setDisable(true);cell_6.setText("O");img_6.setImage(img_O);}
        else if(randomView==img_7){cell_7.setDisable(true);cell_7.setText("O");img_7.setImage(img_O);}
        else if(randomView==img_8){cell_8.setDisable(true);cell_8.setText("O");img_8.setImage(img_O);}
    }

    public void showResultPopup()  {
        if(gameOver==1) {

            stage = (Stage) player1Label.getScene().getWindow();
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MediumLevelResult.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            popUpStage = new Stage();
            Scene exit = new Scene(root);
            exit.setFill(Color.TRANSPARENT);
            popUpStage.setScene(exit);
            popUpStage.initModality(Modality.APPLICATION_MODAL);
            popUpStage.initStyle(StageStyle.TRANSPARENT);
            popUpStage.showAndWait();


        }

        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


