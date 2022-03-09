import java.util.ArrayList;
import java.util.Scanner;

public class Sort {

    public void quickSort(int[] nums){
        int begin = 0;
        int end = nums.length;
        sort(begin,end,nums);
    }

    public void sort(int begin,int end,int[] nums){
        if (end - begin < 2) return;
        int mid = pivotIndex(begin,end,nums);
        sort(begin,mid,nums);
        sort(mid + 1,end,nums);
    }

    public int pivotIndex(int begin,int end,int[] nums){
        int pivot = nums[begin];
        end--;
        while (begin < end){
            while (begin < end){
                if ((pivot - nums[end]) < 0) {
                    end--;
                } else {
                    nums[begin++] = nums[end];
                    break;
                }
            }

            while (begin < end){
                if ((pivot - nums[begin]) > 0){
                    begin++;
                }else {
                    nums[end--] = nums[begin];
                    break;
                }
            }
        }
        nums[begin] = pivot;
        return begin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] str = sc.nextLine().split(" ");
            int[] nums = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                nums[i] = Integer.parseInt(str[i]);
            }
            Sort sort = new Sort();
            sort.quickSort(nums);
            for (int num : nums) {
                System.out.print(num);
            }
        }
    }
}
