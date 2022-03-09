public class insertSort {

    public void sort(int[] nums){
        int length = nums.length;
        for (int end = length - 1; end > 0; end--) {
            boolean flag = true;
            for (int begin = 1; begin <= end; begin++) {
                if (nums[begin] < nums[begin - 1]){
                    int temp = nums[begin];
                    nums[begin] = nums[begin - 1];
                    nums[begin - 1] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    public static void main(String[] args) {
        insertSort insertSort = new insertSort();
        int[] nums = {1,3,4,61,12,90,3,67};
        insertSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
