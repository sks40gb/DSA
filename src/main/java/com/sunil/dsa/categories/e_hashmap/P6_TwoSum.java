package com.sunil.dsa.categories.e_hashmap;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/description/

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
 */
public class P6_TwoSum {

    public static void main(String[] args) {
        P6_TwoSum o = new P6_TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(o.twoSum(nums, target));
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[]{};
    }
}
