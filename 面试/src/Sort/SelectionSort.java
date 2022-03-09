public class SelectionSort {

    public void sort(int[] nums){
        int length = nums.length;
        for (int end = length - 1; end > 0; end--) {
            int max = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (nums[max] < nums[begin]) {
                    max = begin;
                }
            }
            int temp = nums[max];
            nums[max] = nums[end];
            nums[end] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] nums = {1,3,4,61,12,90,3,67};
        selectionSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
