package com.lynn.java.javaunit.runner;

import com.lynn.java.javaunit.datamodel.TestSuite;

public class TestRunner {

    public static void main(String[] args) {
        TestSuite testSuite = new TestSuite();
        testSuite.setClassName(args[0]);
        try {
            TestRunnerAssistant.runATestSuite(testSuite);
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
