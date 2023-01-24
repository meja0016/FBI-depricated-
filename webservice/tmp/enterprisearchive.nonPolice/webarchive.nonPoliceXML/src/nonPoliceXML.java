

public class nonPoliceXML{

public  static void main(String[] arg){
      new nonPoliceXML().newFile();
      try{
       Runtime.getRuntime().exec("javac *.java");
    }catch(Exception e){
       System.out.println(e.toString());
    }
}

public void newFile(){
  try{
   java.util.Date date = new java.util.Date();
   java.io.FileWriter file1 = new java.io.FileWriter("nonPoliceXML.marxplank.marx");
   String str = new String();
          str = "<nonPoliceWebService><nonPoliceOperation>nonPoliceHello</nonPoliceOperation></nonPoliceWebService>";
	             file1.write(str.toString());
	             file1.close();
   }catch(Exception e){}
}
/*
 * shell to java
 * str.append("#!/bin/bash");
 * str.append("echo -e \"<nonPoliceWebService>\n<nonPoliceOperation>\n</nonPoliceOperation>\n</nonPoliceWebService>\" > nonPoliceXML-$d.marxplank.marx");
 * new java.io.FileWriter().write(str.toString());
 * Runtime.getRuntime().exec("/tmp/tmp")
 */
}
