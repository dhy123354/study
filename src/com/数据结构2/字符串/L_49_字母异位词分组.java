package com.数据结构2.字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L_49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if(!map.containsKey(key))    map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
