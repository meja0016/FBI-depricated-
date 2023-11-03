
package com.ibm.was.wssample.sei.echo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for echoStringResponse element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="echoStringResponse">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="echoResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "echoResponse"
})
@XmlRootElement(name = "echoStringResponse")
public class EchoStringResponse {

    @XmlElement(required = true)
    protected String echoResponse;

    /**
     * Gets the value of the echoResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEchoResponse() {
        return echoResponse;
    }

    /**
     * Sets the value of the echoResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEchoResponse(String value) {
        this.echoResponse = value;
    }

}
