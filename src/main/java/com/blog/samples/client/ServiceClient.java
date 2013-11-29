package com.blog.samples.client;

import java.io.StringReader;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.WebServiceMessageSender;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ServiceClient {
  public static void main(String[] args) throws Exception {
	  
	  
	double exchangeValue;
	
    String xmlRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        + "<hs:CurrencyRequest xmlns:hs=\"http://com/blog/samples/webservices/accountservice\">"
        + "<hs:Currency>EUR</hs:Currency>" 
	+"<hs:Value>0</hs:Value>" 
	+ "</hs:CurrencyRequest>";

    String wsdlUrl = "http://localhost:8080/spring-webservices-sample/endpoints/AccountDetailsService.wsdl";
    StreamSource requestMessage = new StreamSource(new StringReader(xmlRequest));
    StreamResult responseMessage = new StreamResult(new File("file.xml"));
    WebServiceTemplate template = new WebServiceTemplate();
    template.sendSourceAndReceiveToResult(wsdlUrl, requestMessage,responseMessage);

try {
	 
	File fXmlFile = new File("file.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

	
	doc.getDocumentElement().normalize();

	

	NodeList nList = doc.getElementsByTagName("ns3:CurrencyRes");



	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(0);
	
		
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			exchangeValue = Double.parseDouble(eElement.getElementsByTagName("ns2:Value").item(0).getTextContent());
			System.out.println(exchangeValue);
		
		}
	}
   } catch (Exception e) {
	e.printStackTrace();
   }
 }
}