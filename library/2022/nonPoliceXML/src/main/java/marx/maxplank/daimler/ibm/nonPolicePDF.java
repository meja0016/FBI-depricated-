package marx.maxplank.daimler.ibm;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.font.PDFont;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class nonPolicePDF {

    public  void nonPolicePrint(String nonPoliceContent) {

    try{
        try (PDDocument doc = new PDDocument()) {

            PDPage myPage = new PDPage();
            doc.addPage(myPage);

            try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {

                cont.beginText();
                cont.setLeading(14.5f);

                cont.newLineAtOffset(25, 700);
                String line1 = "nonPolicePDF";      
                 cont.showText(line1);

                cont.newLine();
                line1 = nonPoliceContent;
                cont.showText(line1);
                cont.newLine();

  
                cont.endText();
            }
           
            doc.save("nonPolice.pdf");
        }
    
        
    }
    catch(Exception e){
            System.out.println("nonPoliceException:"+e.getMessage());
    }
}
}
