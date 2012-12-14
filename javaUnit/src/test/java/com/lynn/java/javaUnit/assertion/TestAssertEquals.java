package com.lynn.java.javaUnit.assertion;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import static com.lynn.java.javaunit.assertion.Assert.assertEqualsInt;

public class TestAssertEquals {
    
    @Test
    public void testAssertEqualsInt(){
        assertTrue(assertEqualsInt(2,1));
    }
}
