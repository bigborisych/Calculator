package ru.borisych;

public class ArabicNum implements Num {
    String number;
    String arabicChar = Main.ARABIC_CHAR;

    public ArabicNum(String number) {
        this.number = number;
    }

    public boolean isArabic() {
        int index = arabicChar.indexOf(String.valueOf(number));
        return index != -1;
    }

    @Override
    public int getNum() {
        return Integer.parseInt(number);
    }
}
