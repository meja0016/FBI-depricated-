/**
 * This program may be used, executed, copied, modified and distributed
 * without royalty for the purpose of developing, using, marketing, or distributing.
 **/
package com.ibm.was.wssample.sei.ping;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;


@WebService (endpointInterface="com.ibm.was.wssample.sei.ping.PingServicePortType", targetNamespace="http://com/ibm/was/wssample/sei/ping/", serviceName="PingService", portName="PingServicePort", wsdlLocation="WEB-INF/wsdl/Ping.wsdl")
public class PingServicePortImpl{

    public void pingOperation(PingStringInput parameter) {
    	System.out.println(">> SERVICE: SEI Ping JAX-WS Service: Request received.");
		if (parameter != null) {
			try {
				System.out.println(">> SERVICE: SEI Ping Input String '"+parameter.getPingInput()+"'");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}        
    }
}