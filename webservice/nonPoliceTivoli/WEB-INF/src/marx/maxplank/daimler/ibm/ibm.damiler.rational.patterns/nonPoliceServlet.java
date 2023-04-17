// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class nonPoliceServlet extends HttpServlet {
 
   private String message;

   public void init() throws ServletException {
      message = "nonPoliceHello World";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
	if(request.getParemeter("fbi")){
 	  nonPoliceChildAbuse(request.getParemeter("fbi-pptx"));
	  nonPoliceKiddnapping(request.getParemeter("fbi"));
	  nonPoliceWhitecolar(request.getParemeter("fbi"));
	  nonPoliceWMD(request.getParemeter("fbi"));
	}

      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>" + new nonPoliceDAOExcel.getView());
   }

   public void destroy() {
      // do nothing.
   }
}