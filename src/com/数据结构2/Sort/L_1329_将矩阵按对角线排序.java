package com.数据结构2.Sort;

public class L_1329_将矩阵按对角线排序 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < n; i++) {
            okc(mat,0,i,m,n);
        }

        for (int i = 1; i < m; i++) {
            okc(mat,i,0,m,n);
        }
        return mat;
    }

    public int[][] okc(int[][] mat ,int i, int j, int m, int n){

        for (; i < m - 1 && j <n -1;i++,j++) {
            for (int k = i + 1,p = j + 1;k < m&&p<n; k++,p++){
                if (mat[k][p] < mat[i][j]){
                    int tmp = mat[k][p];
                    mat[k][p] = mat[i][j];
                    mat[i][j] = tmp;
                }
            }
        }
        return mat;
    }
}
