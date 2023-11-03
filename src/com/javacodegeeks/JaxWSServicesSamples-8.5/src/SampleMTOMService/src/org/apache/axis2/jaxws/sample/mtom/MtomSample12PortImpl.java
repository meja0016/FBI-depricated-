/**
# COPYRIGHT LICENSE: 
# This information contains sample code provided in source code form. You may 
# copy, modify, and distribute these sample programs in any form without 
# payment to IBM for the purposes of developing, using, marketing or 
# distributing application programs conforming to the application programming
# interface for the operating platform for which the sample code is written. 
# Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE
# ON AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES, EXPRESS OR IMPLIED, 
# INCLUDING, BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF 
# MERCHANTABILITY, SATISFACTORY QUALITY, FITNESS FOR A PARTICULAR PURPOSE, 
# TITLE, AND ANY WARRANTY OR CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE 
# LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES
# ARISING OUT OF THE USE OR OPERATION OF THE SAMPLE SOURCE CODE. IBM HAS NO 
# OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS OR 
# MODIFICATIONS TO THE SAMPLE SOURCE CODE.
 **/

package org.apache.axis2.jaxws.sample.mtom;

import java.io.*;

@javax.jws.WebService (endpointInterface="org.apache.axis2.jaxws.sample.mtom.MtomSample12", 
		targetNamespace="http://org/apache/axis2/jaxws/sample/mtom/", 
		serviceName="MtomSampleService12", 
		portName="MtomSamplePort", 
		wsdlLocation="WEB-INF/wsdl/ImageDepot12.wsdl")
@javax.xml.ws.BindingType (value=javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_MTOM_BINDING)
public class MtomSample12PortImpl{

    public ImageDepot sendImage(ImageDepot input) {
    	System.out.println(">>MTOM SOAP 1.2 request received, type = "+input.getImageData().getContentType());
		return input;
    }
}