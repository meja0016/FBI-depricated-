
public class nonPoliceFactory{
	
	public String nonPoliceWMD(){

	}
	public String nonPoliceKiddnapping(){
		
	}

	public String getWallView(){
		if(os=="WebSphere"){
			new nonPoliceDOADB2("wall");
		else{
			new nonPolcieDOAExcel("wall");
		}
	}

}