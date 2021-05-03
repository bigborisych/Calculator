package ru.borisych;

import org.junit.Assert;
import org.junit.Test;

public class ArabicNumTest {
    @Test
    public void isNumTest() {
        String[] testNumberString = Main.ARABIC_CHAR.split(Main.SPLIT_SEPARATOR);
        String[] testRomeString = Main.ROME_CHAR.split(Main.SPLIT_SEPARATOR);
        for (String testNumber : testNumberString) {
            ArabicNum number = new ArabicNum(testNumber);
            System.out.println(number.getNum() + " is " + number.getNumType());
            Assert.assertEquals("Wrong number", "Arabic" ,number.getNumType());
        }
        for (String testNumber : testRomeString) {
            RomeNum number = new RomeNum(testNumber);
            Assert.assertEquals("Wrong number", "Rome", number.getNumType());
            System.out.println(testNumber + " is " + number.getNumType());
        }
    }
    @Test
    public void operationTest(){
        String operations = "+ - * /";
        String[] operationsSplit = operations.split(Main.SPLIT_SEPARATOR);
        for(String operation:operationsSplit){
            String testNumberStringT = "1 2 3 4 5 6 7 8 9 10";
            String[] testNumberString = testNumberStringT.split(Main.SPLIT_SEPARATOR);
            String[] testRomeString = Main.ROME_CHAR.split(Main.SPLIT_SEPARATOR);
            for (String testNumber : testNumberString) {
                ArabicNum number = new ArabicNum(testNumber);
                Calculator calculator = new Calculator(number, number, operation.charAt(0));
                System.out.println(number.getNum() + " is " + number.getNumType());
                Assert.assertEquals("Wrong number", "Arabic" ,number.getNumType());
                String result = calculator.getResult();
                System.out.println(number.getNum() + operation + number.getNum() + " = " + result);
            }
            for (String testNumber : testRomeString) {
                RomeNum number = new RomeNum(testNumber);
                Calculator calculator = new Calculator(number, number, operation.charAt(0));
                String result = calculator.getResult();
                Assert.assertEquals("Wrong number", "Rome", number.getNumType());
                System.out.println(testNumber + " is " + number.getNumType());
                RomeNum resNum = new RomeNum(result);
                System.out.println(number.getNum() + operation + number.getNum() + " = " + resNum.toRome());
            }
        }
    }
}
