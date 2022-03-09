package com.数据结构2.动态规划;

import java.util.concurrent.ForkJoinPool;

public class L_10_正则表达式 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        char[] chars  = s.toCharArray();
        char[] chars1 = p.toCharArray();
        boolean[][] dp = new boolean[chars.length + 1][chars1.length + 1];
        dp[0][0] = true;
        for (int i = 0; i <= chars.length; i++) {
            for (int j = 1; j <= chars1.length; j++) {
                if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2] || (i > 0 && chars[i - 1] == chars1[j - 2] || chars1[j - 2] == '.') && dp[i-1][j];
                }else {
                    dp[i][j] = i > 0 && (chars[i -1] == chars1[j - 1] || chars1[j - 1] == '.') && dp[i-1][j-1];
                }
            }
        }
        return dp[chars.length][chars1.length];
    }
}
