package ru.borisych.v2;

public class RomeNum implements Num {
    private static final String NUM_TYPE = "ROME";
    private static final String ARABIC_CHAR = "1 4 5 9 10 40 50 90 100";
    private static final String ROME_CHAR = "I IV V IX X XL L XC C";
    private final String number;
    private final Validator validator = new RomeNumValidator();

    public RomeNum(String number) {
        this.number = number;
    }

    @Override
    public String getNum() {
        return validator.validateNum(number) ? toArabic(number) : "null";
    }

    @Override
    public String getNumType() {
        return NUM_TYPE;
    }

    private String toArabic(String number) {
        String bufNumToArabic = number;
        String[] romeChars = ROME_CHAR.split(" ");
        String[] arabicChars = ARABIC_CHAR.split(" ");
        int result = 0;
        for (int i = arabicChars.length - 1; i >= 0; i--) {
            while (bufNumToArabic.indexOf(romeChars[i]) == 0 && romeChars[i].length() > 0) {
                result += Integer.parseInt(arabicChars[i]);
                bufNumToArabic = bufNumToArabic.substring(romeChars[i].length());
            }
        }
        return String.valueOf(result);
    }
}
