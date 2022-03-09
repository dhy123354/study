package com.剑指offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class L_50 {

    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",1);
        map.put("c",1);
        for (Map.Entry<String,Integer> c : map.entrySet()){
            System.out.println(c.getKey());
        }
    }

}
