package com.ericsson.ma;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLAddNewNodeTest {
    XMLAddNewNode xmlAddNode = null;
    String person = null;

    @Before
    public void createXMLAddNewNodeInstance(){
        xmlAddNode = new XMLAddNewNode();
        person = new String("mark/12345/changning");
        }
    
    
    @Test
    public void testAddNewNode() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = dFactory.newDocumentBuilder();
            Document file;
            file = builder.parse(new File("addressBook.xml"));
            NodeList node = file.getElementsByTagName("name");
            int nodeNum = node.getLength();
            System.out.println(nodeNum);
            xmlAddNode.addNewNode(person);
            DocumentBuilderFactory dFactory1 = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder1;
            builder1 = dFactory1.newDocumentBuilder();
            Document file1;
            file1 = builder1.parse(new File("addressBook.xml"));
            NodeList node1 = file1.getElementsByTagName("name");
            int nodeNum1 = node1.getLength();
            System.out.println(nodeNum1);
            assertEquals(nodeNum1, (nodeNum+1));
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
                }catch (SAXException e) {
                    e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                        }
        }
}
