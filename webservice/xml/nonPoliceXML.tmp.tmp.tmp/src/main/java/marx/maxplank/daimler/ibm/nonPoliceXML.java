package marx.maxplank.daimler.ibm;

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

public class nonPoliceXML{

    public static void main(String[] args) {
        new nonPoliceXML().nonPolicePDF(args[0]);
    }

    public void nonPolicePDF(String date){
       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  
        try {
            //dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("nonPolcieXML-"+date+".maxplank.marx"));
            doc.getDocumentElement().normalize();
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList list = doc.getElementsByTagName("nonPoliceWebService");
            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    NodeList elementNodeList = element.getElementsByTagName("nonPoliceOperation");
                    String nonPoliceContent = element.getElementsByTagName("nonPoliceOperation").item(0).getTextContent();
                    new nonPolicePDF().nonPolicePrint(nonPoliceContent);
                    System.out.println(elementNodeList.getLength());
                }
            }
  
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
  
    }

    //TODO: Abonnement Des Abgeordnetenhauses
    public void nonPoliceAbonnementDesAbgeordnetenhauses(){
    }

    //TODO: Crime Mapping
    public void nonPoliceCrimeMapping(){

    }
       //TODO: Crime Mapping
       public void nonPolice(){


    

  
}
