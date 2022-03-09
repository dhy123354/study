package com.剑指offer;

import java.util.ArrayList;
import java.util.List;

public class L_62 {
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1)return -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int count = 0;
        while (list.size() > 1){
            int temp = (count + m - 1)/list.size();
            list.remove(temp);
            count = temp;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        L_62 l_62 = new L_62();
//        System.out.println(l_62.lastRemaining(5, 2));
        System.out.println(3%5);
    }
}
