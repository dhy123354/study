package com.路径问题;

public class L_931_下降路径最小和 {
    public int minFallingPathSum(int[][] mat){
        int n = mat.length;

        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[0][i] = mat[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = mat[i][j];
                f[i][j] = f[i - 1][j] + val;
                if (j > 0) f[i][j] = Math.min(f[i][j],f[i - 1][j - 1]);
                if (j < n - 1)f[i][j] = Math.min(f[i][j],f[i - 1][j + 1]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans,f[n - 1][i]);
        }

        return ans;
    }
}
