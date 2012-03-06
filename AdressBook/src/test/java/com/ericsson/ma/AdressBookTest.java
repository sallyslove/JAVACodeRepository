package com.ericsson.ma;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;


public class AdressBookTest{
	Logger logger = LoggerFactory.getLogger(AdressBookTest.class);
	
	public static void main(String [] args){
	    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory(); 
  	    StatusPrinter.print(lc);  

//	    logger.info("Hello {}","debug message");

//		PersonInfo oneGuy = new PersonInfo();
//		oneGuy.setAdress("Wu Song Lu");
//		oneGuy.setName("Mark");
//		oneGuy.setPhoneNumber("12345");
//
//		PersonInfo twoGuy = new PersonInfo();
//		twoGuy.setAdress("Tian Shan Lu");
//		twoGuy.setName("Nick");
//		twoGuy.setPhoneNumber("34567");
//		
//		AdressBook myAdressBook = new AdressBook(oneGuy);
//		myAdressBook.add(twoGuy);
//		
//		String msgToCustomer = "please input a phone number or part of it";
//		System.out.println(msgToCustomer);
//		String customerInput = null;
//		try{
//			BufferedReader customerRead = new BufferedReader(new InputStreamReader(System.in));
//			customerInput = customerRead.readLine();
//			System.out.println(customerInput);
//		}
//		catch(IOException ex){
//			ex.printStackTrace();
//		}
//		
//		System.out.println(myAdressBook.searchByPhone(customerInput));
				
  	     ExecutorService threadPool = Executors.newCachedThreadPool();
	     SimpleGui gui = new SimpleGui();     
	     threadPool.execute(gui);
        
//        oneGuy = null;
//        twoGuy = null;
//        myAdressBook = null;

//		XMLRelativeMethods xmlHandle = new XMLRelativeMethods();
//		xmlHandle.generateXMLFile();
//		xmlHandle.addNewNode("mark/1234");
//		xmlHandle.searchFile("123");
		
		
		
	}
}
