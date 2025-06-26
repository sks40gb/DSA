package com.sunil.dsa.categories.z_dp;

/*

https://leetcode.com/problems/min-cost-climbing-stairs/description/

Example 1:

Input: cost = [10,15,20]
Output: 15


Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6

 */
public class P3_MinCostClimbingStairs {
    public static void main(String[] args) {

        P3_MinCostClimbingStairs sc = new P3_MinCostClimbingStairs();
        int[] cost = {10, 15, 20};

        System.out.println(sc.minCostClimbingStairs(cost)); // Output: 15
    }

    public int minCostClimbingStairs(int[] cost) {
        // Start from step 0 or step 1
        return Math.min(solve(cost, 0), solve(cost, 1));
    }

    private int solve(int[] cost, int i) {

        int n = cost.length;

        if (i >= n) {
            return 0; // Reached or crossed the top
        }

        return cost[i] + Math.min(
                solve(cost, i + 1),
                solve(cost, i + 2)
        );
    }

    public int minCostClimbingStairsDP(int[] cost) {

        int n = cost.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return cost[0];
        }

        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // You can end on step n-1 or n-2
        return Math.min(dp[n - 1], dp[n - 2]);
    }


}
