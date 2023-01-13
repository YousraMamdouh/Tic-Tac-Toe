package tictactoeclient;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class CustomCellListener implements ChangeListener<PlayerCell> {
    public String getUserName() {
        return userName;
    }

    private String userName;


    @Override
    public void changed(ObservableValue<? extends PlayerCell> observable, PlayerCell oldValue, PlayerCell newValue) {

        if (newValue != null  /* &&newValue.getPlayerStatus()==1*/) { //ezay wheya image?

            userName = newValue.getPlayerName().getText();
            System.out.println("Clicked On : " +  userName );
            try {
                File xmlFile = new File("playersRequest.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder;
                dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);
                String from=CurrentSession.getPlayer().getName();
                ModifyXMLFile.updateElementValue(doc,from,userName,"request");
                if (doc != null) {
                    CurrentSession.getGame().sendMsg(doc);
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TransformerException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }


        }

    }

}