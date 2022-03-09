package com.Others;

public class L_12_整数转罗马数字 {
    public String intToRoman1(int num) {
        String [] arr = {"I","V","X","L","C","D","M"};
        String result = "";
        int mi = 0;
        int temp = num % 10;

        while (num != 0){
            String tempa = "";
            if (temp != 4 && temp != 9){
                for (int i = 1; i <= temp; i++) {
                    tempa += arr[mi];
                    if (i == 5)
                        tempa = arr[mi + 1];
                }
            }else {
                if (temp == 4) tempa += arr[mi] + arr[mi + 1];
                if (temp == 9) tempa += arr[mi] + arr[mi + 2];
            }

            num /= 10;
            mi += 2;
            temp = num % 10;
            result = tempa + result;
        }
        return result;
    }

    int[] val = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strings = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num){
        StringBuffer str1 = new StringBuffer();
        for (int i = 0; i < val.length && num >0; i++) {
            int cv = val[i];
            String sv = strings[i];
            while (num >= cv){
                str1.append(sv);
                num -= cv;
            }
        }
        return str1.toString();
    }
}
