package t150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static void main(String[] args) {

        ContainsDuplicateII solution = new ContainsDuplicateII();
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println(solution.containsNearbyDuplicate(nums1, k1)); // true

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(solution.containsNearbyDuplicate(nums2, k2)); // true

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(solution.containsNearbyDuplicate(nums3, k3)); // false
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            boolean indexGapLessOrEqualToK = (i - map.get(n) <= k);
            if(map.containsKey(n) && indexGapLessOrEqualToK){
                return true;
            }
            map.put(n, i);
        }
        return false;
    }


}
