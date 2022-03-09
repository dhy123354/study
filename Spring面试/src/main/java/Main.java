import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){

            int[] arrs = new int[8];
            for (int i = 0; i < 8 ; i++) {
                arrs[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            for (int max : max(arrs, k)) {
                System.out.print(max);
            }
        }
    }

    public static int[] max(int[] nums,int k){
        int length = nums.length;
        if (length * k == 0) return new int[0];
        int[] left= new int[length];
        int[] right= new int[length];
        for (int i = 0; i < length; i=i+k) {
            left[i] = nums[i];
            int index = i + k - 1 >= length ? length - 1:i + k - 1;
            right[index] = nums[index];
            for (int j = i + 1; j <= index; j++) {
                left[i] = Math.max(left[j - 1],nums[j]);
            }
            for (int index1 = index - 1; index1 >= i; index1--) {
                right[index1] = Math.max(right[index1 + 1],nums[index1]);
            }
        }
        int[] arr = new int[length - k + 1];
        for (int j = 0; j < length - k + 1; j++) {
            arr[j] = Math.max(right[j],left[j + k - 1] );
        }
        return arr;
    }

}
