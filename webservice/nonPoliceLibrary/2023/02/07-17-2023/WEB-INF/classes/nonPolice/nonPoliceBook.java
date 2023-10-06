package nonPolice;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Image;
import java.io.IOException;
import com.lowagie.text.Anchor;


public class nonPoliceBook{

	public static final String DEST = "nonPoliceBook.pdf";

	public static void main(String[] args){
		new nonPoliceBook().runTransaction();
	}
	
	public void runTransaction(){
		System.out.println("");

  try {
   Document doc = new Document();
   PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(DEST));
   Font font = new Font(Font.HELVETICA, 16, Font.BOLD, Color.BLACK);
   doc.open();
   Paragraph para = new Paragraph("nonPoliceBook: 		Medical Malpratice 07/14/2023", font);
   doc.add(para);
   

   Image image01 = Image.getInstance("readme_1.jpg");
   doc.add(image01);
   doc.newPage();
   para = new Paragraph("Table of Contents\n\n", font);
   doc.add(para);
   para = new Paragraph(" About the Author...............................Page 1");
   doc.add(para);
   para = new Paragraph("1. Executive Summary...............................Page 3");
   doc.add(para);
   para = new Paragraph("2. Operations......................................Page 4-5");
   doc.add(para);
   para = new Paragraph("  2.1   Operation 1................................Page 4");
   doc.add(para);
              para = new Paragraph("    2.1.1        Web Service?WSDL........................Page 4");
   Paragraph para2 = new Paragraph("    2.1.2        Application........................Page 4");
   doc.add(para);
   doc.add(para2);
   para = new Paragraph("  2.2 Operation 2................................Page 4");
   doc.add(para);
   doc.add(para);
   para = new Paragraph("    2.1.1        Web Service?WSDL........................Page 4");
para2 = new Paragraph("    2.1.2        Application........................Page 4");
doc.add(para);
doc.add(para2);
   para = new Paragraph("  2.3 Operation 3................................Page 4");
   doc.add(para);
   doc.add(para);
   para = new Paragraph("    2.1.1        Web Service?WSDL........................Page 4");
para2 = new Paragraph("    2.1.2        Application........................Page 4");
doc.add(para);
doc.add(para2);
   para = new Paragraph("  2.4 Operation 4................................Page 5");
   doc.add(para);
   doc.add(para);
   para = new Paragraph("    2.1.1        Web Service?WSDL........................Page 4");
para2 = new Paragraph("    2.1.2        Application........................Page 4");
doc.add(para);
doc.add(para2);
   para = new Paragraph("  2.5 Operation 5................................Page 6");
   doc.add(para);
   doc.add(para);
   para = new Paragraph("    2.1.1        Web Service?WSDL........................Page 4");
   para2 = new Paragraph("    2.1.2        Application........................Page 4");
doc.add(para);
doc.add(para2);
   para = new Paragraph("  2.6 Primative Text.............................Page 7");  
   doc.add(para);
   para = new Paragraph(" ");
   doc.add(para);
   para = new Paragraph("  3. Movie.............................Page 8");  
   doc.add(para);
   para = new Paragraph(" ");
   doc.add(para);
   para = new Paragraph("    Appendix............................Page 9");
   doc.add(para);
   doc.newPage();

      image01 = Image.getInstance("1.png");
   doc.add(image01);

   doc.newPage();


   para = new Paragraph("Operation 1:",font);
   doc.add(para);
   para = new Paragraph("Ammendment 1 US Constitution cosiderations for; This book describes Dr. Dr. Prof. Joachim Fishan who is refred to as 'Joe' the father of Jesus ( One of five or six Joe's of Jesus Petersson) during an engineering occupation of 32 jobs. The proffessor from Federal German Goverment Research Instutute Max-Plank for Quatum Physics, Newton (known formula F=ma), Albert Einstein K E=mc2, for atomic phyics and other mathematics (i.e. High School or Univerity f(x)=x2+2)");
   doc.add(para);
   para = new Paragraph(" ");
   doc.add(para);

   para = new Paragraph("The marketing identification Steve Jobs at a fine levle of 0.0001 and Markteting Identification of Tim Cook including during the iWatch launch Dr. Dre as aside 0.0001, violations in Labor Code, US.  The redcution fo business process management durin ~int32. The Facebook content items collection from ibm.dailer.apple.nonPoliceGarbage; in addtion using the Marketing Identificaton from Mark Zuckerberg.");
   doc.add(para);
   para = new Paragraph(" ");
   doc.add(para);
   para = new Paragraph("DEA violations include (Logical) crack and cocain; The algorithm for steve and tim including in specific remote phycological tests using identification of Tim (lastname) uknown and Steve Meiers. ");
   doc.add(para);
   para = new Paragraph("§Stalking");
   doc.add(para);
   para = new Paragraph("- gay book red, left look; right homless white walker- another black, stinking), <s>significant credit");
   doc.add(para);
   para = new Paragraph(" ");
   doc.add(para);
   Anchor anchor = new Anchor("Web Service.wsdl");
   anchor.setName("Web Service");
   anchor.setReference("https://ics2wsa.ic3.com/commerce/1.x/transactionProcessor/CyberSourceTransaction_1.207.wsdl");
   doc.add(anchor);
   image01 = Image.getInstance("fbi-internet-payments.png");
   doc.add(image01);
   doc.add(para);
   para = new Paragraph(" ");
   doc.add(para);
   para = new Paragraph(" ");
   doc.add(para);
   para = new Paragraph("Operation 2:",font);
   doc.add(para);
   para = new Paragraph("The Military birds-eve view of in 1994 Carl-Benz-Strasse, short:CAR, with American Military Residents for US President George W. Bush Jr Adminstration included Bill Sr and Jr with driving routes to Military Bases K-TOWN for buiness violations of WWI(World War I) and World War II, Price Sr and Jr.");
   doc.add(para);
   anchor.setName("Web Service");
   anchor.setReference("https://ics2wsa.ic3.com/commerce/1.x/transactionProcessor/CyberSourceTransaction_1.207.wsdl");
   doc.add(anchor);
   image01 = Image.getInstance("fbi-internet-payments.png");
   doc.add(image01);
   doc.add(para);
   doc.newPage();

   para = new Paragraph("Operation 3:",font);
   doc.add(para);
   para = new Paragraph("Stakling <s>Black Homeless</s>\nother:\ninterest town sinsheim\nOther:\ngorbacheve(seitz).swazenegger(rolad)\nother:\nrip\nother:\nst frances fracesco close\nbaptist names thomas francsco\nst frances hotel\n other:\nGravi");
   doc.add(para);
   anchor = new Anchor("Web Service.wsdl");
   anchor.setName("Web Service");
   anchor.setReference("https://ics2wsa.ic3.com/commerce/1.x/transactionProcessor/CyberSourceTransaction_1.207.wsdl");
   doc.add(anchor);
   image01 = Image.getInstance("fbi-internet-payments.png");
   doc.add(image01);
   para = new Paragraph(" ");
   doc.add(para);
   para = new Paragraph("Operation 4:",font);
   doc.add(para);
   anchor = new Anchor("Web Service.wsdl");
   anchor.setName("Web Service");
   anchor.setReference("https://ics2wsa.ic3.com/commerce/1.x/transactionProcessor/CyberSourceTransaction_1.207.wsdl");
   doc.add(anchor);
   image01 = Image.getInstance("fbi-internet-payments.png");
   doc.add(image01);
   StringBuffer str = new StringBuffer();
                str.append("D	4.0 Operations Systems (Dr. Decan Werner) Einstien/Werder/ WWI.MAINSTEREET(hauptstrasse,HOMICIDE:MERKEL(<s>werner</s>,IPX.JFK.(<s>mother</s>))");
                str.append("D	4.0 Newton Physics");
                str.append("          Ingo 1.0 (manuel)");
                str.append("D	4.0 Law  (in advance Pentaogn.Kalrsureh.PensylvaniaAve)");
                str.append("             Ingo 1.0 (manuel)");
                str.append("D 	4.0 Mathethatics (Dr. Roos) WWI Roosevelt");
                str.append("D/F	5.0 History King");
                str.append("D/F	5.0 Deutsch King");
                str.append("A	1.0 <s>Java Al-Kaida Dr Zimmermann Architect Hamburg</s>");
   para = new Paragraph(" ");
                str.append("George Bush: No child left behind");
                str.append("other: Ingo FBI:KIDDNAPPIGN <s>old dire baster wu tang clan</s>     CAR(Carl-Benz)");
                str.append("other: Ingo FBI:0.1investion.Gorbachev((woodstock,nonPolieDEA.lsint(<s>mdma</s>)");
                str.append("FBI:HOMCIDE:7 or8 Driver Licese Calfornia");
                str.append("Operation 5:");   
        para =  new Paragraph(str.toString());
   doc.add(para);
   doc.add(para);
   para = new Paragraph(" ");
   doc.add(para);

   para = new Paragraph("Operation 5:",font);
   doc.add(para);
                str = new StringBuffer();
                str.append(" ibm.damiler.hoover");
                str.append("GREEN vw toruge  (vggg.lisnt( <s>vw Volk German Volk</s>  WWI,WW2)");
                str.append(" roth.ibm.dmielr	RED cherrytree(urban6000,cannodale)");
                str.append("nonPolcieChurc.IPX(<s> golf hoover bag carrier</s>)");
                str.append(" GREEN(hoover)");
                str.append(" <s>audi(grey)	RED(ubrano,tim.kutscher)  ");
                str.append(" <s>bmw (grey)	light blue(bmw,joe)</s>	");
                str.append("  audi(grey)");
                str.append("</nonPoliceOperation>");
                str.append("<nonPoliceOperation>");
                str.append("1984 nonPolcieDEALogical('cocain','tim.cook;steve.job')");
                str.append("2015 nonPolcieDEALogical('cocain','tim.cook;steve.job')");
                str.append("nonPoliceChartLogical");
                str.append("[	str.append(']	-");
                str.append("[x] no");
                para =  new Paragraph(str.toString());
                anchor = new Anchor("Web Service.wsdl");
                anchor.setName("Web Service");
                anchor.setReference("https://ics2wsa.ic3.com/commerce/1.x/transactionProcessor/CyberSourceTransaction_1.207.wsdl");
                doc.add(anchor);
                doc.newPage();
                   anchor = new Anchor("Web Service.wsdl");
   anchor.setName("Web Service");
   anchor.setReference("https://ics2wsa.ic3.com/commerce/1.x/transactionProcessor/CyberSourceTransaction_1.207.wsdl");
   doc.add(anchor);
   image01 = Image.getInstance("fbi-internet-payments.png");
   doc.add(image01);
   para = new Paragraph("Operation 6:",font);
   doc.add(para);
   str = new StringBuffer();
   str.append(" ibm.damiler.hoover");
   str.append("ibm.daimler.pope.mary");
   str.append("!oli				nikloai		<s>I will steal again</s>");
   str.append("       marco					you can sit here while i evault with pizza what daneil and oli find so interesing");
   str.append("       daniel					you can sleep here while i ejaculate");
   str.append("      thomas					this is physics");
   str.append("?kadett(<s>google</s>)");
   str.append(" ibm.dmiler.*tophat.<s>maxplank.marx</s>");
   str.append("hamiltion PHYSICS(ott-hahn)");
   str.append("   nonPoliceTVLogical");
   str.append(" roth.(<s>harlod wathcing</s>)  MAINSTRERTE (haustrasse)	");
   str.append("            ATOMICEFACTORY(damileralle)");
   str.append("       <s>door right harry pottter (arton/lebene Systeter Stallon I will fuck you wife, fucked harld wofe)</s>");  
   para =  new Paragraph(str.toString());
   doc.add(para);
   anchor = new Anchor("Web Service.wsdl");
   anchor.setName("Web Service");
   anchor.setReference("https://ics2wsa.ic3.com/commerce/1.x/transactionProcessor/CyberSourceTransaction_1.207.wsdl");
   doc.add(anchor);
   image01 = Image.getInstance("fbi-internet-payments.png");
   doc.add(image01);

   doc.newPage();
   para = new Paragraph("4. Movie ",font);
   doc.add(para);
   
   para = new Paragraph("");

   image01 = Image.getInstance("fbi.1d8723.png");
   doc.add(image01);
   anchor = new Anchor("mp4");
   anchor.setName("mp4");
   anchor.setReference("1.mp4");
   doc.add(anchor);
   doc.add(para);

    doc.newPage();
   para = new Paragraph("Appendix ",font);
   doc.add(para);
   para = new Paragraph("");
   doc.add(para);
   para = new Paragraph("");
   doc.add(para);
   str = new StringBuffer();
   str.append("~int32                       32 Job Interviews and Consultantcies\n"); 
   str.append("roth.ibm.daimler.        Short code for business identication and responsiblity\n");   
   para =  new Paragraph(str.toString());
   doc.add(para);
   doc.newPage();

   image01 = Image.getInstance("07-14-2023/Slide1.PNG");
   doc.add(image01);
   
   doc.newPage();

   para = new Paragraph("11:30 AM/ 07/14/2023 Police Sirens",font);
   doc.add(para);
   para = new Paragraph("03:46 AM/ 07/14/2023 Police Sirens",font);
   doc.add(para);
   doc.close();
   writer.close();
  } catch ( Exception e) {

   e.printStackTrace();
  }
 }

}
