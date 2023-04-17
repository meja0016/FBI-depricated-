
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
 
public class TestJunit3 {
  @BeforeClass
  public static void setup() {
  }
 
  @Before
  public void setupThis() {
  }
 
  @Test
  public void method() {
    org.junit.Assert.assertTrue(true);
  }
 
  @After
  public void tearThis() {
  }
 
  @AfterClass
  public static void tear() {
  }
}
