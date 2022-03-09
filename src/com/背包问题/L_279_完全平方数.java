package com.背包问题;

import sun.text.resources.en.FormatData_en_IE;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class L_279_完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i =  1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
