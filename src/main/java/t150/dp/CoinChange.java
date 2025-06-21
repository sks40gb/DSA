package t150.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int[] dp = new int[amount + 1];
        int result = new CoinChange().coinChange(coins, amount, dp);
        System.out.println(result);
        System.out.println(new CoinChange().coinChangeDP(coins, amount));

    }

    private int coinChange(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = coinChange(coins, amount - coins[i], dp);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, (res + 1));
            }
        }
        return dp[amount] = min;
    }

    private int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int m = 1; m <= amount; m++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                int res =  m -coins[i];
                if (res != Integer.MAX_VALUE) {
                    min = Math.min(min, res + 1);
                }
            }
        }
        return dp[amount];
    }
}
