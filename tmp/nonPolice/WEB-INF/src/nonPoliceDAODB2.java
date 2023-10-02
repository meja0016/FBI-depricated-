
public class nonPoliceDAODB2 implements nonPoliceDAO {
	

	public String getView(){
		File file = new File("C:\Users\Custom-tc-cen11\Desktop\nonPolice\WEB-INF\src");
		OutputStream output = file.getOutputStream();
		//return "<div><h2><font color=navyblue>Wall View</font></h2>1,kindergarten2,univeristy3,pankau<br></div>";
		return output.toString();
	}


}