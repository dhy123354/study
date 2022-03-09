public class inversionSort {

    public void sort(int[] nums){
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int cur = i;
            int v = nums[cur];
            while (cur > 0 && v < nums[cur - 1]){
                nums[cur] = nums[cur - 1];
                cur--;
            }
            nums[cur] = v;
        }
    }

    public static void main(String[] args) {
        inversionSort inversionSort = new inversionSort();
        int[] nums = {1,3,4,61,12,90,3,67};
        inversionSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
