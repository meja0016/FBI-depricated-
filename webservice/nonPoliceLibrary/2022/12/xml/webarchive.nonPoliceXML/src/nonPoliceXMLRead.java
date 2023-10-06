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

public class nonPoliceXMLRead {


  public static void main(String[] args) {
      String filename = args[0];
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      try {

          DocumentBuilder db = dbf.newDocumentBuilder();
          Document doc = db.parse(new File(filename));
          doc.getDocumentElement().normalize();

          System.out.println(doc.getDocumentElement().getNodeName());
          NodeList list = doc.getElementsByTagName("nonPoliceWebService");

          for (int temp = 0; temp < list.getLength(); temp++) {
              Node node = list.item(temp);
              if (node.getNodeType() == Node.ELEMENT_NODE) {
                  Element element = (Element) node;
		  NodeList nonPoliceOperations  = doc.getElementsByTagName("nonPoliceOperation");
                   for (int i = 0; i < nonPoliceOperations.getLength(); i++) {
                      String nonPoilceOperation= element.getAttribute("nonPoliceOperation");
                      String nonPoliceCode = element.getElementsByTagName("nonPoliceOperation").item(0).getTextContent();
                      System.out.println("Current Element :" + node.getNodeName());
                      System.out.println("WebService Operation : " + nonPoilceOperation);
                      System.out.println("nonPoliceCode: " + nonPoliceCode);
                                   new nonPoliceXMLRead().newClass(nonPoliceCode);
		   }
              }
          }

      } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }

  }

  public void newClass(String name){
	  try{
	     java.io.FileWriter file = new java.io.FileWriter(name+".java");
                 StringBuffer str = new StringBuffer();
                     str.append("public class "+name+"{");
		     str.append("}");
                     file.write(str.toString());
                     file.close();
   }catch(Exception e){}
  }  

}

