package com.lynn.java.javaunit.assertion;

import com.lynn.java.javaunit.error.AssertError;

public class Assert {

    public static void assertTrue(Boolean para) throws AssertError {
        if (!para) {
            Assert.caseFail();
        }
    }
    
    public static void assertFalse(Boolean para) throws AssertError {
        if(para){
            Assert.caseFail();
        }
    }

    public static void assertEquals(int para1, int para2) throws AssertError {
        if (para1 != para2) {
            Assert.caseFail();
        }
    }

    public static void assertEquals(String para1, String para2) throws AssertError {
        if (!para1.equals(para2)) {
            Assert.caseFail();
        }
    }

    private static void caseFail() throws AssertError {
        throw (new AssertError());
    }
}