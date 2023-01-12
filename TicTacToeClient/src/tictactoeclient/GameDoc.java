package TicTacToeServer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tictactoeclient.GameHistory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class GameDoc {
    public static Document gameToDoc(GameHistory game) throws ParserConfigurationException {
        Document doc = createDoc();
        createGameElement(doc, game);
        return doc;
    }

    public static GameHistory docToGame(Document doc) {
        Element element = doc.getDocumentElement();
        return new GameHistory(Integer.parseInt(getTagValue(element, "id")),
                getTagValue(element, "playerOne"),
                getTagValue(element, "playerTwo"),
                getCells(element),
                getTagValue(element, "winner"),
                getTagValue(element, "timeStamp"));
    }

    public static Document gameListToDoc(List<GameHistory> gameList) throws ParserConfigurationException {
        Document doc = createDoc();
        Element root = doc.createElement("Recorded_Games");
        for (GameHistory game : gameList) {
            root.appendChild(createGameElement(doc, game));
        }
        return doc;
    }


    public static List<GameHistory> docToGameList(Document game) {
        List<GameHistory> gameList = new ArrayList<>();
        int[] cells = new int[9];
        NodeList list = game.getElementsByTagName("Recorded_Game");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                gameList.add(new GameHistory(
                        Integer.parseInt(getTagValue(element, "id")),
                        getTagValue(element, "playerOne"),
                        getTagValue(element, "playerTwo"),
                        getCells(element),
                        getTagValue(element, "winner"),
                        getTagValue(element, "timeStamp")));
            }
        }
        return gameList;
    }

    public static Element createGameElement(Document doc, String name, String value) {
        Element root = doc.createElement(name);
        root.appendChild(doc.createTextNode(value));
        return root;
    }

    private static Element createGameElement(Document doc, GameHistory game) {
        Element gameElement = doc.createElement("Recorded_Game");
        gameElement.appendChild(createGameElement(doc, "playerOne", game.getPlayerOne()));
        gameElement.appendChild(createGameElement(doc, "playerTwo", game.getPlayerTwo()));
        for (int i = 0; i < 9; i++) {
            gameElement.appendChild(createGameElement(doc, "cell_" + i, String.valueOf(game.getOrder()[i])));
        }
        gameElement.appendChild(createGameElement(doc, "winner", game.getWinnerName()));
        return gameElement;
    }


    private static Document createDoc() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    private static int[] getCells(Element e) {
        int[] cells = new int[9];
        for (int j = 0; j < 9; j++) {
            cells[j] = Integer.parseInt(e.getElementsByTagName("cell_" + j).item(0).getTextContent());
        }
        return cells;
    }

    private static String getTagValue(Element e, String tag) {
        return e.getElementsByTagName(tag).item(0).getTextContent();
    }
}
