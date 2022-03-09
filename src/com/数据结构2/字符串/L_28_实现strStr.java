package com.数据结构2.字符串;

public class L_28_实现strStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null && needle == null) return 0;
        int i = 0;
        while (i + needle.length() < haystack.length()){
            if (haystack.substring(i,i + needle.length()).equals(needle)){
                return i;
            }
            i++;
        }
        return -1;
    }
}
