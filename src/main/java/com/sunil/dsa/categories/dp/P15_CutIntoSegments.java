package com.sunil.dsa.categories.dp;

import java.util.Arrays;

public class P15_CutIntoSegments {

    public static void main(String[] args) {
        int n = 7;
        int x = 5;
        int y = 2;
        int z = 2;
        int result = cutSegments(n, x, y, z);
        System.out.println(result < 0 ? 0 : result); // Convert negative result to 0 if no cut is possible
    }


    public static int cutSegments(int n, int x, int y, int z) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;

        int recX = cutSegments(n - x, x, y, z);
        if (recX != Integer.MIN_VALUE) {
            max = Math.max(max, 1 + recX);
        }

        int recY = cutSegments(n - y, x, y, z);
        if (recY != Integer.MIN_VALUE) {
            max = Math.max(max, 1 + recY);
        }

        int recZ = cutSegments(n - z, x, y, z);
        if (recZ != Integer.MIN_VALUE) {
            max = Math.max(max, 1 + recZ);
        }
        return max;
    }


    public static int cutSegmentsDP(int N, int x, int y, int z) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {

            int max = Integer.MIN_VALUE;
            if (i - x >= 0 && dp[i - x] != Integer.MIN_VALUE) {
                max = Math.max(max, 1 + dp[i - x]);
            }
            if (i - y >= 0 && dp[i - y] != Integer.MIN_VALUE) {
                max = Math.max(max, 1 + dp[i - y]);
            }
            if (i - z >= 0 && dp[i - z] != Integer.MIN_VALUE) {
                max = Math.max(max, 1 + dp[i - z]);
            }
            dp[i] = max;
        }
        return dp[N];
    }

}
