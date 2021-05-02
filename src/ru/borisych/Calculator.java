package ru.borisych;

public class Calculator {
    private final Num numberOne;
    private final Num numberTwo;
    private int result;
    private final char operation;

    public Calculator(Num numberOne, Num numberTwo, char operation) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.operation = operation;
    }

    public String getResult() {
        switch (operation) {
            case '+' -> result = numberOne.getNum() + numberTwo.getNum();
            case '-' -> result = numberOne.getNum() - numberTwo.getNum();
            case '*' -> result = numberOne.getNum() * numberTwo.getNum();
            case '/' -> result = numberOne.getNum() / numberTwo.getNum();
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
