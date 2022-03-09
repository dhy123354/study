package com.数据结构1.Queue;

public class jiqi {
    public int calculate(String s){
        int x = 1;
        int y = 0;
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i)=='A'){
                x = 2 * x + y;
            }
            if (s.charAt(i)=='B'){
                y = 2 * y + x;
            }
        }
        return y+x;
    }
}
