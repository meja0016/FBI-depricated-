/**
 * This program may be used, executed, copied, modified and distributed
 * without royalty for the purpose of developing, using, marketing, or distributing.
 **/
package com.ibm.was.wssample.sei.echo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@javax.jws.WebService (endpointInterface="com.ibm.was.wssample.sei.echo.EchoService12PortType", targetNamespace="http://com/ibm/was/wssample/sei/echo/", serviceName="EchoService12", portName="EchoService12Port", wsdlLocation="WEB-INF/wsdl/Echo12.wsdl")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class EchoService12PortImpl{

    public EchoStringResponse echoOperation(EchoStringInput parameter) {
    	System.out.println(">> SERVICE: SEI Echo SOAP12 Service: Request received.");
		String inputString = "Failed";
		if (parameter != null) {
			try {
				inputString = parameter.getEchoInput();
				System.out.println(">> SERVICE: SOAP12 Echo Input String '"+inputString+"'");				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		EchoStringResponse response = 
			new ObjectFactory().createEchoStringResponse();
		response.setEchoResponse("SOAP12==>>"+inputString);
        return response;
    }

}