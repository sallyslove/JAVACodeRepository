package com.ericsson.ma;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.transform.TransformerFactoryConfigurationError;

import org.junit.Before;
import org.junit.Test;

public class XMLFileSearchTest {
    XMLFileSearch xmlFileSearch = null;
    XMLAddNewNode xmlAddNode = null;
    ArrayList<Person> personFound = null;
    
    @Before
    public void createXmlFileSearchInstance(){
        xmlFileSearch = new XMLFileSearch();
        xmlAddNode = new XMLAddNewNode();
        personFound = new ArrayList<Person>();
        }
    
    @Test
    public void testSearchFile() throws TransformerFactoryConfigurationError, IOException {
        String person = "mark/23784762/changning";
        xmlAddNode.addNewNode(person);
        String phone = "237847";
        personFound = xmlFileSearch.searchFile(phone);
        assertEquals("23784762",personFound.get(0).getPhoneNumber());
        assertEquals("mark", personFound.get(0).getName());
        assertEquals("changning",personFound.get(0).getAdress());
        phone = "347658";
        personFound = xmlFileSearch.searchFile(phone);
        assertNull(personFound);
        }
}
