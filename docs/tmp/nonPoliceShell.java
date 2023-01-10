import java.io.*;

public class nonPoliceShell {

        public static void main(String[] args) throws Exception{
                Runtime r= Runtime.getRuntime();
                Process p= r.exec("ls");
                InputStreamReader isr = new InputStreamReader(p.getInputStream());

                String line = "";
                BufferedReader rdr = new BufferedReader(isr);
                while((line = rdr.readLine()) != null) {
                  System.out.println(line);
                }

isr = new InputStreamReader(p.getErrorStream());
rdr = new BufferedReader(isr);
while((line = rdr.readLine()) != null) {
  System.out.println(line);
}
//rc = p.waitFor();  // Wait for the process to complete
        }

}
