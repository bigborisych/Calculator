package ru.borisych;

public class AbstractNum implements Num{
    private final ArabicNum arabicNum;
    private final RomeNum romanNum;

    public AbstractNum(String number){
        this.romanNum = new RomeNum(number);
        this.arabicNum = new ArabicNum(number);
    }
    @Override
    public String getNumType() {
        return "false";
    }

    @Override
    public int getNum() {
        return 0;
    }
    private Num getAbstractNum(){
           return arabicNum;
    }
}
