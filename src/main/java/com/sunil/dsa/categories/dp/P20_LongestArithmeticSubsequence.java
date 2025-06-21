package com.sunil.dsa.categories.dp;

import java.util.HashMap;
import java.util.Map;

public class P20_LongestArithmeticSubsequence {

    public static void main(String[] args) {
        P20_LongestArithmeticSubsequence o = new P20_LongestArithmeticSubsequence();
        int[] nums = {3, 6, 9, 12};
        System.out.println(o.longestArithSeqLength(nums));
    }

    public int longestArithSeqLength(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = nums[j] - nums[i];
                max = Math.max(max, 2 + solveMine(nums, diff, j, j + 1));
            }
        }
        return max;
    }

    private int solveMine(int[] nums, int diff, int current, int next) {
        if (next >= nums.length) {
            return 0;
        }
        int max = 0;

        //take
        if (nums[next] - nums[current] == diff) {
            max = Math.max(max, 1 + solveMine(nums, diff, next, next + 1));
        }
        //dontTake
        max = Math.max(max, solveMine(nums, diff, current, next + 1));
        return max;
    }


    // Recursively find next numbers in sequence starting from index 'prev'
    private int solveCorrect(int[] nums, int prev, int diff) {
        int max = 0;
        for (int i = prev + 1; i < nums.length; i++) {
            if (nums[i] - nums[prev] == diff) {
                max = Math.max(max, 1 + solveCorrect(nums, i, diff));
            }
        }
        return max;
    }


    public int solveDP(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        // Each index has a map of <diff, length>
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];

                // If there's a sequence ending at j with this diff, extend it
                int len = dp[j].getOrDefault(diff, 1) + 1;

                // Update dp[i] for this diff
                dp[i].put(diff, Math.max(dp[i].getOrDefault(diff, 0), len));

                maxLen = Math.max(maxLen, dp[i].get(diff));
            }
        }

        return maxLen;
    }

}
