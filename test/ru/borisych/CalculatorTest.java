package ru.borisych;

import org.junit.Assert;
import org.junit.Test;
import ru.borisych.v2.*;

import java.util.List;

public class CalculatorTest {
    private static final NumFactory factory = new NumFactory();

    @Test
    public void operationTest() {
        List<Operation> operations = List.of(new PlusOperation(), new MinusOperation(), new MultiplyOperation(), new DivideOperation());
        String[] stringOperations = {"+", "-", "*", "/"};
        Assert.assertEquals(stringOperations[0], operations.get(0).getOperator());
        Assert.assertEquals(stringOperations[1], operations.get(1).getOperator());
        Assert.assertEquals(stringOperations[2], operations.get(2).getOperator());
        Assert.assertEquals(stringOperations[3], operations.get(3).getOperator());
    }
    @Test
    public void minusOperationTest(){
        Operation operation = new MinusOperation();
        Assert.assertEquals(operation.processNums(factory.getNum("1"), factory.getNum("2")).getResult(), "-1");
        Assert.assertEquals(operation.processNums(factory.getNum("3"), factory.getNum("3")).getResult(), "0");
    }
    @Test
    public void divideOperationTest(){
        Operation operation = new DivideOperation();
        Assert.assertEquals(operation.processNums(factory.getNum("1"), factory.getNum("2")).getResult(), "0");
        Assert.assertEquals(operation.processNums(factory.getNum("3"), factory.getNum("3")).getResult(), "1");
    }
    @Test
    public void multiplyOperationTest(){
        Operation operation = new MultiplyOperation();
        Assert.assertEquals(operation.processNums(factory.getNum("1"), factory.getNum("2")).getResult(), "2");
        Assert.assertEquals(operation.processNums(factory.getNum("3"), factory.getNum("3")).getResult(), "9");
    }
    @Test
    public void plusOperationTest(){
        Operation operation = new PlusOperation();
        Assert.assertEquals(operation.processNums(factory.getNum("1"), factory.getNum("2")).getResult(), "3");
        Assert.assertEquals(operation.processNums(factory.getNum("3"), factory.getNum("3")).getResult(), "6");
    }
}
