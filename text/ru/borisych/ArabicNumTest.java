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
            Assert.assertEquals("Wrong number", "Rome" ,number.getNumType());
        }
        for (String testNumber : testRomeString) {
            RomeNum number = new RomeNum(testNumber);
            RomeNum numberToRome = new RomeNum(testNumber);
            Assert.assertEquals("Wrong number", "Arabic", number.getNumType());
            System.out.println(numberToRome.toRome() + " is " + number.getNumType());
        }

    }
}
