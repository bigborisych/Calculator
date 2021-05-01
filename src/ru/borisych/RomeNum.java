package ru.borisych;

import static ru.borisych.Main.ERROR_WRONG_RANGE_NUMBER;

public class RomeNum implements Num {
    String number;
    int numberToRome;
    String romeChar = Main.ROME_CHAR;
    private static final String ROME_OUTPUT_CHAR = "I IV V IX X XL L XC C";
    private static final String ARABIC_OUTPUT_CHAR = "1 4 5 9 10 40 50 90 100";

    public RomeNum(String number) {
        this.number = number;
    }

    public RomeNum(int numberToRome) {
        this.numberToRome = numberToRome;
    }

    public boolean isRome() {
        int index = -1;
        try {
            index = romeChar.indexOf(String.valueOf(number));
            if (index == -1)
                throw new Exception(ERROR_WRONG_RANGE_NUMBER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index != -1;
    }

    public void toRome() {
        String[] romeChars = ROME_OUTPUT_CHAR.split(Main.SPLIT_SEPARATOR);
        String[] arabicChars = ARABIC_OUTPUT_CHAR.split(Main.SPLIT_SEPARATOR);
        StringBuilder result = new StringBuilder();
        int i = arabicChars.length - 1;
        while (numberToRome > 0) {
            if (numberToRome >= Integer.parseInt(arabicChars[i])) {
                result.append(romeChars[i]);
                numberToRome -= Integer.parseInt(arabicChars[i]);
            } else {
                i--;
            }

        }
        System.out.println(result.toString());
    }

    @Override
    public int getNum() {
        String[] romeChars = romeChar.split(Main.SPLIT_SEPARATOR);
        for (int i = 0; i <= 9; i++) {
            if (number.equals(romeChars[i])) {
                return i + 1;
            }
        }
        return 0;
    }
}
