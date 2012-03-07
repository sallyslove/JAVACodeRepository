package com.ericsson.ma;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class XMLFileSearchTest {
    XMLFileSearch xmlFileSearch = null;
    XMLAddNewNode xmlAddNode = null;
    ArrayList<PersonInfo> personFound = null;
    
    @Before
    public void createXmlFileSearchInstance(){
        xmlFileSearch = new XMLFileSearch();
        xmlAddNode = new XMLAddNewNode();
        personFound = new ArrayList<PersonInfo>();
        }
    
    @Test
    public void testSearchFile() {
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
