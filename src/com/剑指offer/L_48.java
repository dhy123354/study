package com.剑指offer;

public class L_48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        int max = 0,index = 0;
        for (int i = 1; i < len; i++) {
            index = i - 1;
            while (index >= 0 && s.charAt(i) != s.charAt(index))index--;
            if (i - index <= dp[i - 1])
                dp[i] = i - index;
            else
                dp[i] = dp[i - 1] + 1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        L_48 l_48 = new L_48();
        l_48.lengthOfLongestSubstring("abcabcbb");
    }
}


