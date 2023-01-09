package TicTacToeServer;

import org.w3c.dom.Document;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    ServerSocket myServerSocket;
    Socket s;

    ObjectInputStream in;
    ObjectOutputStream out;
    static Document doc;

    public static  void main() throws IOException, ClassNotFoundException {
       new MyServer();
    }
    public MyServer() throws IOException, ClassNotFoundException {
        System.out.println("I'm Listening");

        myServerSocket=new ServerSocket(5005);

        s=myServerSocket.accept();

        in=new ObjectInputStream(s.getInputStream());

        out=new ObjectOutputStream(s.getOutputStream());

        doc= (Document) in.readObject();

        System.out.println("object received");
      // ReadingSignupData.main();
       ReadingLoginData.main();


    }
}



