package com.数据结构1.Array;

import java.util.*;

public class L_3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int slow = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                slow = Math.max(slow,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - slow + 1);
        }
        return max;
    }
}
