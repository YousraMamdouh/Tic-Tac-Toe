package tictactoeclient;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class LoggingIn_XML {


    public static void validate(Player p) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder =factory.newDocumentBuilder();
        Document doc=builder.newDocument();
        Element root =doc.createElement("login");
        doc.appendChild(root);
        Element employee=root.getOwnerDocument().createElement("player");
        root.appendChild(employee);
        //Name element
        Element email=employee.getOwnerDocument().createElement("email");
        employee.appendChild(email);
        email.setTextContent(p.getEmail());
        //email element
        Element pass=employee.getOwnerDocument().createElement("password");
        employee.appendChild(pass);
        pass.setTextContent(p.getPassword());
    //  StreamResult res=new StreamResult(new File("loginInformation.xml"));
//        DOMSource source =new DOMSource(doc);
//        TransformerFactory tfactory=TransformerFactory.newInstance();
//        Transformer trans=tfactory.newTransformer();
//        StreamResult st=new StreamResult(System.out);
//        trans.transform(source,st);
//        trans.transform(source,res);
//        trans.setOutputProperty(OutputKeys.INDENT,"yes");

    }
}
