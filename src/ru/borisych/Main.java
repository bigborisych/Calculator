package ru.borisych;

import java.util.Scanner;

public class Main {
    public static final String ERROR_STRING_TOO_LONG = "Неверный фомат ввода";
    public static final String ERROR_OPERATION_NOT_FOUND = "Операция над числами не найдена";
    public static final String ERROR_WRONG_NUMBER = "Числа должны быть одного типа!";
    public static final String ERROR_WRONG_RANGE_NUMBER = "Числа должны быть от 1 до 10";


    public static final String SPLIT_SEPARATOR = " ";
    public static final String OPERATIONS = "+ - * /";
    public static final String ARABIC_CHAR = "1 2 3 5 6 7 8 9 10";
    public static final String ROME_CHAR = "I II III IV V VI VII VIII IX X";
    private static final byte MAX_LENGTH_STRING = 5;

    public static void main(String[] args) {
        // Инцициализация переменных
        String formattedStringOfCalc = getString();
        char operation = getOperation(formattedStringOfCalc);
        String formattedStringOfCalcDonutOperation = formattedStringOfCalc.replace(operation, ' ');
        String[] numbers = formattedStringOfCalcDonutOperation.split(SPLIT_SEPARATOR);
        ArabicNum arabicNumOne = new ArabicNum(numbers[0]);
        ArabicNum arabicNumTwo = new ArabicNum(numbers[1]);
        RomeNum romeNumOne = new RomeNum(numbers[0]);
        RomeNum romeNumTwo = new RomeNum(numbers[1]);

        try {
            int result;
            if (arabicNumOne.isArabic() && arabicNumTwo.isArabic()) {
                Calculator calculator = new Calculator(arabicNumOne, arabicNumTwo, operation);
                result = calculator.getResult();
                System.out.println(result);
            } else if (romeNumOne.isRome() && romeNumTwo.isRome()) {
                Calculator calculator = new Calculator(romeNumOne, romeNumTwo, operation);
                result = calculator.getResult();
                RomeNum romeResult = new RomeNum(result);
                romeResult.toRome();
                System.out.println(romeResult);
            } else{
                throw new Exception(ERROR_WRONG_NUMBER);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getString() {
        Scanner inputString = new Scanner(System.in);
        String stringOfCalc = inputString.nextLine();
        String formattedStringOfCalc = stringOfCalc.replaceAll("\\s", "");
        try {
            if (!(formattedStringOfCalc.length() <= MAX_LENGTH_STRING)) {
                throw new Exception(ERROR_STRING_TOO_LONG);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        }
        return result;
    }
}