package com.sunil.dsa.categories.hashmap;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/longest-consecutive-sequence/description/

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:
Input: nums = [1,0,1,2]
Output: 3
 */
public class P9_LongestConsecutiveSequence {

    public static void main(String[] args) {
        P9_LongestConsecutiveSequence o = new P9_LongestConsecutiveSequence();
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(o.longestConsecutive(nums));
    }


    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 1;
        for (int i = 0; i < set.size(); i++) {
            int n = nums[i];
            int count = 1;

            if (!set.contains(n - 1)) {
                while (set.contains(n + 1)) {
                    n++;
                    count++;
                    max = Math.max(count, max);
                }
            }

        }
        return max;
    }
}
