

import java.io.*;
import org.junit.*;
import java.util.Scanner;

public class nonPoliceIBM {

       public static void main(String[] args) throws Exception{
		String option="";
		try{
		       option=args[0];
     	               nonPoliceIBM ibm = new nonPoliceIBM();
		       if(option.equals("start")){
				  ibm.nonPoliceFile();
				  ibm.nonPoliceStart();
				  ibm.nonPoliceContextPathDefault();
		       }else if(option.equals("reload")){
				ibm.nonPoliceContextPath();
				ibm.nonPoliceReload();
		      }else if(option.equals("stop")){
				ibm.nonPoliceStop();	
		      }else{
			    System.out.println("Help");
		       }
		}catch(Exception e){
		   System.out.println(e.getMessage());
		}	
       }

       public void nonPoliceContextPathDefault() throws Exception{
	   new File("tmp/conf.d").delete();
           Runtime r= Runtime.getRuntime();
	           r.exec("mkdir -p tmp/conf.d/");	
           BufferedWriter writer = new BufferedWriter(new FileWriter("tmp/conf.d/default.conf"));
           writer.write("server {listen 80;listen  [::]:80; server_name  w-nginx-1; location / { root  /usr/share/nginx/html/; }}");
    	   writer.close();
	}

	public void nonPoliceStop(){
 	try{
		//the count of running virtual instances = 0
		Process ps = Runtime.getRuntime().exec("docker ps | wc -l");
                Scanner s = new Scanner(ps.getInputStream()); 
		Integer count= new Integer(s.next());

		org.junit.Assert.assertEquals(0,count.intValue());


		Runtime r= Runtime.getRuntime();
				r.exec("docker stop w-websphere-1");
				r.exec("docker stop w-nginx-1");
				r.exec("docker stop w-mq-1");
		}catch(Exception e){


		}
	}
        public void nonPoliceStart(){
	  try{	
            System.out.println("Starting IBM WebSphere");
	    Runtime r= Runtime.getRuntime();
	    Process p = r.exec("docker-compose -p w -f tmp/ibm up  --remove-orphans");
          
	    InputStreamReader isr = new InputStreamReader(p.getInputStream());
            String line = "";
            BufferedReader rdr = new BufferedReader(isr);
                while((line = rdr.readLine()) != null) {
                  System.out.println(line);
                }

	  }catch(Exception e){
		System.out.println(e.getMessage());
	  }
	}

       public void nonPoliceFile() throws Exception{

				StringBuffer str = new StringBuffer();
					str.append("version: '3.9' \n");
					str.append("services: \n");
					str.append(" db2: \n");
					str.append("  image: ibmcom/db2\n");
					str.append("  environment:\n");
					str.append("    DB2INSTANCE: db2inst1\n");
					str.append("    DB2INST1_PASSWORD: password\n");
					str.append("    LICENSE: accept\n");
					str.append("    DBNAME: nPolice\n");
					str.append("  privileged: true\n");
					str.append("  command: db2start\n");
					str.append("  volumes:\n");
					str.append("    - ./database:/database\n");
					str.append("  networks:\n");
					str.append("   - backend\n");
					str.append(" websphere:\n");
					str.append("  image: ibmcom/websphere-traditional\n");
					str.append("  privileged: true\n");
					str.append("  links:\n");
					str.append("   - db2\n");
					str.append("  networks:\n");
					str.append("    - frontend\n");
					str.append("    - backend\n");
					str.append(" nginx:\n");
					str.append("  image: nginx\n");
					str.append("  privileged: true\n");
					str.append("  ports:\n");
					str.append("    - 80:80\n");
					str.append("  volumes:\n");
					str.append("    - tmp/conf.d/:/etc/nginx/conf.d/\n");
					str.append("  networks:\n");
					str.append("     - frontend\n");
					str.append(" mq:\n");
					str.append("  image: ibmcom/mq\n");
					str.append("  privileged: true\n");
					str.append("  environment:\n");
					str.append("   LICENSE: accept\n");
					str.append("networks:\n");
					str.append("   frontend:\n");
					str.append("   backend:\n");

               BufferedWriter writer = new BufferedWriter(new FileWriter("tmp/ibm"));
                              writer.write(str.toString()); 
                              writer.close();
}

/**
 * 
 */
public void nonPoliceContextPath() throws Exception{

StringBuffer str = new StringBuffer();
str.append("server {\n");
str.append("    listen       80;\n");
str.append("listen  [::]:80;\n");
str.append("server_name  w-nginx-1;\n");
str.append("   \n");
str.append(" location / {\n");
str.append("     root  /usr/share/nginx/html/; \n");
str.append("}\n");
str.append("\n");
str.append("location /ibm/console{\n");
str.append("proxy_set_header X-Forwarded-Host \\$host;\n");
str.append("proxy_set_header X-Forwarded-Server \\$host;\n");
str.append("proxy_set_header X-Forwarded-For \\$host;\n");
str.append("proxy_pass https://w-websphere-1:9043/ibm/console;\n");
str.append("}\n");
str.append("\n");
str.append("location /nonPoliceXML {\n");
str.append("proxy_set_header X-Forwarded-Host \\$host;\n");
str.append("proxy_set_header X-Forwarded-Server \\$host;\n");
str.append("proxy_set_header X-Forwarded-For \\$host;\n");
str.append("proxy_pass http://w-websphere-1:9080/nonPoliceXML;\n");
str.append("}\n");
str.append("location /Service {\n");
str.append("proxy_set_header X-Forwarded-Host \\$host;\n");
str.append("proxy_set_header X-Forwarded-Server \\$host;\n");
str.append("proxy_set_header X-Forwarded-For \\$host;\n");
str.append("proxy_pass http://w-websphere-1:9080/Service;\n");
str.append("}\n");
str.append("}\n");
          
 BufferedWriter writer = new BufferedWriter(new FileWriter("tmp/conf.d/default.conf"));
 writer.write(str.toString()); 
 writer.close();
}

public void nonPoliceReload() throws Exception {
	Runtime r= Runtime.getRuntime();
	r.exec("docker exec w-websphere-1 cat tmp/PASSWORD > tmp/PASSWORD");
	StringBuffer str = new StringBuffer();
		     str.append("alias password=\"cat tmp/PASSWORD\"");
        	         str.append("docker exec w-nginx-1 echo \"<br>nonPoliceHello<br><a href=/ibm/console>IBM WebSphere</a><br>Username: wsadmin, Password: ${password}\" >  tmp/conf.d/index.html; ");
                     str.append("docker cp tmp/conf.d/index.html w-nginx-1:/usr/share/nginx/html/index.html"); 
					 str.append("docker exec w-nginx-1 nginx -s reload >/dev/null 2>&1");
                     str.append("docker exec w-websphere-1 tail  /opt/IBM/WebSphere/AppServer/profiles/AppSrv01/logs/server1/startServer.log");
        str.append("docker exec w-websphere-1 tail  /opt/IBM/WebSphere/AppServer/profiles/AppSrv01/logs/server1/serverStatus.log");
 BufferedWriter writer = new BufferedWriter(new FileWriter("tmp/ibm.sh"));
 writer.write(str.toString());
 writer.close();
 r.exec("chmod 755 tmp/ibm.sh");
 r.exec("tmp/ibm.sh");
}

}
