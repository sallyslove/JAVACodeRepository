package com.lynn.java.addressbook.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class XmlUtil {
    private static final Logger logger = LoggerFactory.getLogger(XmlUtil.class);

    public static void generateNewXmlFile(String fileName, String rootNode) throws IOException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dFactory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElement(rootNode);
        doc.appendChild(root);
        XmlUtil.writeXmlFile(doc, fileName);
    }

    public static Document openXmlFile(String fileName) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dFactory.newDocumentBuilder();
        Document file = builder.parse(new File(fileName));
        file.normalize();
        logger.debug("DEBUG: XmlUtil open a file.");
        return file;
    }

    public static void addNode(Document file, String text, String nodeName) {
        file.getDocumentElement().appendChild(file.createTextNode("  "));
        addOneElement(file, text, nodeName);
    }

    private static void addOneElement(Document file, String text, String elementName) {
        Element newNode = file.createElement(elementName);
        Text textMsg = file.createTextNode(text);
        newNode.appendChild(textMsg);
        file.getDocumentElement().appendChild(newNode);
        file.getDocumentElement().appendChild(file.createTextNode("\n  "));
    }

    public static List<String> parseXmlFile(String nodeName, Document file) {
        List<String> nodeTexts = new ArrayList<String>();
        NodeList nodes = file.getElementsByTagName(nodeName);
        for (int index = 0; index < nodes.getLength(); ++index) {
            Node node = nodes.item(index).getFirstChild();
            String nodeText = node.getNodeValue();
            nodeTexts.add(nodeText);
        }
        return nodeTexts;
    }

    public static void writeXmlFile(Document file, String fileName) throws TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(file);
        StreamResult result = new StreamResult(new File(fileName));
        transformer.transform(source, result);
    }
    
    public static void xmlErrorHandler(Exception e) {
        if(e instanceof IOException){
            logger.error("ERROR: error happened in IO");
        } else if (e instanceof ParserConfigurationException){
            logger.error("ERROR: error happened in ParseConfiguration");
        } else if(e instanceof TransformerException){
            logger.error("ERROR: error happened in Transformer");
        } else if (e instanceof SAXException){
            logger.error("ERROR: error happened in SAE");
        }
            
    }
}
