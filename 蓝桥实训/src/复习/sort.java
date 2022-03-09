

public class sort {
    static int[] nums = {1,3,42,6,7,12,435,0};
    public static void sortArray(){
        int len = sort.nums.length;
        for (int i = (len >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
        while (len > 1){
            int a= len - 1;
            int temp = sort.nums[0];
            sort.nums[0] = sort.nums[a];
            sort.nums[a] = temp;
            --len;
            siftDown(0);
        }
    }

    private static void siftDown(int index){
        int element = nums[index];

        int half = nums.length >> 1;
        while (index < half){
            int childIndex = (index << 1) + 1;
            int child = nums[childIndex];

            int rightIndex = childIndex +1;
            if (rightIndex < nums.length &&( nums[rightIndex] - child) > 0){
                child = nums[childIndex = rightIndex];
            }

            if ((element - child) >=0)break;

            nums[index] =child;
            index = childIndex;
        }
        nums[index] = element;
    }


    public static void main(String[] args) {

        sortArray();
        for (int a : nums){
            System.out.println(a+ " ");
        }
    }
}

