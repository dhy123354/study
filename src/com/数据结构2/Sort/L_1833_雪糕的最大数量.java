package com.数据结构2.Sort;

import java.util.Arrays;

public class L_1833_雪糕的最大数量 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int num = 0;
        int sum = 0;
        if (costs[0] > coins) return 0;
//        for (int sum:costs) {
//            if (sum <= coins) {
//                coins-=sum;
//                num++;
//            }
//        }
        for (int i = 0; i < costs.length-1; i++) {
            sum = sum + costs[i];
            if (sum > coins) break;
            else {
                num++;
            }
        }
        return num;
    }
}
