package ru.borisych;

public class ArabicNum implements Num {
    char number;
    String validChar = "1 2 3 4 5 6 7 8 9 10";

    public ArabicNum(char number) {
        this.number = number;
    }

    public boolean isArabic() {
        int index = validChar.indexOf(String.valueOf(number));
        return index != -1;
    }

    @Override
    public int getNum() {
        return Character.getNumericValue(number);
    }
}
