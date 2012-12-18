package com.lynn.java.addressbook.storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.lynn.java.addressbook.Person;
import com.lynn.java.addressbook.util.Util;
import com.lynn.java.addressbook.util.XmlUtil;

public class XmlStorage implements Storage {
    private static final String fileName = "addressBook.xml";
    private static final String rootNodeName = "person";
    private static final Logger logger = LoggerFactory.getLogger(XmlStorage.class);
    private List<String> names;
    private List<String> phone;
    private List<String> address;
    private Map<String, Person> personInfo;

    public XmlStorage() {
        super();
        personInfo = new HashMap<String, Person>();
    }

    @Override
    public void generateNewStorage() {
        logger.trace("FUNCTION ENTER: generate XML file");
        try {
            XmlUtil.generateNewXmlFile(fileName, rootNodeName);
        } catch (IOException e) {
            logger.error("ERROR: error happened in IO, fail to create Doc");
        } catch (ParserConfigurationException e) {
            logger.error("ERROR: error happened in ParseConfiguration, fail to create Doc");
        } catch (TransformerException e) {
            logger.error("ERROR: error happened in Transformer, fail to create Doc");
        }
    }

    @Override
    public void loadData() {
        Document file;
        try {
            file = XmlUtil.openXmlFile(fileName);
            names = XmlUtil.parseXmlFile("name", file);
            phone = XmlUtil.parseXmlFile("phone", file);
            address = XmlUtil.parseXmlFile("address", file);
            transformData();
        } catch (SAXException e) {
            logger.error("ERROR: load data error happened in SAX");
        } catch (IOException e) {
            logger.error("ERROR: load data error happened in IO");
        } catch (ParserConfigurationException e) {
            logger.error("ERROR: load data error happened in ParserConfiguration");
        }
    }

    @Override
    public void transformData() {
        turnDataToPerson();
    }

    private void turnDataToPerson() {
        Person person = new Person();
        for (int index = 0; index < names.size(); ++index) {
            person.setName(names.get(index));
            person.setPhoneNumber(phone.get(index));
            person.setAdress(address.get(index));
            personInfo.put(phone.get(index), person);
        }
    }

    @Override
    public void refreshData() {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteData() {
        // TODO Auto-generated method stub

    }

    @Override
    public Object searchData() {
        return null;
        // TODO Auto-generated method stub
    }

    @Override
    public void saveData() {
        // TODO Auto-generated method stub
    }

    @Override
    public void refreshData(Object obj) {
        try {
            Document file = XmlUtil.openXmlFile(fileName);
            String[] person = convertInputToPerson((String) obj);
            if (!(isPhoneNumString(person[1]))) {
                logger.error("ERROR:phone number must be digitals!");
                return;
            }
            XmlUtil.addNode(file, person[0], "name");
            XmlUtil.addNode(file, person[1], "phone");
            XmlUtil.addNode(file, person[2], "address");
            XmlUtil.writeXmlFile(file, fileName);
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private String[] convertInputToPerson(String input) {
        String[] person = input.split("/");
        return person;
    }

    private boolean isPhoneNumString(String string) {
        return Util.isNum(string);
    }

    @Override
    public void loadData(Object obj) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteData(Object obj) {
        // TODO Auto-generated method stub
    }

    @Override
    public Object searchData(Object obj) {
        loadData();
        List<Person> personFound = new ArrayList<Person>();
        for (String phone : personInfo.keySet()) {
            if (phone.contains((String) obj)) {
                personFound.add(personInfo.get(phone));
            }
        }
        return personFound;
    }

    @Override
    public void savaData(Object obj) {
        // TODO Auto-generated method stub
    }

    @Override
    public void transformData(Object obj) {
    }

}
