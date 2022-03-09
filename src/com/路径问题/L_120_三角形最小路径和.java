package com.路径问题;

import java.util.List;

public class L_120_三角形最小路径和 {
    public int minimumTotal1(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] f = new int[m][m];
        f[0][0] = triangle.get(0).get(0);

        for (int i = 1; i <  m; i++) {
            for (int j = 0; j < i + 1; j++) {
                int val = triangle.get(i).get(j);
                f[i][j] = Integer.MAX_VALUE;
                if (j != 0) f[i][j] = Math.min(f[i][j],f[i - 1][j - 1] + val);
                if (j != i) f[i][j] = Math.min(f[i][j], f[i - 1][j] + val);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans,f[m - 1][i]);
        }
        return ans;
    }

    public int minimumTotal2(List<List<Integer>> triangle){
        if (triangle == null || triangle.size() == 0) return 0;

        int[][] f = new int[triangle.size() + 1][triangle.size() + 1];

        for (int i = triangle.size()-1; i>=0; i--){
            List<Integer> curTr = triangle.get(i);
            for(int j = 0 ; j< curTr.size(); j++){
                f[i][j] = Math.min(f[i+1][j], f[i+1][j+1]) + curTr.get(j);
            }
        }
        return f[0][0];
    }
}
