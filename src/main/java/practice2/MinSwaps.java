package practice2;

import java.util.HashMap;
import java.util.Map;

public class MinSwaps {
    public static void main(String[] args) {
        int[] nums1 = {0, 4, 4, 5, 9};
        int[] nums2 = {0, 1, 6, 8, 10};
        System.out.println(new MinSwaps().minSwap(nums1, nums2)); // Output: 1
    }

    public int minSwap(int[] nums1, int[] nums2) {
        Map<String, Integer> dp = new HashMap<>();
        return swap(nums1, nums2, Integer.MIN_VALUE, Integer.MIN_VALUE, 0, dp);
    }

    private int swap(int[] nums1, int[] nums2, int pre1, int pre2, int i, Map<String, Integer> dp) {
        if (i >= nums1.length) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        String key = pre1 + "_" + pre2 + "_" + i;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (pre1 < nums1[i] && pre2 < nums2[i]) {
            min = Math.min(min, swap(nums1, nums2, nums1[i], nums2[i], i + 1, dp));
        }

        if (pre1 < nums2[i] && pre2 < nums1[i]) {
            int swapIt = 1 + swap(nums1, nums2, nums2[i], nums1[i], i + 1, dp);
            min = Math.min(min, swapIt);
        }
        dp.put(key, min);
        return min;
    }
}
