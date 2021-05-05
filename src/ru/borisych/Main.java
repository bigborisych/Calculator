package ru.borisych;

import java.util.Scanner;

public class Main {
    public static final String ERROR_INPUT_STRING = "Неверный формат ввода!";
    public static final String ERROR_OPERATION_NOT_FOUND = "Операция над числами не найдена";
    public static final String ERROR_WRONG_NUMBER = "Числа должны быть одного типа!";
    public static final String ERROR_WRONG_RANGE_OF_NUMBERS = "Числа должны быть от 1 до 10";

    public static final String SPLIT_SEPARATOR = " ";
    public static final String ARABIC_CHAR = "0 1 2 3 4 5 6 7 8 9";
    public static final String ROME_CHAR = "I II III IV V VI VII VIII IX X";

    private static final String OPERATIONS = "+ - * /";
    private static final byte MAX_LENGTH_STRING = 10;
    private static final byte MIN_LENGTH_STRING = 3;


    public static void main(String[] args) {
        while (true) {
            String formattedStringOfCalc = getString();
            char operation = getOperation(formattedStringOfCalc);

            String formattedStringOfCalcDonutOperation = formattedStringOfCalc.replace(operation, ' ');
            String[] numbers = formattedStringOfCalcDonutOperation.split(SPLIT_SEPARATOR);
            AbstractNum numberOne = new AbstractNum(numbers[0]);
            AbstractNum numberTwo = new AbstractNum(numbers[1]);
            Calculator calculator = new Calculator(numberOne, numberTwo, operation);
            String result = calculator.getResult();
            if(result.contains("-") && numberOne.getNumType().equals("Rome")){
                String[] formatedResult = result.split(String.valueOf(operation));
                RomeNum resultToRome = new RomeNum(formatedResult[1]);
                result = "-" + resultToRome.toRome();
            }else{
                RomeNum resultToRome = new RomeNum(result);
                result = resultToRome.toRome();
            }
            System.out.println(result);
        }
    }

    private static String getString() {
        Scanner inputString = new Scanner(System.in);
        String stringOfCalc = inputString.nextLine();
        String formattedStringOfCalc = stringOfCalc.replaceAll("\\s", "");
        try {
            if (!((formattedStringOfCalc.length() <= MAX_LENGTH_STRING) && (formattedStringOfCalc.length() >= MIN_LENGTH_STRING))) {
                throw new Exception(ERROR_INPUT_STRING);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return formattedStringOfCalc;
    }

    private static char getOperation(String string) {
        String[] operations = OPERATIONS.split(SPLIT_SEPARATOR);
        char result = '0';
        try {
            for (String operation : operations) {
                if (string.contains(operation)) {
                    result = string.charAt(string.indexOf(operation));
                }
            }
            if (result == '0') throw new Exception(Main.ERROR_OPERATION_NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return result;
    }
}
