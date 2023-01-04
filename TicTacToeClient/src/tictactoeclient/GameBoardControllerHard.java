/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
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
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author saraeltlt
 */
public class GameBoardControllerHard implements Initializable {
    private static Stage stage;
    private Stage popUpStage;
    private Parent root;
    private Scene scene;
    @FXML
    private Button noButton;
    @FXML
    private Button yesButton;
    @FXML
    private Button  cell_zero;
    @FXML
    private Button  cell_1;
    @FXML
    private Button  cell_2;
    @FXML
    private Button  cell_3;
    @FXML
    private Button  cell_4;
    @FXML
    private Button  cell_5;
    @FXML
    private Button  cell_6;
    @FXML
    private Button  cell_7;
    @FXML
    private Button  cell_8;
    @FXML
    private Button okButton;

    @FXML
    private Button recordButton;
    @FXML
    private Button recordINGButton;
    @FXML
    private ImageView img_zero;
    @FXML
    private ImageView img_1;
    @FXML
    private ImageView img_2;
    @FXML
    private ImageView img_3;
    @FXML
    private ImageView img_4;
    @FXML
    private ImageView img_5;
    @FXML
    private ImageView img_6;
    @FXML
    private ImageView img_7;
    @FXML
    private ImageView img_8;

    @FXML
    private Label player1Label;
    @FXML
    private Label player2Label;
    @FXML
    private Label yourTurn_x;
    @FXML
    private Label yourTurn_y;
    @FXML
    private Label playerWins;

    @FXML
    private MediaView mediaView;

    @FXML
    private Line drawLine;

    private int whoWins=0;
    Boolean recordFlag = false;
     int steps=0;
    int count;
    List<ImageView> imageArrayList = new ArrayList<>();





    public void setTextToLabel (String text) {
      playerWins.setText(text);
    }

    LevelHardMinMax hardAI = new LevelHardMinMax();
    Integer [] moves = new Integer[9];
    ArrayList<Button> buttons;
    Random random = new Random();
    Image imageX;
    Image imageO;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                            startHardAi();
                        imageX = new Image("/res/X.png");
                        imageO = new Image("/res/O.png");
                        ImageView[] anotherList = new ImageView[]{img_zero,img_1,img_2,img_3,img_4,img_5,img_6,img_7,img_8};
                        imageArrayList.addAll(Arrays.asList(anotherList));

                    }
                });
    }

    public  void startHardAi()  {
        if (cell_1!=null) {
            recordINGButton.setVisible(false);
            yourTurn_y.setVisible(false);
            yourTurn_x.setVisible(false);
            drawLine.setVisible(false);
            buttons = new ArrayList<>(Arrays.asList(cell_zero, cell_1, cell_2, cell_3, cell_4, cell_5, cell_6, cell_7, cell_8));
            buttons.forEach(button -> {
                setupButton(button);
                button.setFocusTraversable(false);
            });
            makeAIMove();
        }
    }

    private void setupButton(Button button) {
        if (button!=null) {
            button.setOnMouseClicked(mouseEvent -> {
                button.setText("O");
                drawImage(button.getId(), 'O');
                button.setDisable(true);
                try {
                    checkIfGameIsOver();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                makeAIMove();
                try {
                    checkIfGameIsOver();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
        }
    }

    public void makeAIMove(){
        int move = hardAI.minMaxDecision(getBoardState());
        if (buttons.get(move) !=null) {
            buttons.get(move).setText("X");
            drawImage(buttons.get(move).getId(), 'X');
            buttons.get(move).setDisable(true);
        }
    }


   public void drawImage(String btnId, char turn){

        Image image;
        double player;
       char cell = btnId.charAt(5);
       if (cell=='z') cell='0'; //becuase zero not 0

        if (turn=='X') {
            image = new Image("/res/X.png");
        }
        else {
            image = new Image("/res/O.png");
        }
        moves[steps]= Integer.parseInt(String.valueOf(cell))+1 ;
       System.out.println(steps+"->"+moves[steps]);
        steps++;

        switch (cell) {
            case '0' : img_zero.setImage(image); break;
            case '1' : img_1.setImage(image); break;
            case '2' : img_2.setImage(image); break;
            case '3' : img_3.setImage(image); break;
            case '4' : img_4.setImage(image); break;
            case '5' : img_5.setImage(image); break;
            case '6' : img_6.setImage(image); break;
            case '7' : img_7.setImage(image); break;
            case '8' : img_8.setImage(image); break;
        }

    }
    public State getBoardState(){
        String[] board = new String[9];

        for (int i = 0; i < buttons.size(); i++) {
            board[i] = buttons.get(i).getText();
        }

        return new State(0,board);
    }
    public void checkIfGameIsOver() throws IOException {
        for (int a = 0; a < 8; a++) {
            String line;
            switch (a) {
                case 0:
                    line = cell_zero.getText() + cell_1.getText() + cell_2.getText();
                    if (line.equals("XXX") ||line.equals("OOO") ) {
                        drawLine.setStartX(-121.5);
                        drawLine.setStartY(0);
                        drawLine.setEndX(208.5);
                        drawLine.setEndY(0);
                    }
                    break;
                case 1:
                    line = cell_3.getText() + cell_4.getText() + cell_5.getText();
                    if (line.equals("XXX") ||line.equals("OOO") ) {
                        drawLine.setStartX(-121.5);
                        drawLine.setStartY(120);
                        drawLine.setEndX(208.5);
                        drawLine.setEndY(120);
                    }
                    break;
                case 2:
                    line = cell_6.getText() + cell_7.getText() + cell_8.getText();
                    if (line.equals("XXX") ||line.equals("OOO") ) {
                        drawLine.setStartX(-121.5);
                        drawLine.setStartY(240);
                        drawLine.setEndX(208.5);
                        drawLine.setEndY(240);
                    }
                    break;
                case 3:
                    line = cell_zero.getText() + cell_4.getText() + cell_8.getText();
                    if (line.equals("XXX") ||line.equals("OOO") ){
                    drawLine.setStartX(-130);
                    drawLine.setStartY(-50);
                    drawLine.setEndX(220);
                    drawLine.setEndY(290);
                }
                    break;
                case 4:
                    line = cell_2.getText() + cell_4.getText() + cell_6.getText();
                    if (line.equals("XXX") ||line.equals("OOO") ) {
                        drawLine.setStartX(208.5);
                        drawLine.setStartY(-50);
                        drawLine.setEndX(-121.5);
                        drawLine.setEndY(290);
                    }
                    break;
                case 5:
                    line = cell_zero.getText() + cell_3.getText() + cell_6.getText();
                    if (line.equals("XXX") ||line.equals("OOO") ) {
                        drawLine.setStartX(-80);
                        drawLine.setStartY(-60);
                        drawLine.setEndX(-80);
                        drawLine.setEndY(295);
                    }
                    break;
                case 6:
                    line = cell_1.getText() + cell_4.getText() + cell_7.getText();
                    if (line.equals("XXX") ||line.equals("OOO") ) {
                        drawLine.setStartX(45);
                        drawLine.setStartY(-60);
                        drawLine.setEndX(45);
                        drawLine.setEndY(295);
                    }
                    break;
                case 7:
                    line = cell_2.getText() + cell_5.getText() + cell_8.getText();
                    if (line.equals("XXX") ||line.equals("OOO") ) {
                        drawLine.setStartX(170);
                        drawLine.setStartY(-60);
                        drawLine.setEndX(170);
                        drawLine.setEndY(295);
                    }
                    break;
                default:
                    line = null;
            }
            //o winner
            if (line.equals("XXX")) {
                whoWins=-1;
                drawLine.setVisible(true);
                gameEnd("You Lost !!");
            }
            //x winner
            else if (line.equals("OOO")) {
                whoWins=1;
                drawLine.setVisible(true);
                gameEnd("You Won !!");
            }
        }

        if(hardAI.successorsOf(getBoardState()).isEmpty() && whoWins==0) {
            gameEnd("It's a tie ");
        }

    }
    private void gameEnd(String text)  throws IOException {
        /*if (recordFlag==true) {
            restartGame();
            slideShow();
        }*/
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Result_WindowHard.fxml"));
        Parent root = loader.load();
        GameBoardControllerHard controller = (GameBoardControllerHard)loader.getController();
        controller.setTextToLabel(text);
        stage = (Stage) cell_1.getScene().getWindow();
        popUpStage = new Stage();
        Scene exit = new Scene(root);
        exit.setFill(Color.TRANSPARENT);
        popUpStage.setScene(exit);
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.initStyle(StageStyle.TRANSPARENT);
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(e ->popUpStage.show());
        delay.play();
       // restartGame();


    }

    public void slideShow() {
        Task task = new Task<Void>() {
            boolean turn =true;
            @Override
            public Void call() throws Exception {
                for (int i = 0; i < moves.length; i++) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (turn && moves[count]!=0) {
                                imageArrayList.get(moves[count]-1).setImage(imageX);
                                count++;
                                turn=false;
                            }
                            else if (turn==false && moves[count]!=0){
                                imageArrayList.get(moves[count]-1).setImage(imageO);
                                count++;
                                turn=true;
                            }
                        }
                    });

                    Thread.sleep(1500);
                }
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

    }
    void restartGame()  {
        buttons.forEach(button -> {
                button.setDisable(false);
                button.setText("");
        });

        int index =random.nextInt(9);
        buttons.get(index).setText("X");
        buttons.get(index).setDisable(true);
        clearImages();
        drawLine.setVisible(false);
    }
    void clearImages(){
        img_zero.setImage(null);
        img_1.setImage(null);
        img_2.setImage(null);
        img_3.setImage(null);
        img_4.setImage(null);
        img_5.setImage(null);
        img_6.setImage(null);
        img_7.setImage(null);
        img_8.setImage(null);
    }
    @FXML
    private void setBackArrowMethod(ActionEvent e) throws IOException{
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Exit_Popup.fxml")));
        popUpStage = new Stage();
        Scene exit = new Scene(root);
        exit.setFill(Color.TRANSPARENT);
        popUpStage.setScene(exit);
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.initStyle(StageStyle.TRANSPARENT);
        popUpStage.showAndWait();

    }
    @FXML
    private void setOkButton() throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.FXML")));
        scene = new Scene(root);
        stage.setScene(scene);
        popUpStage = (Stage) okButton.getScene().getWindow();
        stage.show();
        popUpStage.close();


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
    private void setNoButton() {
        popUpStage = (Stage) noButton.getScene().getWindow();
        popUpStage.close();
    }
    @FXML
    private void recordButton (){
        recordButton.setVisible(false);
        recordButton.setDisable(true);
        recordINGButton.setVisible(true);
        recordFlag=true;
    }



}
