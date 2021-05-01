package ru.borisych;

import static ru.borisych.Main.ERROR_WRONG_RANGE_NUMBER;

public class ArabicNum implements Num {
    String number;
    String arabicChar = Main.ARABIC_CHAR;

    public ArabicNum(String number) {
        this.number = number;
    }

    public boolean isArabic() {
        int index = -1;
        try {
            index = arabicChar.indexOf(String.valueOf(number));
            if (index == -1)
                throw new Exception(ERROR_WRONG_RANGE_NUMBER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index != -1;
    }

    @Override
    public int getNum() {
        return Integer.parseInt(number);
    }
}
