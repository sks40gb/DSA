package t150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]"); // Output: [0, 1]

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(complement, i);
        }
        return new int[]{0, 0};
    }

}
