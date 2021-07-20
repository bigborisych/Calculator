package ru.borisych.v2;

import java.util.Arrays;

public class ArabicNumValidator implements Validator {
    public static final String ARABIC_CHAR = "0 1 2 3 4 5 6 7 8 9";

    @Override
    public boolean validateNum(String num) {
        return Arrays.stream(ARABIC_CHAR.split(" ")).anyMatch(num::contains);
    }
}
