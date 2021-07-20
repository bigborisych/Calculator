package ru.borisych.v2;

public class ArabicResult implements Result {
    private final static String RESULT_TYPE = "ARABIC";
    private Integer result;

    @Override
    public String getResult() {
        return String.valueOf(result);
    }

    @Override
    public String getResultType() {
        return RESULT_TYPE;
    }

    @Override
    public void putResult(Integer result) {
        this.result = result;
    }
}
