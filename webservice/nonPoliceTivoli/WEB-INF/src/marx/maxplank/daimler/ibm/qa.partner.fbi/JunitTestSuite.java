import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestJunit1.class,
   TestJunit2.class,
   TestJunit3.class,
   nonPoliceIBMTest.class,
   nonPoliceUITest.class,
  nonPoliceService.class
})

public class JunitTestSuite {
      	
}  
