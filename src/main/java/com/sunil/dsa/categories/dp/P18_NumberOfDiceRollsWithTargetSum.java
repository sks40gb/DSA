package com.sunil.dsa.categories.dp;

public class P18_NumberOfDiceRollsWithTargetSum {

    public static void main(String[] args) {
        P18_NumberOfDiceRollsWithTargetSum o = new P18_NumberOfDiceRollsWithTargetSum();
        int n = 2, k = 6, target = 7;
        System.out.println(o.numRollsToTarget(n, k, target));
        System.out.println(o.numRollsToTargetDP(n, k, target));
        System.out.println(o.numRollsToTargetSO(n, k, target));
    }

    public int numRollsToTarget(int n, int k, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0 || n == 0) {
            return 0;
        }
        int ways = 0;
        for (int i = 1; i <= k; i++) {
            ways += numRollsToTarget(n - 1, k, target - i);
        }
        return ways;
    }

    public int numRollsToTargetDP(int N, int k, int target) {

        int mod = 1_000_000_007;

        int[][] dp = new int[N + 1][target + 1];

        //If target is 0 and all dice are used
        dp[0][0] = 1;

        for (int n = 1; n <= N; n++) {
            for (int t = 1; t <= target; t++) {
                int ways = 0;
                for (int i = 1; i <= k; i++) {
                    if (t - i >= 0) {
                        ways = (ways + dp[n - 1][t - i]) % mod;
                    }
                }
                dp[n][t] = ways;
            }
        }
        return dp[N][target];
    }


    public int numRollsToTargetSO(int N, int k, int target) {

        int mod = 1_000_000_007;

        int[] pre = new int[target + 1];

        //If target is 0 and all dice are used
        pre[0] = 1;

        for (int n = 1; n <= N; n++) {

            //reset to zero before the next iteration
            int[] cur = new int[target + 1];
            for (int t = 1; t <= target; t++) {
                int ways = 0;
                for (int i = 1; i <= k; i++) {
                    if (t - i >= 0) {
                        ways = (ways + pre[t - i]) % mod;
                    }
                }
                cur[t] = ways;
            }
            pre = cur;
        }
        return pre[target];
    }


}
