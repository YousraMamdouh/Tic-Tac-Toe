package tictactoeclient;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class signingup_XML  {
    static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    static DocumentBuilder builder;

    static {
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    static Document doc=builder.newDocument();
    public static void validate(Player p) throws ParserConfigurationException, TransformerException {



        Element root =doc.createElement("sign-up");
        doc.appendChild(root);

        Element player=root.getOwnerDocument().createElement("player");
        root.appendChild(player);
        //first name element
        Element username=player.getOwnerDocument().createElement("username");
        player.appendChild(username);
        username.setTextContent(p.getUser_name());

        //email element
        Element email=player.getOwnerDocument().createElement("email");
        player.appendChild(email);
        email.setTextContent(p.getEmail());
        //password element
        Element pass=player.getOwnerDocument().createElement("password");
        player.appendChild(pass);
        pass.setTextContent(p.getPassword());

        //  StreamResult res=new StreamResult(new File("signing-upInformation.xml"));
        DOMSource source =new DOMSource(doc);
        TransformerFactory tfactory=TransformerFactory.newInstance();
        Transformer trans=tfactory.newTransformer();
        StreamResult st=new StreamResult(System.out);
        trans.transform(source,st);
        // trans.transform(source,res);
        trans.setOutputProperty(OutputKeys.INDENT,"yes");

    }
}

