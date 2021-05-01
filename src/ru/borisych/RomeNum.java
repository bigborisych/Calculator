package ru.borisych;

public class RomeNum implements Num{
    char number;
    String validChar = "I II III IV V VI VII VIII IX X";
    public RomeNum(char number){
        this.number = number;
    }
    public boolean isRome() {
        int index = validChar.indexOf(String.valueOf(number));
        return index != -1;
    }
    @Override
    public int getNum() {
        return 0;
    }
}
