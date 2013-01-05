
package com.lynn.caculator;

import com.lynn.caculator.Command;

public class Caculator {
    public static void main(String[]args){
        Command commands = new Command();
        commands.createOptions();
        
        commands.analysesCommand(args);
    }
}
