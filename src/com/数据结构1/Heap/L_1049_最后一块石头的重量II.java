package com.数据结构1.Heap;

import java.util.PriorityQueue;

public class L_1049_最后一块石头的重量II {
    public int lastStoneWeightII(int[] stones) {
        int length = stones.length;
        int sum = 0;
        for (int num : stones) {
            sum += num;
        }
        //背包的容量
        int capacity = sum >> 1;
        //dp[i][j]表示前i个石头放进容量为j的背包所能获取的最大重量
        int dp[][] = new int[length + 1][capacity + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= capacity; j++) {
                //如果背包剩余容量能放下石头stones[i - 1]，取把石头stones[i - 1]放进
                //背包和不放进背包的最大值
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    //背包容量已经放不下石头了
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //sum - dp[length][capacity]是一部分，dp[length][capacity]是另一部分，上面
        //capacity的取值是sum >> 1，往下取整，所以前面的肯定不小于后面的，不需要取绝对值
        return (sum - dp[length][capacity]) - dp[length][capacity];
        }
}
