/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author saraeltlt
 */


public class profileController implements Initializable {
    private Stage stage;
    private Stage popUpStage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<GameCell> listViewHistory;

    @FXML
    private ListView<PlayerCell> listViewPlayers;
    private Label label;
    @FXML
    private Label userNameLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Button logoutButton;
    @FXML
    private Button requestButton;
    @FXML
    private Button cancelButton;
    private AnchorPane anchorPane;
    @FXML
    private Button rejectButton;
    @FXML
    private Button acceptButton;
    private final ObservableList<PlayerCell> dataPlayers= FXCollections.observableArrayList();
    private final ObservableList<GameCell> dataHistory= FXCollections.observableArrayList();
    public static profileController myInstance;
    public static profileController myInstance2;
    public profileController (){
        myInstance=this;
        myInstance2=this;

    }

    public void requestSent() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/tictactoeclient/Request_Popup.fxml"));
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner( requestButton.getScene().getWindow());
        //styling
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.showAndWait();
    }

    public void requestRecived() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/tictactoeclient/ReceivedRequest_popup.fxml"));
        stage = new Stage();
        stage.setScene(new Scene(root));
        //styling
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.showAndWait();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dataPlayers.addAll(PlayerCell.getReadyList());
        if ( listViewPlayers!=null) {
            listViewPlayers.setItems(dataPlayers);
            listViewPlayers.setCellFactory(listView -> new CustomCell());
           listViewPlayers.getSelectionModel().selectedItemProperty().addListener(new CustomCellListener());

        }

        dataHistory.addAll(GameCell.getReadyList());
        if ( listViewHistory!=null) {
            listViewHistory.setItems(dataHistory);
            listViewHistory.setCellFactory(listView -> new CustomGameCell());
//            listViewHistory.getSelectionModel().selectedItemProperty().addListener(new CustomCellListener());
        }
    }

    public void switchToProfile(ActionEvent event ) throws IOException{

        stage  = (Stage)cancelButton.getScene().getWindow();
        stage.close();

    }
    public void switchToRequest(ActionEvent event ) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("/tictactoeclient/Request_Popup.fxml"));
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner( requestButton.getScene().getWindow());
        //styling
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.showAndWait();
    }
    public void switchToHome(ActionEvent event ) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HomePage.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
@FXML
    public String isAcceptButton(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("OnlineBoard.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        popUpStage = (Stage) acceptButton.getScene().getWindow();
        stage.show();
        popUpStage.close();

        return "accept";

    }

    public void switchToGame() throws IOException {
        stage =CurrentSession.getCurrentStage();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("OnlineBoard.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
