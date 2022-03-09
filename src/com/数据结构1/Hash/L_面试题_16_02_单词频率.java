package com.数据结构1.Hash;

import java.util.HashMap;
import java.util.Map;

public class L_面试题_16_02_单词频率 {
    class WordsFrequency {

        private Map<String, Integer> map = new HashMap<>();

        public WordsFrequency(String[] book) {
            for (String c : book){
                map.put(c,map.getOrDefault(c,0) + 1);
            }
        }

        public int get(String word) {
            if (!map.containsKey(word)) return 0;
            return map.get(word);
        }
    }
}
