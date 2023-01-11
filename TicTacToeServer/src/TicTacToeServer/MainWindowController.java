/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToeServer;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * @author ramy3
 */
public class MainWindowController implements Initializable {
    @FXML
    private ListView<PlayerCell> listView;
    private final ObservableList<PlayerCell> data = FXCollections.observableArrayList();

    @FXML
    private Text currentStatusText;
    @FXML
    private Button serverToggleButton;
    private boolean isStarted = false;

    public MainWindowController() {
    }

    @FXML
    private void serverSwitch() {
        listView.setItems(data);
        if (!isStarted) {
            System.out.println("Server is Started!");
            currentStatusText.setText("On");
            currentStatusText.setFill(Color.GREEN);
            serverToggleButton.setText("Stop Server");
            isStarted = true;
            data.addAll(PlayerCell.getReadyList());
            listView.setItems(data);
            new Thread(() -> GameServer.connect(1234)).start();
        } else {
            data.clear();
            GameServer.stop();
            System.out.println("Server is Stopped!");
            currentStatusText.setText("Off");
            currentStatusText.setFill(Color.RED);
            serverToggleButton.setText("Start Server");
            isStarted = false;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listView.setCellFactory(listView -> new CustomCell());
        listView.getSelectionModel().selectedItemProperty().addListener(new CustomCellListener());
    }
}
