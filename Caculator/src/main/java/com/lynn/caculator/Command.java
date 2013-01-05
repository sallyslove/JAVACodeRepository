package com.lynn.caculator;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.lynn.caculator.operation.Operation;
import com.lynn.caculator.operation.OperationFactory;
import com.lynn.caculator.operation.OperationName;

public class Command {
    private Options options = new Options();
    private Operation caculator;

    public void createOptions() {
        Option help = new Option("h", "the command help");
        options.addOption(help);
        createCompOperation("Add");
        createCompOperation("Sub");
        createCompOperation("Mul");
        createCompOperation("Div");
    }

    private void createCompOperation(String name) {
        OptionBuilder.withArgName(name + " parameter1 parameter2");
        OptionBuilder.hasArgs(3);
        OptionBuilder.withValueSeparator();
        OptionBuilder.withDescription("do " + name + " operation");
        Option opt = OptionBuilder.create(name);
        options.addOption(opt);
    }

    public void analysesCommand(String[] args) {
        CommandLineParser parser = new GnuParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.err.println("Parsing failed.  Reason: " + e.getMessage());
        }
        doOperation(cmd);
    }

    private void doOperation(CommandLine cmd) {
        if (cmd.hasOption("h")) {
            HelpFormatter hf = new HelpFormatter();
            hf.printHelp("OptionsTip", options);
        } else if (cmd.hasOption("Add") || cmd.hasOption("Sub") || cmd.hasOption("Mul") || cmd.hasOption("Div")) {
            Option[] options = cmd.getOptions();
            for (Option option : options) {
                String[] parameter = cmd.getOptionValues(option.getValue());
                caculator = OperationFactory.createOperation(OperationName.valueOf(parameter[0]));
                System.err.println(caculator.getOperationResult(Double.parseDouble(parameter[1]), Double.parseDouble(parameter[2])));
            }
        }
    }
}
