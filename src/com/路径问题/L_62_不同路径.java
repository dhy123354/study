package com.路径问题;

//学习网站
//https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485037&idx=1&sn=d6d52c48600e655161e84f25d3402514&scene=21#wechat_redirect

public class L_62_不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] a = new int[m][n];
        a[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0){
                    a[i][j] = a[i - 1][j] + a[i][j - 1];
                }else if (j > 0){
                    a[i][j] = a[i][j - 1];
                }else if (i > 0){
                    a[i][j] = a[i - 1][j];
                }
            }
        }
        return a[m - 1][n - 1];
    }
}
