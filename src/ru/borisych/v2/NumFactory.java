package ru.borisych.v2;

import java.util.List;

public class NumFactory {
    Num getNum(String number){
        List<Num> numList = List.of(new ArabicNum(number), new RomeNum(number));
        return numList.stream().filter(num -> !(num.getNum().equals("null"))).findFirst().orElse(null);
    }
}
