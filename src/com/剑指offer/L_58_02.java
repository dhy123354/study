package com.剑指offer;

public class L_58_02 {

    public String reverseLeftWords(String s, int n) {
        StringBuffer sb = new StringBuffer();
        System.out.println(s.substring(0,n));
        //sb.append(s.substring(n,s.length()-1)).append(reverseWords(s.substring(0,n)));
        sb.append(s.substring(n,s.length())).append(s.substring(0,n));
        return sb.toString();
    }

    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i > 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        L_58_02 l_58 = new L_58_02();
        System.out.println(l_58.reverseLeftWords("abcdefg",2));
    }
}
