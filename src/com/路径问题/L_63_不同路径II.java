package com.路径问题;

//学习网站
//https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247485089&idx=1&sn=fd52fd088a5778c9ee101741d458605d&chksm=fd9cadbecaeb24a8f2115139f438fed36cddd96d00d5249d661684faf33b9874e62883720ae6&scene=178&cur_album_id=1773144264147812354#rd


public class L_63_不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] a = new int[m][n];
        a[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != 1){
                    if (i > 0 && j > 0) {
                        a[i][j] = a[i - 1][j] + a[i][j - 1];
                    } else if (j > 0) {
                        a[i][j] = a[i][j - 1];
                    } else if (i > 0) {
                        a[i][j] = a[i - 1][j];
                    }
                }
            }
        }
        return a[m - 1][n - 1];
    }
}
