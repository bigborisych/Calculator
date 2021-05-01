package ru.borisych;

public class Calculator {
    private final Num numberOne;
    private final Num numberTwo;
    private int result;
    private final char operation;

    public Calculator(Num numberOne, Num numberTwo, char operation) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.operation = operation;
    }

    public int getResult() {
        try {
            if(numberOne.getNum() > 10){
                throw new Exception("Числа должны быть от 1 до 10");
            }else if(numberTwo.getNum() > 10){
                throw new Exception("Числа должны быть от 1 до 10");
            }
        } catch(Exception e){
                e.printStackTrace();
        }
        switch (operation) {
            case '+' -> result = numberOne.getNum() + numberTwo.getNum();
            case '-' -> result = numberOne.getNum() - numberTwo.getNum();
            case '*' -> result = numberOne.getNum() * numberTwo.getNum();
            case '/' -> result = numberOne.getNum() / numberTwo.getNum();
        }
        return result;
    }
}
