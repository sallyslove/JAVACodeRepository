package com.lynn.java.javaunit.runner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method; 
import java.util.ArrayList;
import java.util.List;

public class TestRunnerAssistant {

    public static List<Method> getAnnotatedMethods(String className, String annotationName) throws SecurityException, ClassNotFoundException{
        List<Method> methods = new ArrayList<Method>();
        for (Method method : Class.forName(className).getMethods()) {
            Class<? extends Annotation> annotationClass = (Class<? extends Annotation>) Class.forName(annotationName);
            if (method.isAnnotationPresent(annotationClass)) {
                methods.add(method);
            }
        }
        return methods;
    }
}
