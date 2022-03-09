package com.数据结构1.Tire;

import java.util.ArrayList;
import java.util.List;

public class L_1638_统计只差一个字符的子串数目 {
    class Solution {
        public int countSubstrings(String s, String t) {
            int ans=0;
            for(int size=1;size<=Math.min(s.length(),t.length());size++){
                List<String> l1=new ArrayList();
                List<String> l2=new ArrayList();
                for(int i=0;i<=s.length()-size;i++){l1.add(s.substring(i,i+size));}
                for(int i=0;i<=t.length()-size;i++){l2.add(t.substring(i,i+size));}
                for(String a:l1){
                    for(String b:l2){
                        if(oneLetterDif(a,b)){ans++;}
                    }
                }
            }
            return ans;
        }
        public boolean oneLetterDif(String a,String b){
            if(a.equals(b)){return false;}
            for(int i=0;i<a.length();i++){
                if(a.charAt(i)!=b.charAt(i)){
                    for(int j=i+1;j<a.length();j++){
                        if(a.charAt(j)!=b.charAt(j)){return false;}
                    }
                }
            }
            return true;
        }
    }
}
