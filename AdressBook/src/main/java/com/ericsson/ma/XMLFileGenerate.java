package com.ericsson.ma;

import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class XMLFileGenerate{
	Logger logger = LoggerFactory.getLogger(XMLFileGenerate.class);
	
	void generateXMLFile(){
		logger.trace("FUNCTION ENTER: XMLFileGenerate generate XML file");
		try{
			FileWriter file = new FileWriter("addressBook.xml");
			file.write("<person>"+"\n");
			file.write("</person>");
			file.close();
			logger.debug("DEBUG: XMLFileGenerate successfully create new file addressBook.xml");
		}
		catch(IOException e){
			e.printStackTrace();
			logger.error("ERROR: XMLFileGenerate fail to create new file addressBook.xml");
		}
	}
}
