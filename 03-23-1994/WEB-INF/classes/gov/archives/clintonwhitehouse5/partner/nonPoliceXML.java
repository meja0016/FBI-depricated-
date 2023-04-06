package gov.archives.clintonwhitehouse5.partner;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class nonPoliceXML extends HttpServlet {
 
   private String message;

   public void init() throws ServletException {
      message = "1991-4 nonPoliceNewpaper - Mikhail Gorbachev Resigns December 26th";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>");
   }

   public void destroy() {
      // do nothing.
   }
}
