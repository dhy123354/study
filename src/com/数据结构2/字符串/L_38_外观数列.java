package com.数据结构2.字符串;

public class L_38_外观数列 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String str = countAndSay(n - 1);
        StringBuffer sb = new StringBuffer();
        int fast = 0,slow = 0;
        while (fast < str.length()){
            if (str.charAt(fast) != str.charAt(slow)){
                sb.append(fast - slow).append(str.charAt(slow));
                slow = fast;
            }
            fast++;
        }
        sb.append(fast - slow).append(str.charAt(slow));
        return sb.toString();
    }


}
