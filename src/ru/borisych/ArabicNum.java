package ru.borisych;

public class ArabicNum implements Num {
    private final String number;
    private static final String arabicChar = Main.ARABIC_CHAR;

    public ArabicNum(String number) {
        this.number = number;
    }

    @Override
    public String getNumType() {
        return "arabicChar.contains(number)";
       /* try {
            if (arabicChar.contains(number)) {
                return true;
            }else if(this.getNum() > 10 || this.getNum() < 1){
                throw new Exception(Main.ERROR_WRONG_RANGE_OF_NUMBERS);
            }else{
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.err.println(Main.ERROR_WRONG_NUMBER);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }*/
    }

    @Override
    public int getNum() {
        String[] arabicNumbers = Main.ARABIC_CHAR.split(Main.SPLIT_SEPARATOR);
        String num = "0";
        if (number.contains(num)) {
            return Integer.parseInt(number);
        } else {
            for (String arabicNumber:arabicNumbers) {
                if (number.contains(arabicNumber)) {
                    return Integer.parseInt(number);
                }
            }
        }
        return 0;
    }
}
