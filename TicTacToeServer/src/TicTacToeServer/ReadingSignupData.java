package TicTacToeServer;

import java.io.IOException;

public class ReadingSignupData {
    private static String username;
    private static String email;
    private static String password;

    public static void main() throws IOException, ClassNotFoundException {

        ReadingSignupData.readData();

    }

    public static void readData () throws IOException, ClassNotFoundException {

       // username=MyServer.doc.getElementsByTagName("username").item(0).getTextContent();
        //email=MyServer.doc.getElementsByTagName("email").item(0).getTextContent();
        //password=MyServer.doc.getElementsByTagName("password").item(0).getTextContent();
        System.out.println("The player's name is: "+username);
        System.out.println("The player's email is: "+email);
        System.out.println("The player's password is: "+password);

    }

}
