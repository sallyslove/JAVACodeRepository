package com.lynn.caculator.operation;

public class Add extends Operation {

    @Override
    public double getOperationResult(double parameter1, double parameter2) {
        return (parameter1 + parameter2);
    }

}
