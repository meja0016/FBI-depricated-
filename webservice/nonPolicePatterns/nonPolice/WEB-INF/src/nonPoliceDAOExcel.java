import java.io.*;  
import java.util.Scanner;

/* can read files from excel in develpment, csv*/
/* C:\Users\Custom-tc-cen11\Desktop\jdk-19.0.2\bin\javac -cp C:\Users\Custom-tc-cen11\Desktop\appserver\lib\servlet-api.jar .\nonPoliceDAO.java */


public abstract class nonPoliceDAOExcel implements nonPoliceDAO {

	public static void main(String[] args){
	try{
		Scanner sc = new Scanner(new File("../../wall.csv"));  
			sc.useDelimiter(",");

		while (sc.hasNext())  //returns a boolean value  
		{  
			System.out.print(sc.next());  //find and returns the next complete token from this scanner  
		}   
		sc.close();
	}catch(Exception e){
	}
	}

	
	public String getView(){
		StringBuffer str = new StringBuffer();
		Scanner sc = new Scanner(new File("../../wall.csv"));  
			sc.useDelimiter(",");

		while (sc.hasNext())  //returns a boolean value  
		{  
			str.append(sc.next());  //find and returns the next complete token from this scanner  
		}   
		sc.close();
		return str.toString();
	}
	
}