/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package TicTacToeServer;

/**
 * @author saraeltlt
 */

import org.w3c.dom.Document;

import javax.xml.transform.TransformerFactoryConfigurationError;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// ClientHandler class
public class ClientHandler extends Thread {
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    private String userName;
    Socket clientSocket;
    static Vector<ClientHandler> clientsVector = new Vector<>();
    static HashMap<String,ClientHandler> sockets= new HashMap<String,ClientHandler>();

    public ClientHandler(Socket socket) {
     clientSocket=socket;
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
               if(doc.getDocumentElement().getTagName().equals("login")) {
                   String email = doc.getElementsByTagName("email").item(0).getTextContent();
                   String password = doc.getElementsByTagName("password").item(0).getTextContent();
                   System.out.println("The player's email is: " + email);
                   System.out.println("The player's password is: " + password);
                   sockets.put(email,this);

               }
               else if (doc.getDocumentElement().getTagName().equals("sign-up")) {

                   String email = doc.getElementsByTagName("email").item(0).getTextContent();
                   String password = doc.getElementsByTagName("password").item(0).getTextContent();
                   String username = doc.getElementsByTagName("username").item(0).getTextContent();
                   System.out.println("The player's username is: " + username);
                   System.out.println("The player's email is: " + email);
                   System.out.println("The player's password is: " + password);
                  Player p = new Player(username,email,password);
                   try {
                       DatabaseConnection.registerPlayer(p);
                       sockets.put(username,this);
                   } catch (SQLException e) {
                       System.out.println("you already have account ");
                   }


               }
               else if (doc.getDocumentElement().getNodeName().equals("root")){
                   String msg = ModifyXMLFile.getMsg(doc);
                   String from = ModifyXMLFile.getFrom(doc);
                   String to = ModifyXMLFile.getTo(doc);
                   System.out.println("hi request" + msg + from + to);
                   sendRequest(doc);

               }


            } catch (IOException e) {
                System.out.println("Client disconnected!");
                ClientHandler.clientsVector.remove(this);
                this.stop();
            } catch (ClassNotFoundException | TransformerFactoryConfigurationError  ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void sendRequest(Document doc) {
       for(int i=0 ; i<sockets.size() ; i++) {
            try {
                //if (i==1)
                clientsVector.get(i).objectOutputStream.writeObject(doc);
            } catch (IOException | TransformerFactoryConfigurationError ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }
}


    
    
    
    
    
    
    

