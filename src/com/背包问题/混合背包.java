package com.背包问题;

import java.util.ArrayList;
import java.util.List;

public class 混合背包 {
    public int maxValue(int N, int C, int[] w, int[] v, int[] s) {
        // 构造出物品的「价值」和「体积」列表
        List<Integer> worth = new ArrayList<>();
        List<Integer> volume = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int type = s[i];

            // 多重背包：应用「二进制优化」转换为 0-1 背包问题
            if (type > 0) {
                for (int k = 1; k <= type; k *= 2) {
                    type -= k;
                    worth.add(w[i] * k);
                    volume.add(v[i] * k);
                }
                if (type > 0) {
                    worth.add(w[i] * type);
                    volume.add(v[i] * type);
                }

                // 01 背包：直接添加
            } else if (type == -1) {
                worth.add(w[i]);
                volume.add(v[i]);

                // 完全背包：对 worth 做翻转进行标记
            } else {
                worth.add(-w[i]);
                volume.add(v[i]);
            }
        }

        // 使用「一维空间优化」方式求解三种背包问题
        int[] dp = new int[C + 1];
        for (int i = 0; i < worth.size(); i++) {
            int wor = worth.get(i);
            int vol = volume.get(i);

            // 完全背包：容量「从小到大」进行遍历
            if (wor < 0) {
                for (int j = vol; j <= C; j++) {
                    // 同时记得将 worth 重新翻转为正整数
                    dp[j] = Math.max(dp[j], dp[j - vol] - wor);
                }

                // 01 背包：包括「原本的 01 背包」和「经过二进制优化的完全背包」
                // 容量「从大到小」进行遍历
            } else {
                for (int j = C; j >= vol; j--) {
                    dp[j] = Math.max(dp[j], dp[j - vol] + wor);
                }
            }
        }
        return dp[C];
    }
}
