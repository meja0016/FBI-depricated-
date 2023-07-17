package nonPolice;

public class nonPolice {

	public int add(int a,int b) {
		new nonPolice.nonPoliceBook().runTransaction();
		return a + b;
	}
	
	public String runTransaction(String instruction)  {
		new nonPolice.nonPoliceBook().runTransaction();
		return "1";
	}
}

