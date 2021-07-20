package ru.borisych.v2;

public class PlusOperation extends AbstractOperation {
    private final static String OPERATOR = "+";

    @Override
    public String getOperator() {
        return OPERATOR;
    }

    @Override
    protected int doOperation(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }
}
