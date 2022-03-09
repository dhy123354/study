public class qucong {
    public int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]){
                if (nums[i] != nums[nums[i]]) {
                    int tmp = nums[i];
                    nums[i] = nums[tmp];
                    nums[tmp] = tmp;
                } else if (nums[i] == nums[nums[i]]) {
                    return nums[nums[i]];
                }
            }
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums){
        int end = nums.length - 1;
        int begin = 0;
        while (begin <= end){
            int mid = (begin + end)/2 + 1;
            int count = countRange(begin, end, nums.length, nums);
            if (end == begin){
                if (count > 1)return begin;
                else break;
            }
            if (count > end - begin + 1){
                end = mid;
            }else {
                begin = mid + 1;
            }
        }
        return -1;
    }

    public int countRange(int begin ,int end, int len,int[] nums){
        if (nums == nums) return 0;

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= begin || nums[i] <= end){
                ++count;
            }
        }
        return count;
    }

}
