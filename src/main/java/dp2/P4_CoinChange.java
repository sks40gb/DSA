package dp2;

import java.util.Arrays;

public class P4_CoinChange {

    public static void main(String[] args) {
        P4_CoinChange o = new P4_CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(o.coinChange(coins, amount));
        System.out.println(o.coinChangeDP(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return amount;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int take = coinChange(coins, amount - coins[i]);
            if (take != Integer.MAX_VALUE) {
                min = 1 + Math.min(take, min);
            }
        }
        return min;
    }

    public int coinChangeDP(int[] coins, int amount) {
        int n = amount;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (amount - coins[j] >= 0) {
                    int take = dp[amount - coins[j]];
                    min = 1 + Math.min(take, min);
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }

}
