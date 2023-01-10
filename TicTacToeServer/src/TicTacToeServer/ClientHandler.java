/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package TicTacToeServer;

/**
 * @author saraeltlt
 */

import org.w3c.dom.Document;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// ClientHandler class
public class ClientHandler extends Thread {
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    static Vector<ClientHandler> clientsVector = new Vector<>();

    public ClientHandler(Socket socket) {

        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            ClientHandler.clientsVector.add(this);
            start();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        while (true) {
            try {
               Document doc = (Document) objectInputStream.readObject();
               // String msg = ModifyXMLFile.getMsg(doc);
                //String from = ModifyXMLFile.getFrom(doc);


              sendMessageToOtherPlayer(doc);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException | TransformerFactoryConfigurationError  ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void sendMessageToOtherPlayer(Document doc) {


        for (ClientHandler clientHandler : clientsVector) {


            try {
                clientHandler.objectOutputStream.writeObject(doc);
                System.out.println(clientHandler);

            } catch (IOException | TransformerFactoryConfigurationError ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }
}


    
    
    
    
    
    
    

