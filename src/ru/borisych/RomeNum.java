package ru.borisych;

public class RomeNum implements Num {
    String number;
    String romeChar = Main.ROME_CHAR;

    public RomeNum(String number) {
        this.number = number;
    }

    public boolean isRome() {
        int index = romeChar.indexOf(String.valueOf(number));
        return index != -1;
    }

    public void toRome() {

    }

    @Override
    public int getNum() {
        String[] romeChars = romeChar.split(" ");
        for (int i = 0; i <= 9; i++) {
            if (number.equals(romeChars[i])) {
                return i + 1;
            }
        }
        return 0;
    }
}
