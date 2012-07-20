package com.ericsson.ma;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XMLAddNewNode {
    private static final Logger logger = LoggerFactory.getLogger(XMLAddNewNode.class);

    public void addNewNode(String input) throws TransformerFactoryConfigurationError, IOException {
        logger.trace("FUNCTION ENTER: addNewNode add new node in XML file");
        String[] person = convertInputToPerson(input);
        
        if(!(isPhoneNumString(person[1]))){
            logger.error("ERROR:phone number must be digitals!");
            return;
        }        
        try{
            Document file = openFile("addressBook.xml");
            addOnePerson(file, person);            
            writeFile(file);
            }
        catch(SAXException e){
            logger.error("ERROR: addNewNode error happened in SAE, fail to create DocumentBuilder");
            } catch (ParserConfigurationException e) {
                logger.error("ERROR: addNewNode error happened in ParseConfiguration, fail to create Doc");
                } 
    }
    
    private String[] convertInputToPerson(String input){
        String[] person = input.split("/");
        return person; 
        }
    
    private boolean isPhoneNumString(String string){
        Util util = new Util();
        return util.isNum(string);
        }
    
    private Document openFile(String fileName) throws SAXException, IOException, ParserConfigurationException{
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        builder = dFactory.newDocumentBuilder();          
        Document file = builder.parse(new File(fileName));
        file.normalize();
        logger.debug("DEBUG: addNewNode open file addressBook.xml");
        return file;
    }
    
    private void addOnePerson(Document file, String[] person){
        file.getDocumentElement().appendChild(file.createTextNode("  "));
        addOneElement(file, person, "name");
        logger.debug("DEBUG: addNewNode add node name");        
        addOneElement(file, person, "phone");
        logger.debug("DEBUG: addNewNode add node phone");        
        addOneElement(file,person,"address");           
        logger.debug("DEBUG: addNewNode add node adress");
    }
    
    private void addOneElement(Document file, String[] person,String elementName){
        Element newNode = file.createElement(elementName);
        Text textMsg = file.createTextNode(person[2]);
        newNode.appendChild(textMsg);
        file.getDocumentElement().appendChild(newNode);
        file.getDocumentElement().appendChild(file.createTextNode("\n  "));
        }
    
    private void writeFile(Document file){
        try {
            TransformerFactory tFactory =TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource source = new DOMSource(file);
            StreamResult result = new StreamResult(new java.io.File("addressBook.xml"));
            transformer.transform(source, result);
            } catch (TransformerException e) {
            logger.error("ERROR: addNewNode error happened in Transformer");
            }
        }    
    }
