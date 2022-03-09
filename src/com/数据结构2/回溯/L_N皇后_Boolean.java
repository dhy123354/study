package com.数据结构2.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_N皇后_Boolean {
    List<List<String>> list = new ArrayList<List<String>>();
    int[] queens;
    boolean[] cols;
    boolean[] leftTop;
    boolean[] rightTop;

    public List<List<String>> solveNQueens(int n){
        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
        Arrays.fill(queens,-1);
        place(0);
        return list;
    }

    void place(int row){
        if (row == queens.length){
            List<String> list1 = show();
            list.add(list1);
        }
        for (int col = 0; col < queens.length; col++) {
            //剪枝
            if (cols[col]) continue;
            int ltIndex = row - col + queens.length - 1;
            if (leftTop[ltIndex]) continue;
            int rtIndex = row +col;
            if (rightTop[rtIndex]) continue;

            queens[row] = col;
            cols[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            place(row + 1);
            /**
             * boolen类型的回溯需要重置
             */
            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
        }
    }

    public List<String> show(){
        int n = queens.length;
        List<String> a2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]] = 'Q';
            a2.add(new String(row));
        }
        return a2;
    }
}
