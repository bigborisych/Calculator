package ru.borisych;

import java.util.Scanner;

public class Main {
    public static final String ERROR_INPUT_STRING = "Неверный формат ввода!";
    public static final String ERROR_OPERATION_NOT_FOUND = "Операция над числами не найдена";
    public static final String ERROR_WRONG_NUMBER = "Числа должны быть одного типа!";
    public static final String ERROR_WRONG_RANGE_OF_NUMBERS = "Числа должны быть от 1 до 10";


    public static final String SPLIT_SEPARATOR = " ";
    public static final String ARABIC_CHAR = "1 2 3 4 5 6 7 8 9 10";
    public static final String ROME_CHAR = "I II III IV V VI VII VIII IX X";

    private static final String OPERATIONS = "+ - * /";
    private static final byte MAX_LENGTH_STRING = 5;
    private static final byte MIN_LENGTH_STRING = 2;


    public static void main(String[] args) {

        String formattedStringOfCalc = getString();
        char operation = getOperation(formattedStringOfCalc);

        String formattedStringOfCalcDonutOperation = formattedStringOfCalc.replace(operation, ' ');
        String[] numbers = formattedStringOfCalcDonutOperation.split(SPLIT_SEPARATOR);
        AbstractNum numberOne = new AbstractNum(numbers[0]);
        AbstractNum numberTwo = new AbstractNum(numbers[1]);
        Calculator calculator = new Calculator(numberOne, numberTwo, operation);
        String result = calculator.getResult();
        System.out.println(result);
        /* ArabicNum arabicNumOne = new ArabicNum(numbers[0]);
        ArabicNum arabicNumTwo = new ArabicNum(numbers[1]);
        RomeNum romeNumOne = new RomeNum(numbers[0]);
        RomeNum romeNumTwo = new RomeNum(numbers[1]);
        int result;
        if (arabicNumOne.isNum() && arabicNumTwo.isNum()) {
            Calculator calculator = new Calculator(arabicNumOne, arabicNumTwo, operation);
            result = calculator.getResult();
            System.out.println(result);

        } else if (romeNumOne.isNum() && romeNumTwo.isNum()) {
            Calculator calculator = new Calculator(romeNumOne, romeNumTwo, operation);
            result = calculator.getResult();
            RomeNum romeResult = new RomeNum(result);
            String resultRome = romeResult.toRome();
            System.out.println(resultRome);
        }**/
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