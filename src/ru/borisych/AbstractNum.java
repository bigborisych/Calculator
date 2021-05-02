package ru.borisych;

public class AbstractNum implements Num {
    private final ArabicNum arabicNum;
    private final RomeNum romanNum;

    private static final String NUM_TYPE = "Abstract";

    public AbstractNum(String number) {
        this.romanNum = new RomeNum(number);
        this.arabicNum = new ArabicNum(number);
    }

    @Override
    public String getNumType() {
        try {
            if (romanNum.getNumType().equals("Roman")) {
                return "Roman";
            } else if (arabicNum.getNumType().equals("Arabic")) {
                return "Arabic";
            } else
                throw new Exception("Неверные числа");
        } catch (Exception e) {
            System.exit(1);
            e.printStackTrace();
            return NUM_TYPE;
        }
    }

    @Override
    public int getNum() {
        try {
            if (romanNum.getNumType().equals("Rome")) {
                return romanNum.getNum();
            } else if (arabicNum.getNumType().equals("Arabic")) {
                return arabicNum.getNum();
            } else
                throw new Exception("Неверные числа");
        } catch (Exception e) {
            System.err.println("Числа введены неверно");
            System.exit(1);
            e.printStackTrace();
            return 0;
        }
    }
}
