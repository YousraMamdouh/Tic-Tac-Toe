package tictactoeclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MyClient {


    Socket myClientSocket;

    ObjectInputStream in;
    ObjectOutputStream out;

    public static  void main() throws IOException, ClassNotFoundException {
        new MyClient();
    }
    public MyClient() throws IOException, ClassNotFoundException {

       myClientSocket=new Socket("127.0.0.1",1234);

        out=new ObjectOutputStream(myClientSocket.getOutputStream());

        in=new ObjectInputStream(myClientSocket.getInputStream());



       //out.writeObject(signingup_XML.doc);

       out.writeObject(LoggingIn_XML.doc);

       // Document doc= (Document) in.readObject();

        System.out.println("object sent");

    }
}


