package TicTacToeServer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ReplyToSignUp {
    static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    static DocumentBuilder builder;

    static {
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    static Document successSignup = builder.newDocument();
    static Document failedSignup=builder.newDocument();

    public static Document returnSuccessSignup()  {


        Element root = successSignup.createElement("Success-Sign-Up");
        successSignup.appendChild(root);

        Element player = root.getOwnerDocument().createElement("Message");
        root.appendChild(player);
        //first name element
        player.setTextContent("Signed up successfully");
        return successSignup;
    }
    public static Document returnFailedSignup()
    {
        Element root = failedSignup.createElement("Failed-Sign-Up");
        failedSignup.appendChild(root);

        Element player = root.getOwnerDocument().createElement("Message");
        root.appendChild(player);
        //first name element
        player.setTextContent("you already have account, please login ");
        return failedSignup;
    }
}
