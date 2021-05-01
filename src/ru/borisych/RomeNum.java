package ru.borisych;

public class RomeNum implements Num {
    String number;
    int numberToRome;

    String romeChar = Main.ROME_CHAR;
    private static final String ROME_OUTPUT_CHAR = "I IV V IX X XL L XC C";
    private static final String ARABIC_OUTPUT_CHAR = "1 4 5 9 10 40 50 90 100";

    public RomeNum(String number) {
        this.number = number;
    }

    public RomeNum(int number) {

        numberToRome = number;
    }

    public boolean isNum() {
        return romeChar.contains(number);
    }

    public void toRome() {
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

        System.out.println(result);
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
