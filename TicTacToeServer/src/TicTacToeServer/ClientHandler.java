package TicTacToeServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    PrintWriter out = null;
    BufferedReader in = null;

    public ClientHandler(Socket socket)
    {
        this.clientSocket = socket;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run()
    {
        try {
            String line;
            while ((line = in.readLine()) != null) { //mfrod while feh connection aw while ay haga logical
                System.out.printf(" Sent from the client: %s\n",line);
                out.println("hello"); //
                //shof hane3ml eh ba2a beh
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
