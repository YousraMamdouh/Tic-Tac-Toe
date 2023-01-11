package TicTacToeServer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;


public class Converter {


    public static Document convertPlayerToDom(Player p) {
        Document doc = null;
        try {
            doc = createDoc();
            Element root = doc.createElement("players");
            doc.appendChild(root);
            Element player = doc.createElement("player");
            root.appendChild(player);

            player.appendChild(createElement(doc, "id", String.valueOf(p.getPlayer_id())));
            player.appendChild(createElement(doc, "user_name", p.getUser_name()));
            player.appendChild(createElement(doc, "status", String.valueOf(p.getStatus())));
            player.appendChild(createElement(doc, "score", String.valueOf(p.getScore())));
            player.appendChild(createElement(doc, "email", p.getEmail()));
            player.appendChild(createElement(doc, "password", p.getPassword()));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public static Player convertDomToPlayer(Document dom) {

        NodeList list = dom.getElementsByTagName("player");
        Node node = list.item(0);
        Element element = (Element) node;
        int id = Integer.parseInt(fillPlayer(element, "id"));
        String user_name = fillPlayer(element, "user_name");
        int status = Integer.parseInt(fillPlayer(element, "status"));
        int score = Integer.parseInt(fillPlayer(element, "score"));
        String email = fillPlayer(element, "email");
        String password = fillPlayer(element, "password");

        return new Player(id, user_name, status, score, email, password);
    }

    public static List<Player> convertDomToPlayers(Document dom) {
        List<Player> playersList = new ArrayList();
        NodeList list = dom.getElementsByTagName("player");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                playersList.add(new Player(Integer.parseInt(getTagValue(element, "id")), getTagValue(element, "user_name"), Integer.parseInt(getTagValue(element, "status")), Integer.parseInt(getTagValue(element, "score")), getTagValue(element, "email"), getTagValue(element, "password")));
            }
        }
        return playersList;
    }

    private static Document createDoc() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    private static String fillPlayer(Element value, String tagName) {
        return value.getElementsByTagName(tagName).item(0).getTextContent();
    }

    private static Element createElement(Document doc, String tagName, String value) {

        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(value));
        return element;
    }

    private static String getTagValue(Element e, String tag) {
        return e.getElementsByTagName(tag).item(0).getTextContent();
    }
}