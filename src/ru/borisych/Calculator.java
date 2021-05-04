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

    public String getResult() {
        validateNumber(numberOne, numberTwo);
        switch (operation) {
            case '+' -> result = numberOne.getNum() + numberTwo.getNum();
            case '-' -> result = numberOne.getNum() - numberTwo.getNum();
            case '*' -> result = numberOne.getNum() * numberTwo.getNum();
            case '/' -> {
                if (((int) (numberOne.getNum() / numberTwo.getNum())) != (numberOne.getNum() / numberTwo.getNum())) {
                    result = numberOne.getNum() / numberTwo.getNum();
                }else throw new NumberFormatException("Калькулятор работает только с целыми числами");
            }
        }
        if (result >= 0) {
            return String.valueOf(result);
        } else {
            throw new NumberFormatException();
        }
    }

    private void validateNumber(Num numberOne, Num numberTwo) {
        boolean validRange = numberOne.getNum() > 10 || numberOne.getNum() < 1 || numberTwo.getNum() > 10 || numberTwo.getNum() < 1;
        try {
            if (!(((numberOne.getNumType().equals("Arabic")) && (numberTwo.getNumType().equals("Arabic"))) || ((numberOne.getNumType().equals("Rome")) && (numberTwo.getNumType().equals("Rome"))))) {
                throw new NumberFormatException();
            } else if (validRange) {
                throw new Exception(Main.ERROR_WRONG_RANGE_OF_NUMBERS);
            }
        } catch (NumberFormatException e) {
            System.err.println(Main.ERROR_WRONG_NUMBER);
            System.exit(1);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(Main.ERROR_WRONG_RANGE_OF_NUMBERS);
            System.exit(1);
            e.printStackTrace();
        }
    }
}
