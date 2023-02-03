import java.awt.*;    
  
public class nonPoliceUI extends Frame {    
  
   nonPoliceUI() {  
      Button b = new Button("nonPoliceButton");  
      b.setBounds(30,100,80,30);  
      add(b);    
      setSize(300,300);  
      setTitle("This is our basic AWT example");    
      setLayout(null);      
      setVisible(true);  
}    
public void nonPoliceLog(){
   System.out.println("nonPoliceUI");
}
  
public static void main(String args[]) {   
nonPoliceUI f = new nonPoliceUI();   
            f.nonPoliceLog(); 
 
}


}
