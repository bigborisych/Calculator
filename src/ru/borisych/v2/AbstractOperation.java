package ru.borisych.v2;

import java.util.List;

public abstract class AbstractOperation implements Operation{
    private final static String OPERATOR = "";
    private final static List<Result> resultList = List.of(new ArabicResult(), new RomeResult());
    private final static Filter filter = new NumFilter();
    @Override
    public Result processNums(Num numOne, Num numTwo) {
        if(!(filter.doFilter(Integer.parseInt(numOne.getNum())) && filter.doFilter(Integer.parseInt(numTwo.getNum())))){
            return null;
        }
        Integer resultSum = doOperation(Integer.parseInt(numOne.getNum()) ,Integer.parseInt(numTwo.getNum()));
        Result resultOut = resultList.stream()
                .filter(result -> result.getResultType().contains(numOne.getNumType()) && result.getResultType().contains(numTwo.getNumType()))
                .findFirst().orElse(null);
        if (resultOut != null) {
            resultOut.putResult(resultSum);
        } else {
            System.out.println("Хуита");
        }
        return resultOut;
    }

    @Override
    public String getOperator() {
        return OPERATOR;
    }

    abstract int doOperation(int numberOne, int numberTwo);
}
