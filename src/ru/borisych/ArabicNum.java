package ru.borisych;

public class ArabicNum implements Num {
    String number;
    String arabicChar = Main.ARABIC_CHAR;

    public ArabicNum(String number) {
        this.number = number;
    }

    public boolean isNum() {
        return arabicChar.contains(number);
    }

    @Override
    public int getNum() {
            return Integer.parseInt(number);
    }
}
