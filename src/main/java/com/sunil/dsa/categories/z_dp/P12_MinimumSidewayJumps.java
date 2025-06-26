package com.sunil.dsa.categories.z_dp;

import java.util.Arrays;

public class P12_MinimumSidewayJumps {

    public static void main(String[] args) {
        P12_MinimumSidewayJumps o = new P12_MinimumSidewayJumps();
        int[] nums = {0, 1, 2, 3, 0};
//        int[] nums = {0, 1, 1, 3, 3, 0};
//        int[] nums = {0, 2, 1, 0, 3, 0};
        System.out.println(o.minWays(nums, 0, 2));
        System.out.println(o.minWaysDP(nums));
    }

    public int minWays(int[] nums, int index, int lane) {
        if (index == nums.length - 1) {
            return 0;
        }
        if (nums[index + 1] != lane) {
            return minWays(nums, index + 1, lane);
        } else {
            int min = Integer.MAX_VALUE;
            for (int l = 1; l <= 3; l++) {
                if (l != nums[index] && l != lane) {
                    min = Math.min(min, 1 + minWays(nums, index, l));
                }
            }
            return min;
        }
    }

    public int minWaysDP(int[] nums) {
        int mod = 1000000000;
        int n = nums.length;
        int[][] dp = new int[n][4];

        // mod because if you add anything in max it will turn negative
        for (int row[] : dp) {
            Arrays.fill(row, mod);
        }

        // Base case
        for (int i = 0; i <= 3; i++) {
            dp[n - 1][i] = 0;
        }

        for (int index = n - 2; index >= 0; index--) {
            for (int lane = 1; lane <= 3; lane++) {
                if (nums[index + 1] != lane) {
                    dp[index][lane] = dp[index + 1][lane];
                } else {
                    int min = mod;
                    for (int i = 1; i <= 3; i++) {
                        if (i != nums[index] && i != lane) {
                            min = Math.min(min, 1 + dp[index + 1][i]);
                        }
                    }
                    dp[index][lane] = min;
                }
            }
        }
        //If you are on second lane then its fine
        // otherwise we need to jump from 1 and 3 which will be counted
        return Math.min(dp[0][1] + 1, Math.min(dp[0][2], dp[0][3] + 1));
    }
}
