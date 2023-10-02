import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class nonPoliceServlet extends HttpServlet {
   private String message;

   public void init() throws ServletException {
      message = "nonPoliceHelloWorld";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>");
   }

   public void destroy() {
   }
}

/*
 * 
 * @DataSourceDefinition(
        name         = "java:comp/env/jdbc/db2",
        className    = "com.ibm.db2.jcc.DB2DataSource",
        databaseName = "SAMPLEDB",
        serverName   = "localhost",
        portNumber   = 50000,
        properties   = { "driverType=4" },
        user         = "user1",
        password     = "pwd1"
        )

public class MyServlet extends HttpServlet {

    @Resource(lookup="java:comp/env/jdbc/db2")
    DataSource ds;
 */