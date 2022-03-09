package com.路径问题;

public class L_576_出界的路径数 {
    int mod = (int)1e9+7;
    int m ,n , N;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        m = m;
        n = n;
        N = maxMove;

        int[][] f = new int[m * n][N + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) add(i ,j, f);
                if (i == m - 1)add(i, j, f);
                if (j == 0) add(i ,j, f);
                if (j == n - 1)add(i, j, f);
            }
        }

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        // 从小到大枚举「可移动步数」
        for (int step = 1; step <= N; step++) {
            // 枚举所有的「位置」
            for (int k = 0; k < m * n; k++) {
                int x = parse(k)[0], y = parse(k)[1];
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    // 如果位置有「相邻格子」，则「相邻格子」参与状态转移
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        f[k][step] += f[getIndex(nx, ny)][step - 1];
                        f[k][step] %= mod;
                    }
                }
            }
        }

        return f[getIndex(startRow,startColumn)][N];
    }

    void add(int x,int y,int[][] f){
        int idx = getIndex(x,y);
        for (int step = 1; step <= N; step++) {
            f[idx][step]++;
        }
    }

    int getIndex(int x,int y){
        return x * n + y;
    }

    int[] parse(int idx){
        return new int[]{idx / n, idx % n};
    }
}
