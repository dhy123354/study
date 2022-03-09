package com.数据结构2.字符串;

public class L_8_字符串转换整数 {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int index = 0;
        while (index < len && chars[index] == ' ')
            index++;
        if (index == len) return 0;

        int sign = 1;
        char firstchar = chars[index];
        if (firstchar == '-'){
            index++;
            sign = -1;
        }
        if (firstchar == '+'){
            index++;
        }

        int res = 0, last = 0;
        while (index < len) {
            char c = chars[index];
            if (c < '0' || c > '9') break;
            int tem = c - '0';
            last = res;
            res = res * 10 + tem;
            if (last != res / 10)  ////如果不相等就是溢出了
                return (sign == (-1)) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            index++;
        }
        return sign * res;
    }

    public static void main(String[] args) {

    }
}
