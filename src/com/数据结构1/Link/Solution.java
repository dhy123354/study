package com.数据结构1.Link;

class Solution {
    public int paintingPlan(int n, int k) {
        int num = 0;
        if (k==n*n) return 1;
        for (int i=0;i<n;i++){
            for (int j =0;j<n;j++){
                if(i*n+j*n-j*i==k){
                     num += func(n,j)+func(n,i);
                }
            }
        }
        return num;
    }

    public int func(int n,int c){
        int num1 = 0;
        for (int i= 0;i>n-c;i++){
            num1*=i;
        }
        for(int i = 1 ; i <= c ; i++){
            num1 /= i;
        }
        return num1;
    }

}
