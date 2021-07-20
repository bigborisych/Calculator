package ru.borisych.v2;

public interface Operation {
    Result processNums(Num numOne, Num numTwo);
    String getOperator();
}
