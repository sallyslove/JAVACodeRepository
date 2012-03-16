/*
 * created by Lynn 13/03/2012
 * 
 * it is the entry
 */

package com.lynn.caculator;

import com.lynn.caculator.CaculatorCommand;

public class App {
    public static void main(String[]args){
        CaculatorCommand commands = new CaculatorCommand();
        commands.createOptions();
        
        commands.analysesCommand(args);
    }
}
