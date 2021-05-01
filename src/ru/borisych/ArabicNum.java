package ru.borisych;

public class ArabicNum implements Num {
    String number;

    public ArabicNum(String number) {
        this.number = number;
    }

    public boolean isNum() {
        try {
            if (this.getNum() > 10) {
                throw new Exception(Main.ERROR_WRONG_RANGE_OF_NUMBERS);
            }
        } catch (NumberFormatException e) {
            System.err.println(Main.ERROR_WRONG_NUMBER);
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public int getNum() {
        return Integer.parseInt(number);
    }
}
