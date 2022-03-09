package com.剑指offer;

public class L_43 {

    public int countDigitOne(int n) {
        if (n < 1) return 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += NumberOf(i);
        }
        return count;
    }

    public int NumberOf(int n){
        int number = 0;
        while (n >= 1){
            if (n % 10 == 1)
                number++;
            n /= 10;
        }
        return number;
    }


}
