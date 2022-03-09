package com.数据结构2.字符串;

public class L_43_字符串相乘 {
    public String multiply(String num1, String num2) {
        //先相乘，然后不进位，最后再统一进位
        int len1 = num1.length();
        int len2 = num2.length();
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int[] res = new int[len1+len2];
        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                res[i+j+1] += (chars2[j]-'0')*(chars1[i]-'0');
            }
        }
        //从后面往前面进行进位
        int idx = res.length-1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while(idx>=0){
            res[idx] = res[idx]+add;
            add = res[idx]/10;
            res[idx] = res[idx]%10;
            sb.append(res[idx]);
            idx--;
        }
        int startIdx = res.length-1;
        //把sb后面的０全部干掉
        while(startIdx>=0 && sb.charAt(startIdx) =='0'){
            startIdx--;
            if(startIdx<0){
                //说明全部是０
                return "0";
            }
        }
        String s = sb.substring(0,startIdx+1);
        //能来到这说明碰到第一个不为０的
        StringBuilder endSb = new StringBuilder(s);
        if(add>0){
            sb.append(add);
        }
        String end = endSb.reverse().toString();
        return end.equals("")?"0":end;
    }
}
