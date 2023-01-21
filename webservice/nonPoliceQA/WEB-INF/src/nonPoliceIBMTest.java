import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class nonPoliceIBMTest {

   String message = "WebSphere";	
   MessageUtil messageUtil = new MessageUtil(message);
   
   @Test
   public void testPrintMessage() {	
      System.out.println("Inside testPrintMessage()");    
      assertEquals(message, messageUtil.printMessage());     
   }

   /*
    * ibm rational rose patterns
    */
@Test
public void testAdapter(){}
@Test
public void testBridgeg(){}
@Test
public void testComposite(){}
@Test
public void testDecorator(){}
@Test
public void testFacade(){}
@Test
public void testFlyweight(){}
@Test
public void testProxy(){}
@Test
public void testChainOfResponsibility(){}
@Test
public void testCommandv(){}
@Test
public void testInterpreter(){}
@Test
public void testIterator(){}
@Test
public void testMediator(){}
@Test
public void testMemento(){}
@Test
public void testObserver(){}
@Test
public void testStrategy(){}
@Test
public void testTemplate(){}
@Test
public void testVisitor(){}

/*
 * ibm j2eee patterns
 * */

@Test
public void testInterceptingFilter(){}
@Test
public void testFrontController(){}
@Test
public void testApplicationControllerv(){}
@Test
public void testViewHelper(){}
@Test
public void testCompositeView(){}
@Test
public void testContextObject(){}
@Test
public void testDataTransferObject(){}
@Test
public void testServiceLocator(){}
@Test
public void testBusinessDelegate(){}
@Test
public void testConverter(){}
@Test
public void testTransferObjectAssembler(){}
@Test
public void testValueListHandler(){}
@Test
public void testDataAccessObject(){}
@Test
public void testServiceActivator(){}

}
