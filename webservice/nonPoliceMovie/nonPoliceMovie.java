import java.io.*;

public class nonPoliceMovie{

public static void main(String[] args)throws Exception{
	System.out.println("Movie Voice: https://1d8723.github.io/FBI/docs/library//07-24-2023/");
	  new nonPoliceMovie().t();
	
	//new DB2().getProjects();
}

public void t() throws Exception{
	for ( int i=0;i<10;++i){
	File original = new File("nonPoliceClip.png");
	File copied = new File("nonPoliceClip-"+i+".png");
    try (
      InputStream in = new BufferedInputStream(new FileInputStream(original));
      OutputStream out = new BufferedOutputStream(new FileOutputStream(copied))) {
        byte[] buffer = new byte[1024];
        int lengthRead;
        while ((lengthRead = in.read(buffer)) > 0) {
            out.write(buffer, 0, lengthRead);
            out.flush();
        }
    }
}

}

}
