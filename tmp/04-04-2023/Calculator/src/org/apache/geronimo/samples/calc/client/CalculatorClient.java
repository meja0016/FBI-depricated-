package org.apache.geronimo.samples.calc.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory;

import org.apache.geronimo.samples.calc.CalculatorService;

/**
 * 
 * @author Lasantha Ranaweera
 *
 */
public class CalculatorClient {

	public static void main(String[] args) {
		
		int x,y = -1;
		
		try {
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
		} catch (Exception e) {
			System.out.println("Please provide two valid integer values as your command line arguments");
			System.out.println("Sample: java -jar CalcClient.jar 10 12");
			return;
		}
		
		try {
			String urlstr   = "http://localhost:8080/Calculator/calculator?wsdl";

			URL url =  new URL(urlstr);

			QName qname = new QName("urn:geronimo-samples","CalculatorServiceServlet");

			ServiceFactory factory = ServiceFactory.newInstance();
			Service  service = factory.createService(url, qname);
			
			CalculatorService calc = (CalculatorService)service.getPort(CalculatorService.class);
			
			int sum = calc.addition(x, y);
			
			System.out.println("Sum of "+x+" and "+y+" is "+sum);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
