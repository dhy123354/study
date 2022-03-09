package com.剑指offer;

public class L_47 {
    public int maxValue(int[][] grid) {
        if (grid == null) return 0;
        int[][]  dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j - 1 >= 0)
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                if (j == 0 && i - 1 >= 0)
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                if (i >= 1 && j >= 1)
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length- 1][grid[0].length - 1];
    }
}
