/*
 * created by lynn on 13/03/2012
 * 
 * practice for command package
 */
package com.lynn.caculator;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CaculatorCommand {
    Options options = new Options(); 
    Caculator caculator = new Caculator();
   
    void createOptions(){
        Option help = new Option("h", "the command help");
        options.addOption(help);   
        createCompOperation("add");
        createCompOperation("sub");
    }
    
    void analysesCommand(String[] args){
        CommandLineParser parser = new GnuParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.err.println("Parsing failed.  Reason: " + e.getMessage());
            }
        doOperation(cmd);
        }
    
    void doOperation(CommandLine cmd){
        if(cmd.hasOption("h")){
            HelpFormatter hf = new HelpFormatter();
            hf.printHelp("OptionsTip", options);
            }
        if(cmd.hasOption("add")){
            String[] parameter = null;
            parameter = cmd.getOptionValues("add");
            caculator.caculatorAdd(Double.parseDouble(parameter[0]), Double.parseDouble(parameter[1]));
        }
        }
    
    void createCompOperation(String name){
        OptionBuilder.withArgName("parameter1 parameter2");
        OptionBuilder.hasArgs(2);
        OptionBuilder.withValueSeparator();
        OptionBuilder.withDescription("do "+name+" operation");
        Option opt = OptionBuilder.create(name);
        options.addOption(opt);
    }
}
