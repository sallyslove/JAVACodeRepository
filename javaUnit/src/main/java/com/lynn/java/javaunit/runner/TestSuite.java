package com.lynn.java.javaunit.runner;

import java.lang.reflect.Method;
import java.util.List;

public class TestSuite {
    private String className;
    private List<Method> testCases;
    private final String TEST_ANNOTATION_NAME = "Test";

    public void getMethodsOfOneSuite(String className) throws SecurityException, ClassNotFoundException {
        testCases = TestRunnerAssistant.getAnnotatedMethods(className, TEST_ANNOTATION_NAME);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Method> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<Method> testCases) {
        this.testCases = testCases;
    }

}
