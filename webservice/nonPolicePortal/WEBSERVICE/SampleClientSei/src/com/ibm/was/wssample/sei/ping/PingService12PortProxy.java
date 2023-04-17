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
package com.ibm.was.wssample.sei.ping;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

public class PingService12PortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private PingService12 _service = null;
        private com.ibm.was.wssample.sei.ping.PingService12PortTypeClient _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            _service = new PingService12();
            initCommon();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new PingService12(wsdlLocation, serviceName);
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getPingService12Port();
        }

        public com.ibm.was.wssample.sei.ping.PingService12PortTypeClient getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if(_dispatch == null ) {
                QName portQName = new QName("http://com/ibm/was/wssample/sei/ping/", "PingService12Port");
                _dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);

                String proxyEndpointUrl = getEndpoint();
                BindingProvider bp = (BindingProvider) _dispatch;
                String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
                if(!dispatchEndpointUrl.equals(proxyEndpointUrl))
                    bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
            }
            return _dispatch;
        }

        public String getEndpoint() {
            BindingProvider bp = (BindingProvider) _proxy;
            return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
        }

        public void setEndpoint(String endpointUrl) {
            BindingProvider bp = (BindingProvider) _proxy;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

            if(_dispatch != null ) {
            bp = (BindingProvider) _dispatch;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
            }
        }
    }

    public PingService12PortProxy() {
        _descriptor = new Descriptor();
    }

    public PingService12PortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public void pingOperation(PingStringInput parameter) {
        _getDescriptor().getProxy().pingOperation(parameter);
    }

}