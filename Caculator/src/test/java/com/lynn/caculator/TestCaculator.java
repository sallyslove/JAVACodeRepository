package com.lynn.caculator;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;

import com.lynn.caculator.operation.Add;
import com.lynn.caculator.operation.Operation;
import com.lynn.caculator.operation.Sub;

public class TestCaculator {
    Operation caculator = null;

    @Test
    public void testCaculatorAdd() {
        caculator = new Add();
        assertEquals(33, caculator.getOperationResult(11, 22), 0);
    }

    @Test
    public void testCaculatorSub() {
        caculator = new Sub();
        assertEquals(11, caculator.getOperationResult(22, 11), 0);
    }

    @After
    public void setCaculatorNull() {
        caculator = null;
    }

}
