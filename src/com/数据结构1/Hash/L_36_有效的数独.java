package com.数据结构1.Hash;

import java.util.HashSet;
import java.util.Set;

public class L_36_有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();
        HashSet<Character> squSet = new HashSet<>();
        char rowChar, colChar, squChar;

        for (int i = 0; i < 9; i++) {
            rowSet.clear();
            colSet.clear();
            squSet.clear();
            for (int j = 0; j < 9; j++) {
                rowChar = board[i][j]; // 按行来的字符
                colChar = board[j][i]; // 按列来的字符
                squChar = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3]; // 按方形区域来的字符
                if (rowChar != '.')
                    if (rowSet.contains(rowChar)) return false;
                    else rowSet.add(rowChar);
                if (colChar != '.')
                    if (colSet.contains(colChar)) return false;
                    else colSet.add(colChar);
                if (squChar != '.')
                    if (squSet.contains(squChar)) return false;
                    else squSet.add(squChar);
            }
        }
        return true;
    }
}
