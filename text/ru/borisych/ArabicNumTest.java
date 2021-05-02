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
            System.out.println(number.getNum() + " is Arabic - " + number.isNum());
            Assert.assertTrue("Wrong number", number.isNum());
        }
        for (String testNumber : testRomeString) {
            RomeNum number = new RomeNum(testNumber);
            RomeNum numberToRome = new RomeNum(number.getNum());
            Assert.assertTrue("Wrong number", number.isNum());
            System.out.println(numberToRome.toRome() + " is Rome - " + number.isNum());
        }

    }
}
