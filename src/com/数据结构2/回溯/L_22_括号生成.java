package com.数据结构2.回溯;

import javax.naming.event.NamingListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_22_括号生成 {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        place(n,n,"");
        return list;
    }

    public void place(int left, int right,String row){
        if (left == 0 && right == 0){
            list.add(row);
            return;
        }
        if(left > 0){
            place(left - 1,right,row + "(");
        }
        if (right > left){
            place(left,right - 1,row + ")");
        }
    }
}
