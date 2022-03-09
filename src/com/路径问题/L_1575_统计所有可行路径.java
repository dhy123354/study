package com.路径问题;

import 数据结构2.Graph.Graph;

import java.util.Arrays;

public class L_1575_统计所有可行路径 {
    //记忆化搜索
    /*
        我们知道，如果要实现 DFS 的话，通常有以下几个步骤：
        1.设计好递归函数的「入参」和「出参」
        2.设置好递归函数的出口（Base Case）
        3.编写「最小单元」处理逻辑
        对于大多数的 DFS 来说，第 1 步和第 3 步都很好实现，而找 Base Case 通常是三部曲中最难的。
     */
    int mod = 1000000007;

    int[][] cache;

    public int countRoutes1(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        // 初始化缓存器
        // 之所以要初始化为 -1
        // 是为了区分「某个状态下路径数量为 0」和「某个状态尚未没计算过」两种情况
        cache = new int[n][fuel + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }

        return dfs(locations, start, finish, fuel);
    }

    /**
     * @param locations 入参 locations
     * @param u         当前所在位置（ls 的下标）
     * @param end       目标哦位置（ls 的下标）
     * @param fuel      剩余油量
     * @return 在位置 u 出发，油量为 fuel 的前提下，到达 end 的「路径数量」
     */
    int dfs(int[] locations, int u, int end, int fuel) {
        if (cache[u][fuel] != -1) {
            return cache[u][fuel];
        }

        int need = Math.abs(locations[u] - locations[end]);
        if (need > fuel) {
            cache[u][fuel] = 0;
            return 0;
        }
        int n = locations.length;
        int sum = u == end ? 1 : 0;
        for (int i = 0; i < n; i++) {
            if (i != u) {
                need = Math.abs(locations[i] - locations[u]);
                if (fuel >= need) {
                    sum += dfs(locations, i, end, fuel - need);
                    sum &= mod;
                }
            }
        }
        cache[u][fuel] = sum;
        return sum;
    }

    //动态规划
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;

        int[][] f = new int[n][fuel + 1];

        for (int i = 0; i < fuel; i++) f[finish][i] = 1;
        // 从状态转移方程可以发现 f[i][fuel]=f[i][fuel]+f[k][fuel-need]
        // 在计算 f[i][fuel] 的时候依赖于 f[k][fuel-need]
        // 其中 i 和 k 并无严格的大小关系
        // 而 fuel 和 fuel-need 具有严格大小关系：fuel >= fuel-need
        // 因此需要先从小到大枚举油量

        for (int cur = 0; cur <= fuel; cur++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j){
                        int need = Math.abs(locations[i] - locations[j]);
                        if (cur >= need){
                            f[i][cur] += f[j][cur - need];
                            f[i][cur] %= mod;
                        }
                    }
                }
            }
        }
        return f[start][fuel];
    }
}
