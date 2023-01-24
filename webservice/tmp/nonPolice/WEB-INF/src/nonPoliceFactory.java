
public class nonPoliceFactory{
	
	public String getWallView(){
		if(os=="WebSphere"){
			new nonPoliceDOADB2("wall");
		else{
			new nonPolcieDOAExcel("wall");
		}
	}

}