package dp3;

import java.util.Arrays;

public class P4_CoinChange {

    public static void main(String[] args) {
        P4_CoinChange o = new P4_CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(o.coinChange(coins, amount));
        System.out.println(o.solveDP(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int min = solve(coins, amount);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int solve(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int result = solve(coins, amount - coins[i]);
            if (result != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + result);
            }
        }
        return min;
    }

    private int solveDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int m = 1; m <= amount; m++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (m - coins[i] >= 0) {
                    int result = dp[m - coins[i]];
                    if (result != Integer.MAX_VALUE) {
                        min = Math.min(min, 1 + result);
                    }
                }
            }
            dp[m] = min;
        }
        return dp[amount];
    }

}
