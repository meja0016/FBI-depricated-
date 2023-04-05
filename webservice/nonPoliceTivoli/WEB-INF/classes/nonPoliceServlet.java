import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class nonPoliceServlet extends HttpServlet {

   public void init() throws ServletException {
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try{
        switch(request.getParameter("get")){
                case "assemble":
                  FileWriter output = new FileWriter("/tmp/nonPoliceShell.sh");
                  StringBuffer sb = new StringBuffer();
                        sb.append("#/bin/bash");
                        sb.append("echo hello > /tmp/text.txt");
                             output.write(sb.toString());
                        output.close();
        }
        Runtime.getRuntime().exec(new String[] {"sh",  "-c","echo > /tmp/text.txt; /tmp/nonPoliceShell.sh   > /tmp/text.txt"});


        File file = new File("/tmp/text.txt");
        FileReader fr=new FileReader(file);   
        BufferedReader br=new BufferedReader(fr);
        StringBuffer sb=new StringBuffer();  
        String line;  
        while((line=br.readLine())!=null)  {
          out.println("<h1>" + line + "</h1>"); 
        }
    }catch(Exception e){
        }
      response.setContentType("text/html");

   }


   public void destroy() {
   }
}
