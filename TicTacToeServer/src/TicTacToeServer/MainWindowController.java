/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToeServer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * @author ramy3
 */
public class MainWindowController {

    @FXML
    private Text currentStatusText;
    @FXML
    private Button serverToggleButton;
    private boolean isStarted = false;


    @FXML
    private void serverSwitch() throws IOException {
        if (!isStarted) {

            System.out.println("Server is Started!");
            currentStatusText.setText("On");
            currentStatusText.setFill(Color.GREEN);
            serverToggleButton.setText("Stop Server");
            isStarted = true;

            new Thread(() ->
            {
                try {
                    MyServer.main();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
               // GameServer.connect(1234);
            }).start();


        } else {
            System.out.println("Server is Stopped!");
            currentStatusText.setText("Off");
            currentStatusText.setFill(Color.RED);
            serverToggleButton.setText("Start Server");
            isStarted = false;
        }
    }
}
