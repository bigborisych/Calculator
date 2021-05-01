package ru.borisych;

import java.util.Scanner;

public class Main {
    private static final String OPERATIONS = "+ - * /";
    public static final String ARABIC_CHAR = "1 2 3 5 6 7 8 9 10";
    public static final String ROME_CHAR = "I II III IV V VI VII VIII IX X";
    private static final byte MAX_LENGTH_STRING = 5;
    public static void main(String[] args) {
        // Инцициализация переменных
        String formattedStringOfCalc = getString();
        char operation = getOperation(formattedStringOfCalc);
        String formattedStringOfCalcDonutOperation = formattedStringOfCalc.replace(operation, ' ');
        String[] numbers = formattedStringOfCalcDonutOperation.split(" ");
        ArabicNum arabicNumOne = new ArabicNum(numbers[0]);
        ArabicNum arabicNumTwo = new ArabicNum(numbers[1]);
        RomeNum romeNumOne = new RomeNum(numbers[0]);
        RomeNum romeNumTwo = new RomeNum(numbers[1]);
        int result = 0;
        try {
            if (arabicNumOne.isArabic() && arabicNumTwo.isArabic()) {
                Calculator calculator = new Calculator(arabicNumOne, arabicNumTwo, operation);
                result = calculator.getResult();
            } else
                throw new Exception("Ошибка при вводе чисел");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    private static String getString() {
        Scanner inputString = new Scanner(System.in);
        String stringOfCalc = inputString.nextLine();
        String formattedStringOfCalc = stringOfCalc.replaceAll("\\s", "");
        //Проверка на валидность выражения
        try {
            if (!(formattedStringOfCalc.length() <= MAX_LENGTH_STRING)) {
                throw new Exception("Ошибка ввода выражения");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedStringOfCalc;
    }
    private static char getOperation(String string){
        String[] operations = OPERATIONS.split(" ");
        char result = '0';
        for(String operation:operations){
            if(string.contains(operation)){
                result = string.charAt(string.indexOf(operation));
            }
        }
        return result;
    }
}