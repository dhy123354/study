package com.数据结构2.回溯;

import java.util.ArrayList;
import java.util.List;

public class L_17_电话号码的字母组合 {
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    List<String> list = new ArrayList<>();
    StringBuffer temp = new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return list;
        }
        place(digits,letterMap,0);
        return list;
    }

    public void place(String digits,String[] letterMap,int cow){
        if (cow == digits.length()){
            list.add(temp.toString());
            return;
        }

        String str = letterMap[digits.charAt(cow) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            place(digits,letterMap,cow + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
