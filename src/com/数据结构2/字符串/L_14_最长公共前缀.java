package com.数据结构2.字符串;

import javax.swing.*;

public class L_14_最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        String ans = strs[0];
        for (int i = 0;i < strs.length; i++){
            int j = 0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals(""))
                return ans;
        }
        return ans;
    }
}
