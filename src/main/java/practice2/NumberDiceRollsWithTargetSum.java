package practice2;

import java.util.Arrays;

public class NumberDiceRollsWithTargetSum {

    public static void main(String[] args) {
        int n = 30, k = 30, target = 500; //222616187
        int result = new NumberDiceRollsWithTargetSum().numRollsToTarget(n, k, target);
        System.out.println(result);
    }

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return targetSum(n, k, target, dp);
    }

    private int targetSum(int n, int k, int target, int[][] dp) {
        if (n == 0 && target == 0) {
            return 1;
        }
        if (n <= 0 || target <= 0) {
            return 0;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        int times = 0;
        for (int i = 1; i <= k; i++) {
            times = (times + targetSum(n - 1, k, target - i, dp)) % 1_000_000_007;
        }
        return dp[n][target] = times;
    }
}
