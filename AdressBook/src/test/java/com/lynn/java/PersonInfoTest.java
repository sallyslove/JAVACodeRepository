package com.lynn.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lynn.java.addressbook.Person;

public class PersonInfoTest {
    Person person = null;
    
    @Before
    public void createPersonInstance(){
        person = new Person();
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

    @Test
    public void testSetPhoneNumberNeg(){
        person.setPhoneNumber("1783falk");
        assertNotSame("1783falk", person.getPhoneNumber());
    }
}
