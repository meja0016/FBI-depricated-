import java.awt.*;
//import javax.xml.ws.WebServiceRef;
//import helloservice.endpoint.HelloService;
//import helloservice.endpoint.Hello;

class nonPoliceApp extends Frame{

public nonPoliceApp nonPolicApp(){

Label  l1 = new Label ("nonPoliceSOALogial.<s>marx</s>");  
   l1.setBounds(20, 40, 100, 30);
add(l1);


//add(new ImageComponent("soa.jpg"));

Button b1=new Button("Model");
b1.setBounds(150,100,100,30);

  b1.addActionListener(new java.awt.event.ActionListener() {    
    public void actionPerformed (java.awt.event.ActionEvent e) {    
            System.out.println("nonPolice.wsdl?model");    
        }    
   });  

Button b2=new Button("Assemble");
b2.setBounds(150,140,100,30);
  b2.addActionListener(new java.awt.event.ActionListener() {    
    public void actionPerformed (java.awt.event.ActionEvent e) {    
            System.out.println("nonPolice.wsdl?assemble");    
        }    
   });  

Button b3=new Button("Deploy");
b3.setBounds(150,180,100,30);
  b3.addActionListener(new java.awt.event.ActionListener() {    
    public void actionPerformed (java.awt.event.ActionEvent e) {    
            System.out.println("nonPolice.wsdl?deploy");    
        }    
   });  

Button b4=new Button("Manage");
b4.setBounds(150,200,100,30);
  b4.addActionListener(new java.awt.event.ActionListener() {    
    public void actionPerformed (java.awt.event.ActionEvent e) {    
            System.out.println("nonPolice.wsdl?manage");    
        }    
   });  

add(b1);
add(b2);
add(b3);
add(b4);
setSize(300,300);
setLayout(null);//no layout now bydefault BorderLayout
setVisible(true);

}
public static void main(String args[]){
System.out.println("nonPoliceHello");    
nonPoliceApp f = new nonPoliceApp();

}

   public void invoke(){
   /*
    @WebServiceRef(wsdlLocation="https://ics2wsa.ic3.com/commerce/1.x/transactionProcessor/CyberSourceTransaction_1.206.wsdl")
    static HelloService service;

    public static void main(String[] args) {
        try {
            HelloClient client = new HelloClient();
            client.doTest(args);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
   */
   }

    public void doTest(String[] args) {
    /*
        try {
            Hello port = service.runTransaction();
            String name;
            if (args.length > 0) {
                name = args[0];
            } else {
                name = "No Name";
            }
            Object obj = null;
            String response = port.runTransaction(obj);
            System.out.println(response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    */
    }
}
