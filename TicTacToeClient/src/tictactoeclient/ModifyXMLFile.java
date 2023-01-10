package tictactoeclient;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 *
 * @author saraeltlt
 */

public  class ModifyXMLFile {

    public  static void writeXMLFile(Document doc)
            throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        String filePath="players.xml";
        StreamResult result = new StreamResult(new File(filePath));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
    }

    public static void updateElementValue(Document doc, String from, String to, String msg) throws TransformerFactoryConfigurationError, TransformerException {
        NodeList users = doc.getElementsByTagName("request");
        Element user = null;
        for (int i = 0; i < users.getLength(); i++) {
            user = (Element) users.item(i);
            Node fromN = user.getElementsByTagName("from").item(0).getFirstChild();
            fromN.setNodeValue(from);
            Node toN = user.getElementsByTagName("to").item(0).getFirstChild();
            toN.setNodeValue(to);
            Node msgN = user.getElementsByTagName("msg").item(0).getFirstChild();
            msgN.setNodeValue(msg);
        }
        ModifyXMLFile.writeXMLFile(doc);
    }


    public static String getMsg(Document doc){
        NodeList nodeList = doc.getElementsByTagName("request");
        String str=null;
        Node node = nodeList.item(0);
        if (node.getNodeType() == Node.ELEMENT_NODE)
        {
            Element eElement = (Element) node;
            str= eElement.getElementsByTagName("msg").item(0).getTextContent();

        }
        return str;
    }
    public static String getFrom(Document doc){
        NodeList nodeList = doc.getElementsByTagName("request");
        String from =null;
        Node node = nodeList.item(0);
        if (node.getNodeType() == Node.ELEMENT_NODE)
        {
            Element eElement = (Element) node;
            from= eElement.getElementsByTagName("from").item(0).getTextContent();

        }
        return from;
    }
    public static String getTo(Document doc){
        NodeList nodeList = doc.getElementsByTagName("request");
        String to=null;
        Node node = nodeList.item(0);
        if (node.getNodeType() == Node.ELEMENT_NODE)
        {
            Element eElement = (Element) node;
            to=  eElement.getElementsByTagName("to").item(0).getTextContent();

        }
        return to;
    }

}