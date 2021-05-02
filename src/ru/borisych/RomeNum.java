package ru.borisych;

public class RomeNum implements Num {
    private String number;
    private static int numberToRome;
    private static String ROME_TYPE = "RomeType";
    String romeChar = Main.ROME_CHAR;
    private static final String ROME_OUTPUT_CHAR = "I IV V IX X XL L XC C";
    private static final String ARABIC_OUTPUT_CHAR = "1 4 5 9 10 40 50 90 100";

    public RomeNum(String number) {
        this.number = number;
    }

    public RomeNum(int number) {
        numberToRome = number;
    }

    public String getNumType() {
        String[] romeChars = romeChar.split(Main.SPLIT_SEPARATOR);
        for (String romeChar : romeChars) {
            if (number.contains(romeChar)) {
                return ROME_TYPE;
            }
        }
        return "WrongType";
    }

        /*
        try {
            if (romeChar.contains(number)) {
                return true;
            }else if(this.getNum() > 10 || this.getNum() < 1){
                throw new Exception(Main.ERROR_WRONG_RANGE_OF_NUMBERS);
            }else{
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.err.println(Main.ERROR_WRONG_NUMBER);
            System.exit(1);
            return false;
        } catch (Exception e) {
            System.exit(1);
            e.printStackTrace();
            return false;
        }*/

    public String toRome() {
        String[] romeChars = ROME_OUTPUT_CHAR.split(Main.SPLIT_SEPARATOR);
        String[] arabicChars = ARABIC_OUTPUT_CHAR.split(Main.SPLIT_SEPARATOR);
        StringBuilder result = new StringBuilder();
        int i = arabicChars.length - 1;
        while (numberToRome > 0) {
            if (numberToRome >= Integer.parseInt(arabicChars[i])) {
                result.append(romeChars[i]);
                numberToRome -= Integer.parseInt(arabicChars[i]);
            } else {
                i--;
            }

        }

        return result.toString();
    }

    @Override
    public int getNum() {
        String[] romeChars = ROME_OUTPUT_CHAR.split(Main.SPLIT_SEPARATOR);
        String[] arabicChars = ARABIC_OUTPUT_CHAR.split(Main.SPLIT_SEPARATOR);
        StringBuilder result = new StringBuilder();
        for (int i = arabicChars.length-1; i >= 0; i-- ) {
            while (number.indexOf(romeChars[i]) == 0 && romeChars[i].length() > 0) {
                result.append(arabicChars[i]);
                number = number.substring(romeChars[i].length());
            }
        }
        return Integer.parseInt(result.toString());
    }
}
