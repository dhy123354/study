package com.路径问题;

public class L_64_最小路径和 {
    public int minPathSum1(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j ==0){
                    f[i][j] = grid[i][j];
                }else {
                    int top  = i - 1 >= 0 ? f[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int left = j - 1 >= 0 ? f[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
                    f[i][j] = Math.min(top, left);
                }
            }
        }
        return f[m - 1][n - 1];
    }

    public int minPathSum(int[][] grid){
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i - 1][j],f[i][j - 1]) + grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
