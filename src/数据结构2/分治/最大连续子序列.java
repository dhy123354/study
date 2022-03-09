package 数据结构2.分治;

public class 最大连续子序列 {
    public static void main(String[] args) {
        int[] nums = {-2, 1,-3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray2(nums));
    }

    //优化1 O(n2)
    static int maxSubarray(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray(nums,0,nums.length);
    }

    static int maxSubArray(int[] nums,int begin ,int end){
        if (end - begin < 2) return nums[begin];
		int mid = (begin + end) >> 1;
		int leftMax = Integer.MIN_VALUE;
		int leftSum = 0;
		for (int i = mid - 1; i >= begin; i--) {
			leftSum += nums[i];
			leftMax = Math.max(leftMax, leftSum);
		}

		int rightMax = Integer.MIN_VALUE;
		int rightSum = 0;
		for (int i = mid; i < end; i++) {
			rightSum += nums[i];
			rightMax = Math.max(rightMax, rightSum);
		}

        return Math.max(leftMax + rightMax,
                Math.max(
                        maxSubArray(nums, begin, mid),
                        maxSubArray(nums, mid, end))
        );
    }

    //优化1 O(n2)
    static int maxSubArray2(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;

        for (int begin = 0; begin < nums.length; begin++) {
            for (int end = begin; end < nums.length; end++) {
                int sum = 0;
                sum += nums[end];
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    //O(n3)
    static int maxSubArray1(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;

        for (int begin = 0; begin < nums.length; begin++) {
            for (int end = begin; end < nums.length  ; end++) {
                int sum = 0;
                for (int i = begin; i <= end; i++) {
                    sum += nums[i];
                }
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}
