package com.lynn.caculator.operation;

public class OperationFactory {

    public static Operation createOperation(OperationName name) {
        Operation operation = null;
        switch (name) {
        case Add:
            operation = new Add();
            break;
        case Sub:
            operation = new Sub();
            break;
        case Mul:
            operation = new Mul();
            break;
        case Div:
            operation = new Div();
            break;
        default:
            operation = new Operation();
        }
        return operation;
    }
}
