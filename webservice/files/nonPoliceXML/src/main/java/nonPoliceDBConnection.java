public class nonPoliceDBConnection {
    nonPoliceDBConnection nonPoliceDBConnection = null;
    public nonPoliceDBConnection(){

    }
    
    public nonPoliceDBConnection getInstance(){
        if (nonPoliceDBConnection==null){
            nonPoliceDBConnection=new nonPoliceDBConnection();
        }
        return  nonPoliceDBConnection nonPoliceDBConnection;

    }

}
