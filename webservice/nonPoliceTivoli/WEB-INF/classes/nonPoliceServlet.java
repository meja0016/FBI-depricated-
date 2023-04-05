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
                  File file = new File("/tmp/nonPoliceShell.sh");
                        file.createNewFile();
                  FileWriter output = new FileWriter("/tmp/nonPoliceShell.sh");
                  StringBuffer sb = new StringBuffer();
                        sb.append("#/bin/bash");
                        sb.append("echo hello > /tmp/text.txt");
                             output.write(sb.toString());
                        output.close();
        }
          Runtime.getRuntime().exec(new String[] {"sh",  "-c","./nonPoliceShell.sh"});

        File file = new File("/tmp/text.txt");
        FileReader fr=new FileReader(file);   
        BufferedReader br=new BufferedReader(fr);
        String line="";
        while((line=br.readLine())!=null)  {
          out.println("<h1>" + line + "</h1>"); 
        }

        file = new File("/tmp/text2.txt");
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        while((line=br.readLine())!=null)  {
          out.println("<h1>" + line + "</h1>");
        }

    }catch(Exception e){
        System.out.println(e.getMessage());
        out.println(e.getMessage());
        }
      response.setContentType("text/html");

   }


   public void destroy() {
   }
}
