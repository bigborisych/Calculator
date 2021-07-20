package ru.borisych.v2;

public class ArabicNum implements Num {
    private static final String NUM_TYPE = "ARABIC";
    private final String number;
    private final Validator validator = new ArabicNumValidator();
    public ArabicNum(String number) {
        this.number = number;
    }

    @Override
    public String getNum() {
        return validator.validateNum(number) ? number : "null";
    }

    @Override
    public String getNumType() {
        return NUM_TYPE;
    }
}
