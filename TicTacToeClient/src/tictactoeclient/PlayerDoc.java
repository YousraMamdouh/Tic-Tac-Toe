package tictactoeclient;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDoc {

    public static Document playerToDoc(Player player) throws ParserConfigurationException {
        Document doc = createDoc();
        PlayerDoc.createPlayerElement(doc, player);
        return doc;
    }

    public static Player docToPlayer(Document doc) {
        Element element = doc.getDocumentElement();
        return new Player(getTagValue(element, "name"),
                Integer.parseInt(getTagValue(element, "id")),
                Integer.parseInt(getTagValue(element, "status")),
                Integer.parseInt(getTagValue(element, "score")),
                getTagValue(element, "email"));
    }

    public static Document playerListToDoc(List<Player> playerList) throws ParserConfigurationException {
        Document doc = createDoc();
        Element root = doc.createElement("players");
        for (Player player : playerList) {
            root.appendChild(PlayerDoc.createPlayerElement(doc, player));
        }
        return doc;
    }

    public static List<Player> docToPlayerList(Document players) {
        List<Player> playerList = new ArrayList<>();

        NodeList list = players.getElementsByTagName("players");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                playerList.add(new Player(getTagValue(element, "name"),
                        Integer.parseInt(getTagValue(element, "id")),
                        Integer.parseInt(getTagValue(element, "status")),
                        Integer.parseInt(getTagValue(element, "score")),
                        getTagValue(element, "email")));
            }
        }
        return playerList;
    }

    private static Element createPlayerElement(Document doc, String name, String value) {
        Element root = doc.createElement(name);
        root.appendChild(doc.createTextNode(value));
        return root;
    }

    private static Element createPlayerElement(Document doc, Player player) {
        Element playerElement = doc.createElement("player");
        playerElement.appendChild(createPlayerElement(doc, "name", player.getName()));
        playerElement.appendChild(createPlayerElement(doc, "id", String.valueOf(player.getId())));
        playerElement.appendChild(createPlayerElement(doc, "status", String.valueOf(player.getStatus())));
        playerElement.appendChild(createPlayerElement(doc, "score", String.valueOf(player.getStatus())));
        playerElement.appendChild(createPlayerElement(doc, "email", player.getEmail()));
        return playerElement;
    }


    private static Document createDoc() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }


    private static String getTagValue(Element e, String tag) {
        return e.getElementsByTagName(tag).item(0).getTextContent();
    }


}
