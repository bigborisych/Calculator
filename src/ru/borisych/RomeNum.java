package ru.borisych;

public class RomeNum implements Num{
    String number;
    String romeChar = Main.ROME_CHAR;
    public RomeNum(String number){
        this.number = number;
    }
    public boolean isRome() {
        int index = romeChar.indexOf(String.valueOf(number));
        return index != -1;
    }
    @Override
    public int getNum() {
        return 0;
    }
}
