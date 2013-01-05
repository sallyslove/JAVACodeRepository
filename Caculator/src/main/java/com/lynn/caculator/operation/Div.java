package com.lynn.caculator.operation;

public class Div extends Operation {

    @Override
    public double getOperationResult(double parameter1, double parameter2) {
        if(parameter2 != 0){
            return (parameter1/parameter2);
        }
        else{
            return 0;
        }
    }

}
