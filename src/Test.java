import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (!map.containsValue(nums[i])){
                map.put(1,nums[i]);
                continue;
            };
            if (map.containsValue(nums[i])){
                System.out.println(nums[i]);

                map.remove(nums[i]);
                map.put(1,nums[i]);
            }
        }
        Set<Integer> set = map.keySet();
        int i = 0;
        for (Integer integer : set) {
            System.out.println(integer + ":" + map.get(integer));
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2,3};
        topKFrequent(nums,2);

    }
}
