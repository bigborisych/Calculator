package ru.borisych;

public class AbstractNum implements Num {
    private final ArabicNum arabicNum;
    private final RomeNum romanNum;
    public final static  String ROME_TYPE = "Rome";
    public final static  String ARABIC_TYPE = "Arabic";
    private static final String NUM_TYPE = "Abstract";

    public AbstractNum(String number) {
        this.romanNum = new RomeNum(number);
        this.arabicNum = new ArabicNum(number);
    }

    @Override
    public String getNumType() {

        if (romanNum.getNumType().equals(ROME_TYPE)) {
            return ROME_TYPE;
        } else if (arabicNum.getNumType().equals(ARABIC_TYPE)) {
            return ARABIC_TYPE;
        } else
            return NUM_TYPE;

    }

    @Override
    public int getNum() {
        try {
            if (romanNum.getNumType().equals(ROME_TYPE)) {
                return romanNum.getNum();
            } else if (arabicNum.getNumType().equals(ARABIC_TYPE)) {
                return arabicNum.getNum();
            } else
                throw new Exception();
        } catch (Exception e) {
            System.err.println(Main.ERROR_INPUT_STRING);
            e.printStackTrace();
            System.exit(1);
            return 0;
        }
    }
}
