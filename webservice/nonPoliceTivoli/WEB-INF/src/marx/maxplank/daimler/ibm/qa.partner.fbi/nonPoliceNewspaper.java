import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class nonPoliceNewspaper {

   String message = "Robert nonPoliceNewpaper";	
   MessageUtil messageUtil = new MessageUtil(message);
   
   @Test
   public void testPrintMessage() {	
      System.out.println("nonPoliceNewspaper");    
      assertEquals(message, false);//messageUtil.printMessage());     
   }
}
