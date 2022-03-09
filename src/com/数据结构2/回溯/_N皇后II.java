package com.数据结构2.回溯;

public class _N皇后II {
    boolean[] cols;
    boolean[] leftTop;
    boolean[] rightTop;
    int weight;

    public int totalNQueens(int n) {
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        weight = 0;
        place(0);
        return weight;
    }

    public void place(int row){
        if (row == cols.length){
            weight++;
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (cols[col]) continue;
            int leftIndex = row - col + cols.length - 1;
            if (leftTop[leftIndex]) continue;
            int rightIndex = row  + col;
            if (rightTop[rightIndex])continue;

            cols[col] = true;
            leftTop[leftIndex] = true;
            rightTop[rightIndex] = true;
            place(row + 1);
            cols[col] = false;
            leftTop[leftIndex] = false;
            rightTop[rightIndex] = false;
        }
    }
}
