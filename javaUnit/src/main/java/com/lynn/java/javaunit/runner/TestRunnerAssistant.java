package com.lynn.java.javaunit.runner;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.lynn.java.javaunit.datamodel.TestResult;
import com.lynn.java.javaunit.datamodel.TestSuite;
import com.lynn.java.javaunit.error.AssertError;

public class TestRunnerAssistant {

    public static List<Method> getAnnotatedMethods(String className, String annotationName) throws SecurityException, ClassNotFoundException {
        List<Method> methods = new ArrayList<Method>();
        for (Method method : Class.forName(className).getMethods()) {
            Class<? extends Annotation> annotationClass = (Class<? extends Annotation>) Class.forName(annotationName);
            if (method.isAnnotationPresent(annotationClass)) {
                methods.add(method);
            }
        }
        return methods;
    }

    public static void runATestSuite(TestSuite testSuite) throws SecurityException, ClassNotFoundException {
        List<Method> testCases = testSuite.getTestCases();
        TestResult testResult = new TestResult();
        for (Method test : testCases) {
            try {
                test.invoke(null);
                testResult.incrementCaseSucceed();
                testResult.incrementCaseFailed();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        testResult.print();
    }
}
