/**
 * This program may be used, executed, copied, modified and distributed
 * without royalty for the purpose of developing, using, marketing, or distributing.
 **/
package com.ibm.was.wssample.sei.ping;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.ws.BindingType;


@javax.jws.WebService (endpointInterface="com.ibm.was.wssample.sei.ping.PingService12PortType", targetNamespace="http://com/ibm/was/wssample/sei/ping/", serviceName="PingService12", portName="PingService12Port", wsdlLocation="WEB-INF/wsdl/Ping12.wsdl")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class PingService12PortImpl{

    public void pingOperation(PingStringInput parameter) {
    	System.out.println(">> SERVICE: SEI Ping SOAP12 Service: Request received.");
		if (parameter != null) {
			try {
				System.out.println(">> SERVICE: SOAP12 Ping Input String '"+parameter.getPingInput()+"'");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
    }

}