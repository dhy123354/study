package com.数据结构2.回溯;

import com.sun.media.sound.AiffFileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L_51_N皇后 {
    List<List<String>> list = new ArrayList<>();
    char[][] a1;

    public List<List<String>> solveNQueens(int n) {
        a1 = new char[n][n];
        for (char[] line : a1) Arrays.fill(line , '.');
        place(0);
        return list;
    }

    void place(int row){
        if (row == a1.length){
            List<String> list1 = new ArrayList<>();
            for (char[] s : a1) list1.add(String.valueOf(s));
            list.add(list1);
        }
        for (int col = 0; col < a1.length; col++){
            if (!isValid(row,col))
                continue;
            a1[row][col] = 'Q';
            place(row + 1);
            a1[row][col] = '.';
        }
    }

    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++)
            if (a1[i][col] == 'Q')
                return false;
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; --i, --j)
            if(a1[i][j] == 'Q')
                return false;
        for(int i = row-1, j = col+1; i >= 0 && j < a1.length; --i, ++j)
            if(a1[i][j] == 'Q')
                return false;
        return true;
    }


}
