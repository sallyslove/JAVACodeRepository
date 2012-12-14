package com.lynn.java.javaunit.runner;

import java.lang.reflect.Method;

import com.lynn.java.javaunit.annotations.Test;

public class TestRunner {

    public static void main(String[] args) {
       for(String className : args){
           
       }
    }
}

//
//int passed = 0, failed = 0;
//for (Method method : Class.forName(args[0]).getMethods()) {
//    if (method.isAnnotationPresent(Test.class)) {
//        try {
//            method.invoke(null);
//            passed++;
//        } catch (Throwable ex) {
//            System.out.printf("Test %s failed: %s %n", method, ex.getCause());
//            failed++;
//        }
//    }
//}
//System.out.printf("Passed: %d, Failed %d%n", passed, failed);