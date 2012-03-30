package com.ericsson.ma;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XMLAddNewNode {
    Logger logger = LoggerFactory.getLogger(XMLAddNewNode.class);
    
    void addNewNode(String userInput) {
        logger.trace("FUNCTION ENTER: addNewNode add new node in XML file");
        String[] personInfo = userInput.split("/");
        if(!(Pattern.compile("[0-9]*").matcher(personInfo[1]).matches())){
            logger.error("ERROR:phone number must be digitals!");
            return;
        }

        
        try{
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document file = builder.parse(new File("addressBook.xml"));
            file.normalize();
            logger.debug("DEBUG: addNewNode open file addressBook.xml");
            
            file.getDocumentElement().appendChild(file.createTextNode("  "));
            Element newNode = file.createElement("name");
            Text textMsg = file.createTextNode(personInfo[0]);
            newNode.appendChild(textMsg);
            file.getDocumentElement().appendChild(newNode);
            file.getDocumentElement().appendChild(file.createTextNode("\n  "));
            logger.debug("DEBUG: addNewNode add node name");
            
            Element newNodePhone = file.createElement("phone");
            textMsg = file.createTextNode(personInfo[1]);
            newNodePhone.appendChild(textMsg);
            file.getDocumentElement().appendChild(newNodePhone);
            file.getDocumentElement().appendChild(file.createTextNode("\n  "));
            logger.debug("DEBUG: addNewNode add node phone");
            
            Element newNodeAdress = file.createElement("adress");
            textMsg = file.createTextNode(personInfo[2]);
            newNodeAdress.appendChild(textMsg);
            file.getDocumentElement().appendChild(newNodeAdress);
           
            logger.debug("DEBUG: addNewNode add node adress");
            TransformerFactory tFactory =TransformerFactory.newInstance();
            Transformer transformer;
            transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource source = new DOMSource(file);
            StreamResult result = new StreamResult(new java.io.File("addressBook.xml"));
            transformer.transform(source, result);
            }
        catch(SAXException e){
            e.printStackTrace();
            logger.error("ERROR: addNewNode error happened in SAE, fail to create DocumentBuilder");
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
                logger.error("ERROR: addNewNode error happened in ParseConfiguration, fail to create Doc");
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("ERROR: addNewNode error happened in IO");
                    } catch (TransformerConfigurationException e) {
                        e.printStackTrace();
                        logger.error("ERROR: addNewNode error happened in TransformerConfiguration");
                        } catch (TransformerException e) {
                            e.printStackTrace();
                            logger.error("ERROR: addNewNode error happened in Transformer");
                            }
        }
    }
