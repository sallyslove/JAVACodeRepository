package com.ericsson.ma;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

import com.ericsson.ma.SimpleGui;

public class AdressBookMain {
    SimpleGui gui = new SimpleGui();
    
    public static void main(String[]srgs){
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory(); 
        StatusPrinter.print(lc);
        ExecutorService threadPool = Executors.newCachedThreadPool();
	AdressBookMain main = new AdressBookMain();
        threadPool.execute(main.gui);
        threadPool.shutdown();
        }
    }
