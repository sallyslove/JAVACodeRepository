package com.lynn.java.javaunit.datamodel;

import java.lang.reflect.Method;
import java.util.List;

import com.lynn.java.javaunit.runner.TestRunnerAssistant;

public class TestSuite {
    private String className;
    private List<Method> testCases;
    private final String TEST_ANNOTATION_NAME = "Test";

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Method> getTestCases() throws SecurityException, ClassNotFoundException {
        getMethodsOfOneSuite(className);
        return testCases;
    }
    
    private void getMethodsOfOneSuite(String className) throws SecurityException, ClassNotFoundException {
        testCases = TestRunnerAssistant.getAnnotatedMethods(className, TEST_ANNOTATION_NAME);
    }

    public void setTestCases(List<Method> testCases) {
        this.testCases = testCases;
    }

}
