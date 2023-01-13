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

public class LoggingIn_XML {


    static Document doc;
    public static Document validate(Player p) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder =factory.newDocumentBuilder();
        doc=builder.newDocument();
        Element root =doc.createElement("login");
        doc.appendChild(root);
        Element employee=root.getOwnerDocument().createElement("player");
        root.appendChild(employee);
        //Name element
        Element email=employee.getOwnerDocument().createElement("email");
        employee.appendChild(email);
        email.setTextContent(p.getName());
        //email element
        Element pass=employee.getOwnerDocument().createElement("password");
        employee.appendChild(pass);
        pass.setTextContent(p.getPassword());
        // StreamResult res=new StreamResult(new File("loginInformation.xml"));
        DOMSource source =new DOMSource(doc);
        TransformerFactory tfactory=TransformerFactory.newInstance();
        Transformer trans=tfactory.newTransformer();
        StreamResult st=new StreamResult(System.out);
        trans.transform(source,st);
        // trans.transform(source,res);
        trans.setOutputProperty(OutputKeys.INDENT,"yes");
        return doc;

    }
}

