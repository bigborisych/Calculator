package ru.borisych;

import org.junit.Assert;
import org.junit.Test;
import ru.borisych.v2.*;

import java.util.List;

public class CalculatorTest {
    @Test
    public void operationTest(){
        List<Operation> operations = List.of(new PlusOperation(), new MinusOperation(), new MultiplyOperation(), new DivideOperation());
        String[] StringOperations = {"+", "-", "*", "/", "null"};

    }
}
