package ru.borisych;

public class ArabicNum implements Num {
    private final String number;
    private static final String NUM_TYPE = "Arabic";

    public ArabicNum(String number) {
        this.number = number;
    }

    @Override
    public String getNumType() {
        String[] arabicNumbers = Main.ARABIC_CHAR.split(Main.SPLIT_SEPARATOR);
        for (String arabicNumber : arabicNumbers) {
            if (number.contains(arabicNumber)) {
                return NUM_TYPE;
            }
        }
        return "0";
    }

    @Override
    public int getNum() {
        String[] arabicNumbers = Main.ARABIC_CHAR.split(Main.SPLIT_SEPARATOR);
        for (String arabicNumber : arabicNumbers) {
            if (number.contains(arabicNumber)) {
                return  Integer.parseInt(number);
            }
        }
        return 0;
    }
}
