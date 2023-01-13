package TicTacToeServer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ReplyToLogin {
    static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    static DocumentBuilder builder;

    static {
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    static Document successLogin = builder.newDocument();
    static Document failedLogin=builder.newDocument();

    public static Document returnSuccessLogin()  {


        Element root = successLogin.createElement("Success-Login");
        successLogin.appendChild(root);

        Element player = root.getOwnerDocument().createElement("Message");
        root.appendChild(player);
        //first name element
        player.setTextContent("Logged-in successfully");
        return successLogin;
    }
    public static Document returnFailedLogin()
    {
        Element root = failedLogin.createElement("Failed-Login");
        failedLogin.appendChild(root);

        Element player = root.getOwnerDocument().createElement("Message");
        root.appendChild(player);
        //first name element
        player.setTextContent("you don't have account , please sign up first  ");
        return failedLogin;
    }
}
