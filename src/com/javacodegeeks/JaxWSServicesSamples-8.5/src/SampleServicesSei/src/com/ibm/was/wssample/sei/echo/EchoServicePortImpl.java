/**
 * This program may be used, executed, copied, modified and distributed
 * without royalty for the purpose of developing, using, marketing, or distributing.
 **/
package com.ibm.was.wssample.sei.echo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;


@WebService(endpointInterface="com.ibm.was.wssample.sei.echo.EchoServicePortType", targetNamespace="http://com/ibm/was/wssample/sei/echo/", serviceName="EchoService", portName="EchoServicePort", wsdlLocation="WEB-INF/wsdl/Echo.wsdl")
public class EchoServicePortImpl{

    public EchoStringResponse echoOperation(EchoStringInput parameter) {
    	System.out.println(">> SERVICE: SEI Echo JAX-WS Service: Request received.");
		String inputString = "Failed";
		if (parameter != null) {
			try {
				inputString = parameter.getEchoInput();
				System.out.println(">> SERVICE: SEI Echo Input String '"+inputString+"'");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		EchoStringResponse response = 
			new ObjectFactory().createEchoStringResponse();
		response.setEchoResponse("JAX-WS==>>"+inputString);
        return response;
    }
}