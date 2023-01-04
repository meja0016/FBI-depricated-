import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class nonPoliceXML{

    public static void main(String[] args) {
        new nonPoliceXML().nonPoliceXML();
    }

    public void nonPoliceXML(){
       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  
        try {
            //dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("nonPolcieXML-01-04-2023.maxplank.marx"));
            doc.getDocumentElement().normalize();
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList list = doc.getElementsByTagName("nonPoliceWebService");
            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    NodeList elementNodeList = element.getElementsByTagName("nonPoliceOperation");
                    System.out.println(element.getElementsByTagName("nonPoliceOperation").item(0).getTextContent());
                }
            }
  
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
  
    }
  
}