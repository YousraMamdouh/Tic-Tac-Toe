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
    Socket clientSocket;
    static Vector<ClientHandler> clientsVector = new Vector<>();

    static HashMap<String,ClientHandler> sockets= new HashMap<String,ClientHandler>();
    ClientHandler c;

    public ClientHandler(Socket socket) {
        clientSocket=socket;
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            c=this;
            ClientHandler.clientsVector.add(c);
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
                    System.out.println("The player's Username is: " + email);
                    System.out.println("The player's password is: " + password);
                    Player p=new Player(email,password);
                    try {
                       String resultLogin= DatabaseConnection.playerAuth(p);
                        System.out.println(resultLogin);

                        if(resultLogin.equals("Success"))
                        {
                            this.objectOutputStream.writeObject(ReplyToLogin.returnSuccessLogin());
                            System.out.println("Logged in successfully");
                        }
                        else {
                            this.objectOutputStream.writeObject(ReplyToLogin.returnFailedLogin());
                            System.out.println("you don't have account , please sign up first");
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    //this.objectOutputStream.writeObject(doc);
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
                        this.objectOutputStream.writeObject(ReplyToSignUp.returnSuccessSignup());
                        System.out.println("signed up successfully");

                    } catch (SQLException e) {
                        this.objectOutputStream.writeObject(ReplyToSignUp.returnFailedSignup());
                        System.out.println("you already have account ");
                    }
                }

                else if (doc.getDocumentElement().getNodeName().equals("root")){
                    String msg = ModifyXMLFile.getMsg(doc);
                    String from = ModifyXMLFile.getFrom(doc);
                    String to = ModifyXMLFile.getTo(doc);
                    System.out.println("hi request:  " + msg + from + to);
                    if (msg.equals("request"))
                        sendRequest(doc);

                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException | TransformerFactoryConfigurationError  ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    void sendRequest(Document doc) {
        String to = ModifyXMLFile.getTo(doc);
        try {
            sockets.get(to).objectOutputStream.writeObject(doc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void sendMessageToOtherPlayer(Document doc) {


        for (ClientHandler clientHandler : clientsVector) {


            try {
                clientHandler.objectOutputStream.writeObject(doc);
                //System.out.println();

            } catch (IOException | TransformerFactoryConfigurationError ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }

//   void sendMessageToClient()
//    {
//
//    }
}










