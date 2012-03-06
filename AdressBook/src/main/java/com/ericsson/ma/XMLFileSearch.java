package com.ericsson.ma;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class XMLFileSearch {
	Logger logger = LoggerFactory.getLogger(XMLFileSearch.class);
	
	PersonInfo searchFile(String userInput) {
		logger.trace("FUNCTION ENTER: searchFile search person info in address book");
		PersonInfo person = new PersonInfo();
		try{
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document file = builder.parse(new File("addressBook.xml")); 
			
			NodeList nodeTextName = file.getElementsByTagName("name");
			NodeList nodeTextPhone = file.getElementsByTagName("phone");
			NodeList nodeTextAdress = file.getElementsByTagName("adress");
			
			System.out.println(nodeTextPhone.getLength());
			for(int index = 0 ; index<nodeTextPhone.getLength() ; ++index){
				Node nodePhone = nodeTextPhone.item(index).getFirstChild();
				String phoneNumber = nodePhone.getNodeValue();
				if(phoneNumber.contains(userInput)){
					logger.debug("DEBUG: searchFile match found");
					Node nodeName = nodeTextName.item(index).getFirstChild();
					String name = nodeName.getNodeValue();
					person.setName(name);
					Node nodeAdress = nodeTextAdress.item(index).getFirstChild();
					String adress = nodeAdress.getNodeValue();
					person.setAdress(adress);
					person.setPhoneNumber(phoneNumber);
					return person;
				}
			}
			logger.debug("DEBUG: searchFile no match found");
			return null;
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
			logger.error("ERROR: searchFile error happened in ParserConfiguration");
			return null;
		} 
//		PersonInfo personFound = new PersonInfo();
        catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("ERROR: searchFile error happened in SAX");
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("ERROR: searchFile error happened in IO");
			return null;
		}
	}
}
