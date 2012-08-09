/**
* Created : Mar 12, 2012
*
* This file is the main entry.
*
*/
package com.ericsson.ma;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

import com.ericsson.ma.Gui;

public class AdressBook {
    
    public static void main(String[]srgs){
        System.out.println(AdressBook.class.getResource("").toString());
        System.setProperty("logback.configurationFile", "src/logback.xml");
        System.out.println(System.getProperty("logback.configurationFile"));
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory(); 
        StatusPrinter.print(lc);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Gui gui = new Gui();
        threadPool.execute(gui);
        threadPool.shutdown();
        }
    }
