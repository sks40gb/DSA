package com.sunil.dsa.categories.dp;

import java.util.Arrays;

public class P19_MinimumSwapsToMakeSequencesIncreasing {

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 4};
        int[] nums2 = {1, 2, 3, 7};
        System.out.println(minSwap(nums1, nums2));
        System.out.println(solveTab(nums1, nums2));
        System.out.println(solveSO(nums1, nums2));
    }

    public static int minSwap(int[] nums1, int[] nums2) {
        return solve(nums1, nums2, 0, false);
    }

    private static int solve(int[] nums1, int[] nums2, int index, boolean swapped) {
        if (index == nums1.length) {
            return 0;
        }

        int prev1 = index == 0 ? Integer.MIN_VALUE : nums1[index - 1];
        int prev2 = index == 0 ? Integer.MIN_VALUE : nums2[index - 1];

        if (swapped) {
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp;
        }

        //dont swap
        int min = Integer.MAX_VALUE;
        if (nums1[index] > prev1 && nums2[index] > prev2) {
            min = Math.min(min, solve(nums1, nums2, index + 1, false));
        }

        //swap
        if (nums1[index] > prev2 && nums2[index] > prev1) {
            min = Math.min(min, 1 + solve(nums1, nums2, index + 1, true));
        }
        return min;
    }

    private static int solveTab(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[][] dp = new int[n + 1][2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int swapped = 1; swapped >= 0; swapped--) {

                int prev1 = index == 0 ? Integer.MIN_VALUE : nums1[index - 1];
                int prev2 = index == 0 ? Integer.MIN_VALUE : nums2[index - 1];

                if (swapped == 1) {
                    int temp = prev1;
                    prev1 = prev2;
                    prev2 = temp;
                }

                //dont swap
                int min = Integer.MAX_VALUE;
                if (nums1[index] > prev1 && nums2[index] > prev2) {
                    min = Math.min(min, dp[index + 1][0]);
                }

                //swap
                if (nums1[index] > prev2 && nums2[index] > prev1) {
                    min = Math.min(min, 1 + dp[index + 1][1]);
                }
                dp[index][swapped] = min;
            }
        }
        return dp[0][0];
    }


    private static int solveSO(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] next = new int[2];
        next[0] = 0;
        next[1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            int[] cur = new int[2];
            Arrays.fill(cur, Integer.MAX_VALUE);

            for (int swapped = 1; swapped >= 0; swapped--) {

                int prev1 = index == 0 ? Integer.MIN_VALUE : nums1[index - 1];
                int prev2 = index == 0 ? Integer.MIN_VALUE : nums2[index - 1];

                if (swapped == 1) {
                    int temp = prev1;
                    prev1 = prev2;
                    prev2 = temp;
                }

                //dont swap
                int min = Integer.MAX_VALUE;
                if (nums1[index] > prev1 && nums2[index] > prev2) {
                    min = Math.min(min, next[0]);
                }

                //swap
                if (nums1[index] > prev2 && nums2[index] > prev1) {
                    min = Math.min(min, 1 + next[1]);
                }
                cur[swapped] = min;
            }
            next = cur;
        }
        return next[0];
    }

}
