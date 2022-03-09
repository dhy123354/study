package com.数据结构1.Hash;

import java.util.HashSet;
import java.util.Set;

public class L_771_宝石与石头 {
    public int numJewelsInStones(String jewels, String stones) {
        int num = 0;
        Set<Character> set = new HashSet<>();
        for (char ch : jewels.toCharArray()){
            set.add(ch);
        }

        for (char ch :stones.toCharArray()){
            if (set.contains(ch)){
                num ++;
            }
        }
        return num;
    }
}
