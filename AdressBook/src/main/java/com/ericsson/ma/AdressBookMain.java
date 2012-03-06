package com.ericsson.ma;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

import com.ericsson.ma.SimpleGui;

public class AdressBookMain {
   
	public static void main(String [] args){
	    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory(); 
  	    StatusPrinter.print(lc);  
		 ExecutorService threadPool = Executors.newCachedThreadPool();
	     SimpleGui gui = new SimpleGui();     
	     threadPool.execute(gui);
	     threadPool.shutdown();
	}
}
