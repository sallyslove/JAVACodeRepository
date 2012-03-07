package com.ericsson.ma;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonInfoTest {
    PersonInfo person = null;
    
    @Before
    public void createPersonInstance(){
        person = new PersonInfo();
    }
    
    @Test
    public void testSetAdress() {
        person.setAdress("Tianshan");
        assertEquals("Tianshan", person.getAdress());
    }

    @Test
    public void testSetName() {
        person.setName("mark");
        assertEquals("mark", person.getName());
    }


    @Test
    public void testSetPhoneNumber() {
        person.setPhoneNumber("1223");
        assertEquals("1223", person.getPhoneNumber());
    }

}
