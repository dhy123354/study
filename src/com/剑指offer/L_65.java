package com.剑指offer;

public class L_65 {

    public int Add(int num1,int num2){
        int sum,carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while (num2 != 0);
        return num1;
    }

    public static void main(String[] args) {
        L_65 l_65 = new L_65();
        System.out.println(l_65.Add(5, 17));
    }
}
