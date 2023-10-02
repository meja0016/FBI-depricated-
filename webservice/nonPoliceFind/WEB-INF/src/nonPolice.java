package nonPolice;

public class nonPolice {
	public int add(int a,int b) {
		return a + b;
	}
	
	/*
	 * speed of light m/s
	 */
	public float emc2(float mass) {
		float c = 299792458;
		return mass*(c*c);
	}
	
	public String runTransaction(String instruction)  {
		String ret = "";
		try {
		//Process process = Runtime.getRuntime().exec(instruction);
		//ret = process.getOutputStream().toString();
			ret+="dir";
		}
		catch(Exception e) {
			ret+= "Error: "+e.getMessage();
		}
		return ret;
	}
	public static void main(String[] args) {
		System.out.println("nonPolice().runTransaction(): \n");
		nonPolice nonPolice = new nonPolice();
		System.out.println(nonPolice.runTransaction("dir"));
				  float mass = 1000;
		//System.out.println("e=mc2 "+ mass + "kg "+nonPolice.emc2(mass)+" kj");
		
	}
}

