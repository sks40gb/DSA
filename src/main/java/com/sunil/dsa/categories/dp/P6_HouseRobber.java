package com.sunil.dsa.categories.dp;

public class P6_HouseRobber {

    public static void main(String[] args) {
        P6_HouseRobber o = new P6_HouseRobber();
        int[] nums = {1, 2, 3, 1};
        System.out.println(o.rob(nums, nums.length - 1));
        System.out.println(o.robDP(nums));
        System.out.println(o.rodSO(nums));
    }

    private int rob(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        }
        if (i < 0) {
            return Integer.MIN_VALUE;
        }
        int rob = nums[i] + rob(nums, i - 2);
        int dontRob = rob(nums, i - 1);
        return Math.max(rob, dontRob);
    }

    private int robDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        //Base code
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int rob = nums[i] + dp[i - 2];
            int dontRob = dp[i - 1];
            dp[i] = Math.max(rob, dontRob);
        }
        return dp[n - 1];
    }

    private int rodSO(int[] nums){
        int n = nums.length;

        //Base code
        int pre2 = nums[0];
        int pre1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int rob = nums[i] + pre2;
            int dontRob = pre1;

            int temp = pre1;
            pre1 = Math.max(rob, dontRob);
            pre2 = temp;
        }
        return pre1;
    }
}
