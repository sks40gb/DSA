package com.sunil.dsa.categories.z_dp;

import java.util.Arrays;

public class P9_PerfectSquares {

    public static void main(String[] args) {
        P9_PerfectSquares o = new P9_PerfectSquares();
        int n = 12;
        System.out.println(o.numSquares(n));
        System.out.println(o.numSquaresDP(n));
    }

    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int result = numSquares(n - i * i);
            if (result != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + result);
            }
        }
        return min;
    }

    // Bottom-up DP approach
    public int numSquaresDP(int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int n = 1; n <= N; n++) {
            for (int i = 1; i * i <= n; i++) {
                dp[n] = Math.min(dp[n], 1 + dp[n - i * i]);
            }
        }

        return dp[N];
    }
}
