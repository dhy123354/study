public class mergeSort {

    public void main(int[] nums){
        int[] leftNums = new int[nums.length >> 1];
        sort(0,nums.length,leftNums,nums);
    }

    public void sort(int begin,int end,int[] leftNums,int[] nums){
        if ((end - begin) < 2) return;

        int mid = (begin + end) >> 1;
        sort(begin,mid, leftNums,nums);
        sort(mid ,end,leftNums,nums);
        merge(begin,mid,end,leftNums,nums);
    }

    public void merge(int begin,int mid,int end,int[] leftNums,int[] nums){
        int li = 0,le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;
        for (int i = li; i < le; i++) {
            leftNums[i] = nums[begin + i];
        }
        while (li < le){
            if (ri < re && (nums[ri] - leftNums[li]) < 0) {
                nums[ai++] = nums[ri++];
            }else {
                nums[ai++] = leftNums[li++];
            }
        }
    }
    public static void main(String[] args) {
        mergeSort mergeSort = new mergeSort();
        int[] nums = {1,92,13,45,9,76,4};
        mergeSort.main(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
