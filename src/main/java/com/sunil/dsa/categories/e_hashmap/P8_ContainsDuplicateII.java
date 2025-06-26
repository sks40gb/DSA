package com.sunil.dsa.categories.e_hashmap;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/contains-duplicate-ii/description/

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
public class P8_ContainsDuplicateII {

    public static void main(String[] args) {
        P8_ContainsDuplicateII o = new P8_ContainsDuplicateII();
        System.out.println(o.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j < i + k + 1; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
