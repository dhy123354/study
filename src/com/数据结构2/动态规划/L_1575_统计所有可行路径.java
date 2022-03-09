package com.数据结构2.动态规划;

import java.util.Arrays;

public class L_1575_统计所有可行路径 {
    int mod = 1000000007;
    int cache[][];

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int[][] dp = new int[n][fuel + 1];
        for (int i = 0; i < fuel; i++) {
            dp[finish][i] = 1;
        }

        for (int cur = 0; cur <= fuel; cur++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (i != k){
                        int need = Math.abs(locations[i] - locations[k]);
                        if (cur >= need){
                            dp[i][cur] += dp[k][cur - need];
                            dp[i][cur] %= mod;
                        }
                    }
                }
            }
        }
        return dp[start][fuel];
    }


        public int countRoutes1(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        cache = new int[n][fuel + 1];
        for (int i = 0; i < locations.length; i++) {
            Arrays.fill(cache[i],-1);
        }
        return dfs(locations,start,finish,fuel);
    }

    public int dfs(int[] location,int row, int finsh,int fuel){
        if (cache[row][fuel] != -1){
            return cache[row][fuel];
        }

        int need = Math.abs(location[finsh] - location[row]);
        if (need > fuel){
            cache[row][finsh] = 0;
            return 0;
        }

        int sum = row == finsh ? 1 : 0;
        for (int i = 0; i < location.length; i++) {
            if (i != row){
                need = Math.abs(location[i] - location[finsh]);
                if (finsh >= need){
                    sum += dfs(location, i, finsh, fuel - need);
                    sum %= mod;
                }
            }
        }
        cache[row][fuel] = sum;
        return sum;
    }
}
