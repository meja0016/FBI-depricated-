import java.awt.*;
//import javax.xml.ws.WebServiceRef;
//import helloservice.endpoint.HelloService;
//import helloservice.endpoint.Hello;

class First extends Frame{

First(){

Label  l1 = new Label ("nonPoliceSOALogial.<s>marx</s>");  
   l1.setBounds(60, 20, 100, 30);
add(l1);


//add(new ImageComponent("soa.jpg"));

Button b1=new Button("Model");
b1.setBounds(130,100,100,30);

  b1.addActionListener(new java.awt.event.ActionListener() {    
    public void actionPerformed (java.awt.event.ActionEvent e) {    
            System.out.println("nonPoliceHello");    
        }    
   });  

Button b2=new Button("Assemble");
b2.setBounds(130,140,100,30);
Button b3=new Button("Deploy");
b3.setBounds(130,180,100,30);
Button b4=new Button("Manage");
b4.setBounds(130,200,100,30);
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
First f=new First();

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
