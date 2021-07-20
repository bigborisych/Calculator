package ru.borisych.v2;

import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumFactory numFactory = new NumFactory();
        List<Operation> operations = List.of(new PlusOperation(), new MinusOperation(), new MultiplyOperation(), new DivideOperation());
        while (scanner.hasNext()) {
            String stringNumOne = scanner.next();
            String inputOperation = scanner.next();
            String stringNumTwo = scanner.next();
            Num numOne = numFactory.getNum(stringNumOne);
            Num numTwo = numFactory.getNum(stringNumTwo);
            System.out.println(numOne.getNum());
            System.out.println(numTwo.getNum());
            for (Operation operation : operations) {
                if (operation.getOperator().equals(inputOperation)) {
                    System.out.println(operation.processNums(numOne, numTwo).getResult());
                }
            }
        }
    }
}
