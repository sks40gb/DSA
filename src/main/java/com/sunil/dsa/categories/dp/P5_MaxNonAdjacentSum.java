package com.sunil.dsa.categories.dp;

public class P5_MaxNonAdjacentSum {

    public int maximumNonAdjacentSum(int[] nums) {
        int n = nums.length;
        return solve(nums, n - 1);
    }

    public int solve(int[] nums, int n) {
        // Base case
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return nums[0];
        }
        int incl = solve(nums, n - 2) + nums[n];
        int excl = solve(nums, n - 1); // + 0 is implicit

        return Math.max(incl, excl);
    }

    public int solveTab(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int incl = dp[i - 2] + nums[i];
            int excl = dp[i - 1];
            dp[i] = Math.max(incl, excl);
        }

        return dp[n - 1];
    }

    public int solveSO(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {

            int incl = prev2 + nums[i];
            int excl = prev1;
            int curr = Math.max(incl, excl);

            // Update for next iteration
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }


}
