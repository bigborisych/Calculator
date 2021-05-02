package ru.borisych;

public class Calculator {
    private final int numberOne;
    private final int numberTwo;
    private int result;
    private final char operation;

    public Calculator(int numberOne, int numberTwo, char operation) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.operation = operation;
    }

    public String getResult() {
        switch (operation) {
            case '+' -> result = numberOne + numberTwo;
            case '-' -> result = numberOne - numberTwo;
            case '*' -> result = numberOne * numberTwo;
            case '/' -> result = numberOne / numberTwo;
        }
        return String.valueOf(result);
    }
    private String getNumbers(){
        /*try {
            if (arabicNum.isNum()) {
                return new ArabicNum(number);
            }else if(romanNum.isNum()){
                return new RomeNum(number);
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
        }
        return

    */
    return "fdasf";
    }
}
