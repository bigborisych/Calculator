package ru.borisych.v2;

public class RomeResult implements Result {
    private final static String RESULT_TYPE = "ROME";
    private static final String ARABIC_CHAR = "1 4 5 9 10 40 50 90 100";
    private static final String ROME_CHAR = "I IV V IX X XL L XC C";
    private String result;

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public String getResultType() {
        return RESULT_TYPE;
    }

    @Override
    public void putResult(Integer result) {
        if (result < 0) {
            this.result = "-" + toRome(Math.abs(result));
        } else {
            this.result = toRome(result);
        }
    }

    private String toRome(Integer result) {
        int bufNumToRome = result;
        String[] romeChars = ROME_CHAR.split(" ");
        String[] arabicChars = ARABIC_CHAR.split(" ");
        StringBuilder romeStringResult = new StringBuilder();
        int i = arabicChars.length - 1;
        while (bufNumToRome > 0) {
            if (bufNumToRome >= Integer.parseInt(arabicChars[i])) {
                romeStringResult.append(romeChars[i]);
                bufNumToRome -= Integer.parseInt(arabicChars[i]);
            } else {
                i--;
            }

        }
        return romeStringResult.toString();
    }
}
