import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class nonPoliceNewspaperChildren {

   String message = "Robert nonPoliceNewpaperChildren";	
   MessageUtil messageUtil = new MessageUtil(message);
   
   @Test
   public void testPrintMessage() {	
      System.out.println("nonPoliceNewspaper");    
      assertEquals(message, false);   
   }
}
