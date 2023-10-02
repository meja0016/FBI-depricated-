import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class nonPoliceUITest {

   String message = "WebSphere";	
   MessageUtil messageUtil = new MessageUtil(message);
   
   @Test
   public void testPrintMessage() {	
      System.out.println("Inside testPrintMessage()");    
      assertEquals(message, messageUtil.printMessage());     
   }
}
