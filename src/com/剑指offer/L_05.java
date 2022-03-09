package com.剑指offer;

public class L_05 {
    public String replaceSpace(String s) {
        if (s == null)return s;
        int len = s.length(),i = 0;
        StringBuffer NewS = new StringBuffer();
        int index = 0;
        while (i < len){
            if (s.charAt(i) == ' '){
                NewS.append(s.substring(index,i)).append("%20");
                index = i + 1;
            }
            i++;
        }
        NewS.append(s.substring(index,len));
        s = NewS.toString();
        return s;
    }
}
