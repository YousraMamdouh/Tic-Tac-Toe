package TicTacToeServer;

import java.io.IOException;

public class ReadingLoginData {
    private static String email;
    private static String password;

    public static void main() throws IOException, ClassNotFoundException {

        ReadingLoginData.readData();

    }

    public static void readData () throws IOException, ClassNotFoundException {


        email=MyServer.doc.getElementsByTagName("email").item(0).getTextContent();
        password=MyServer.doc.getElementsByTagName("password").item(0).getTextContent();

        System.out.println("The player's email is: "+email);
        System.out.println("The player's password is: "+password);

    }

}