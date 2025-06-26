package com.sunil.dsa.categories.z_dp;

import java.util.Arrays;

public class P13_ReducingDishes {

    public static void main(String[] args) {
        P13_ReducingDishes o = new P13_ReducingDishes();
        int[] satisfaction = {-1, -8, 0, 5, -9};
        int result = o.maxSatisfaction(satisfaction);
        System.out.println(result);
        System.out.println(o.maxSatisfactionDP(satisfaction));
        System.out.println(o.maxSatisfactionOS(satisfaction));
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return maxSatisfaction(satisfaction, 0, 1);
    }

    private int maxSatisfaction(int[] satisfaction, int index, int cnt) {
        if (index >= satisfaction.length) {
            return 0;
        }
        int take = cnt * satisfaction[index] + maxSatisfaction(satisfaction, index + 1, cnt + 1);
        int dontTake = maxSatisfaction(satisfaction, index + 1, cnt);
        return Math.max(take, dontTake);
    }

    private int maxSatisfactionDP(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[][] dp = new int[n + 1][n + 2];
        for (int index = n - 1; index >= 0; index--) {
            for (int cnt = n; cnt >= 1; cnt--) {
                int take = cnt * satisfaction[index] + dp[index + 1][cnt + 1];
                int dontTake = dp[index + 1][cnt];
                dp[index][cnt] = Math.max(take, dontTake);
            }
        }
        return dp[0][1];
    }

    private int maxSatisfactionOS(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[] curr = new int[n + 2];
        int[] next = new int[n + 2];
        for (int index = n - 1; index >= 0; index--) {
            for (int cnt = n; cnt >= 1; cnt--) {
                int take = cnt * satisfaction[index] + next[cnt + 1];
                int dontTake = next[cnt];
                curr[cnt] = Math.max(take, dontTake);
            }
            next = curr.clone();
        }
        return curr[1];
    }
}
