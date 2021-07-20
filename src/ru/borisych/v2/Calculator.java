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
            Operation operation = operations.stream()
                    .filter(x -> x.getOperator().equals(inputOperation))
                    .findFirst()
                    .orElse(null);
            if (operation == null) {
                throw new IllegalArgumentException();
            }
            System.out.println(operation.processNums(numOne, numTwo).getResult());
        }
    }
}
