package com.数据结构2.回溯;

import java.util.ArrayList;
import java.util.List;

public class L_216_组合总和III {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n == 0 || k == 0) return list;

        place(1,k,n);
        return list;
    }

    void place(int row,int k, int n){
        if (n < 0) return;
        if (list1.size() == k && n == 0){
            list.add(new ArrayList<>(list1));
        }
        for (int i = row; i <= 9; i++) {
            list1.add(i);
            place(i + 1,k ,n - i);
            list1.remove(list1.size() - 1);
        }

    }

}
