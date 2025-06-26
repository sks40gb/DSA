package com.sunil.dsa.categories.a_array;

import java.util.Arrays;

/**
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
 * then 3 steps to the last index.
 */
public class P10_JumpGameII {

    public static void main(String[] args) {
        P10_JumpGameII o = new P10_JumpGameII();
        int[] nums = {1, 2, 3};
        System.out.println(o.jump(nums));
        System.out.println(o.solveDP(nums));
        System.out.println(o.solveArray(nums));
    }

    public int jump(int[] nums) {
        return solve(nums, 0);
    }

    private int solve(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return 0;
        }
        int minJump = Integer.MAX_VALUE;
        int maxReach = index + nums[index];
        for (int i = index + 1; i <= maxReach; i++) {
            int jumps = solve(nums, i);
            if (jumps != Integer.MAX_VALUE) {
                minJump = Math.min(minJump, 1 + jumps);
            }
        }
        return minJump;
    }

    private int solveDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int index = n - 2; index >= 0; index--) {
            int minJump = Integer.MAX_VALUE;
            int maxReach = index + nums[index];
            for (int i = index + 1; i <= maxReach && i < n; i++) {
                int jumps = dp[i];
                if (jumps != Integer.MAX_VALUE) {
                    minJump = Math.min(minJump, 1 + jumps);
                }
            }
            dp[index] = minJump;
        }
        return dp[0];
    }

    private int solveArray(int[] nums) {
        int maxReach = 0;
        int currentReach = 0;
        int jump = 0;
        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (currentReach <= i) {
                currentReach = maxReach;
                jump++;
            }
        }
        return jump;
    }

}
