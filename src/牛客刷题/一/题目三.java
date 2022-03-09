package 牛客刷题.一;

import java.sql.SQLOutput;

public class 题目三 {
    public static int jump(int[] arr){
        if (arr == null || arr.length == 0) return 0;

        int step = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i){
                step++;
                cur = next;
            }
            next = Math.max(next,i + arr[i]);
        }
        return step;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,1,4};
        System.out.println(jump(arr));
    }
}
