package com.剑指offer;

public class L_49 {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        int number = 0;
        int count = 0;
        while (count < n){
            ++number;
            if (IsUgly(number)){
                count++;
            }
        }
        return number;
    }

    private boolean IsUgly(int number){
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;
        return number == 1;
    }
}
