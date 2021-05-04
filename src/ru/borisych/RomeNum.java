package ru.borisych;

public class RomeNum implements Num {
    private final String number;
    private final int numberToRome;
    private static final String NUM_TYPE = AbstractNum.ROME_TYPE;
    private static final String ROME_OUTPUT_CHAR = "I IV V IX X XL L XC C";
    private static final String ARABIC_OUTPUT_CHAR = "1 4 5 9 10 40 50 90 100";

    public RomeNum(String number) {
        this.number = number;
        this.numberToRome = getNum();
    }

    public String getNumType() {
        String[] romeChars = Main.ROME_CHAR.split(Main.SPLIT_SEPARATOR);
        for (String romeChar : romeChars) {
            if (number.contains(romeChar)) {
                return NUM_TYPE;
            }
        }
        return "0";
    }

    public String toRome() {
        int bufNumToRome = numberToRome;
        String[] romeChars = ROME_OUTPUT_CHAR.split(Main.SPLIT_SEPARATOR);
        String[] arabicChars = ARABIC_OUTPUT_CHAR.split(Main.SPLIT_SEPARATOR);
        StringBuilder result = new StringBuilder();
        int i = arabicChars.length - 1;
        while (bufNumToRome > 0) {
            if (bufNumToRome >= Integer.parseInt(arabicChars[i])) {
                result.append(romeChars[i]);
                bufNumToRome -= Integer.parseInt(arabicChars[i]);
            } else {
                i--;
            }

        }

        return result.toString();
    }

    @Override
    public int getNum() {
        int result = 0;
        if (getNumType().equals("0")) {
            result = Integer.parseInt(number);
        } else if (getNumType().equals(NUM_TYPE)) {
            for(String chars:Main.ROME_CHAR.split(Main.SPLIT_SEPARATOR)){
                if(number.equals(chars)){
                    return toArabic(chars);
                }
            }
        }
        return result;
    }

    private int toArabic(String number) {
        String bufNumToArabic = number;
        String[] romeChars = ROME_OUTPUT_CHAR.split(Main.SPLIT_SEPARATOR);
        String[] arabicChars = ARABIC_OUTPUT_CHAR.split(Main.SPLIT_SEPARATOR);
        int result = 0;
        for (int i = arabicChars.length - 1; i >= 0; i--) {
            while (bufNumToArabic.indexOf(romeChars[i]) == 0 && romeChars[i].length() > 0) {
                result += Integer.parseInt(arabicChars[i]);
                bufNumToArabic = bufNumToArabic.substring(romeChars[i].length());
            }
        }
        return result;
    }
}
