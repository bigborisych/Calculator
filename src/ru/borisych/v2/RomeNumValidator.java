package ru.borisych.v2;

import java.util.Arrays;

public class RomeNumValidator implements Validator {
    private static final String ROME_CHAR = "I IV V IX X XL L XC C";
    @Override
    public boolean validateNum(String num) {
       return Arrays.stream(ROME_CHAR.split(" ")).anyMatch(num::contains);
    }
}
