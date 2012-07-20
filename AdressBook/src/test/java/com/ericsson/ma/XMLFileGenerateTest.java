package com.ericsson.ma;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class XMLFileGenerateTest {
    XMLFileGenerate xmlFileGenerate = null;
    
    @Before
    public void createXMLFileGenerateInstance(){
        xmlFileGenerate = new XMLFileGenerate();
        }
    
    @Test
    public void testGenerateXMLFile() {
        xmlFileGenerate.generateXMLFile();
        assertTrue(new File("addressBook.xml").exists());
        }
    
    @After
    public void releaseXMLFileGenerateInstance(){
        xmlFileGenerate = null;
    }
}
