//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.11.29 at 04:15:58 AM IST 
//


package com.blog.samples.webservices.accountservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.blog.samples.webservices.Account;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CurrencyRes" type="{http://webservices.samples.blog.com}Account"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "currencyRes"
})
@XmlRootElement(name = "CurrencyResponse")
public class CurrencyResponse {

    @XmlElement(name = "CurrencyRes", required = true)
    protected Account currencyRes;

    /**
     * Gets the value of the currencyRes property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getCurrencyRes() {
        return currencyRes;
    }

    /**
     * Sets the value of the currencyRes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setCurrencyRes(Account value) {
        this.currencyRes = value;
    }

}