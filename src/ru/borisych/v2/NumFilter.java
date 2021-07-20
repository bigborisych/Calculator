package ru.borisych.v2;

public class NumFilter implements Filter {
    @Override
    public boolean doFilter(int number) {
        return number >= 0 && number <= 10;
    }
}
