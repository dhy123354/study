package com.剑指offer;

public class L_12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[0].length; i1++) {
                if (place(words,board,1,1,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean place(char[] word,char[][] board,int i,int j,int k){
       if (i >= board.length || i < 0 || j >= board[0].length || j<0
       ||board[i][j] != word[k]){
           return false;
       }
       if (k == word.length - 1) return true;
       board[i][j] = '\0';
       boolean res = place(word,board,i + 1,j,k + 1) || place(word,board,i ,j+ 1,k + 1)
               ||place(word,board,i - 1,j,k + 1) || place(word,board,i ,j -  1,k + 1);
       board[i][j] = word[k];
       return res;
    }
}
