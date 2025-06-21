package com.sunil.dsa.categories.dp;

public class P2_HouseRobberII {

    public static void main(String[] args) {
        P2_HouseRobberII o = new P2_HouseRobberII();
        int[] nums = {1, 2, 3, 1};
        System.out.println(o.rob(nums));
        System.out.println(o.robDP(nums));
    }

    private int rob(int[] nums) {
        int n = nums.length;
        return Math.max(robRec(nums, 0, n - 2), robRec(nums, 1, n - 1));
    }

    private int robRec(int[] nums, int start, int end) {
        if (end < start) {
            return 0;
        }
        if (end == start) {
            return nums[start];
        }

        int rob = nums[end] + robRec(nums, start, end - 2);
        int dontRob = robRec(nums, start, end - 1);
        return Math.max(rob, dontRob);
    }

    private int robDP(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int max1 = robLinearDP(nums, 0, n - 2); // Exclude last
        int max2 = robLinearDP(nums, 1, n - 1); // Exclude first

        return Math.max(max1, max2);
    }

    private int robLinearDP(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] dp = new int[len];

        dp[0] = nums[start];
        if (len == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < len; i++) {
            int rob = nums[start + i] + dp[i - 2];
            int dontRob = dp[i - 1];
            dp[i] = Math.max(rob, dontRob);
        }

        return dp[len - 1];
    }


    private int robSO(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int max1 = robLinearSO(nums, 0, n - 2); // exclude last
        int max2 = robLinearSO(nums, 1, n - 1); // exclude first

        return Math.max(max1, max2);
    }

    private int robLinearSO(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int rob = nums[i] + prev2;
            int dontRob = prev1;
            int curr = Math.max(rob, dontRob);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
