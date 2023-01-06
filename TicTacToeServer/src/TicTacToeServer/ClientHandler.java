package TicTacToeServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    BufferedReader bufferReader;
    PrintStream printStream;
    public ClientHandler(Socket socket) {
        try {
            bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
    }
    public void run() {
        while (true){ //mfrod while feh connection aw while ay haga logical
            String str = null;
            try {

                str = bufferReader.readLine();
                System.out.println(str);
                //shof hane3ml eh ba2a beh

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }

}
