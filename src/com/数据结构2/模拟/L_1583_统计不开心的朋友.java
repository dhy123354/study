package com.数据结构2.模拟;

import java.util.HashSet;
import java.util.Set;

public class L_1583_统计不开心的朋友 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // 用一个HashSet存储不开心的朋友，分组多的时候，会出现重复，剔除重复
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n/2; i++){
            for(int j=i+1; j<n/2; j++){
                if(isUnhappy(n,preferences, pairs[i][0], pairs[i][1], pairs[j][0], pairs[j][1]) || isUnhappy(n,preferences, pairs[i][0], pairs[i][1], pairs[j][1], pairs[j][0])){
                    set.add(pairs[i][0]);
                }
                if(isUnhappy(n,preferences, pairs[i][1], pairs[i][0], pairs[j][0], pairs[j][1]) || isUnhappy(n,preferences, pairs[i][1], pairs[i][0], pairs[j][1], pairs[j][0])){
                    set.add(pairs[i][1]);
                }
                if(isUnhappy(n,preferences, pairs[j][0], pairs[j][1], pairs[i][0], pairs[i][1]) || isUnhappy(n,preferences, pairs[j][0], pairs[j][1], pairs[i][1], pairs[i][0])){
                    set.add(pairs[j][0]);
                }
                if(isUnhappy(n,preferences, pairs[j][1], pairs[j][0], pairs[i][0], pairs[i][1]) || isUnhappy(n,preferences, pairs[j][1], pairs[j][0], pairs[i][1], pairs[i][0])){
                    set.add(pairs[j][1]);
                }
            }
        }
        return set.size();
    }
    // 判断X是否开心
    public boolean isUnhappy(int n, int[][] preferences, int x, int y, int u, int v){
        int close1 = 0, close2 = 0;
        for(int i=0; i<n-1; i++){
            if(preferences[x][i] == y){
                close1 = i;
            }
            if(preferences[x][i] == u){
                close2 = i;
            }
        }
        int close3 = 0, close4 = 0;
        for(int i=0; i<n-1; i++){
            if(preferences[u][i] == v){
                close3 = i;
            }
            if(preferences[u][i] == x){
                close4 = i;
            }
        }
        return (close2 < close1 && close4 < close3);
    }
}
