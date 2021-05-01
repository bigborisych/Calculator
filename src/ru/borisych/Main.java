package ru.borisych;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String formattedStringOfCalc = getString();

        char operation = formattedStringOfCalc.charAt(1);
        ArabicNum arabicNumOne = new ArabicNum(formattedStringOfCalc.charAt(0));
        ArabicNum arabicNumTwo = new ArabicNum(formattedStringOfCalc.charAt(2));
        int result = 0;
        try {
            if (arabicNumOne.isArabic() && arabicNumTwo.isArabic()) {
                Calculator calculator = new Calculator(arabicNumOne, arabicNumTwo, operation);
                result = calculator.getResult();
            } else
                throw new Exception("Ошибка числа не арабские");
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
            if (!(formattedStringOfCalc.length() <= 3)) {
                throw new Exception("Ошибка ввода выражения");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedStringOfCalc;
    }
}