package dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        CoinChange o = new CoinChange();
        System.out.println(o.coinChangeRec(coins, amount));
        System.out.println(o.coinChangeDP(coins, amount));

    }

    private int coinChangeRec(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++) {
            int result = coinChangeRec(coins, amount - coins[j]);
            if (result != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + result);
            }
        }
        return min;
    }

    private int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int result = dp[i - coins[j]];
                    if (result != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], 1 + result);
                    }
                }
            }
        }
        return dp[amount];
    }

    boolean maximumSubarray(int[] nums, int target) {
        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {  // Update in reverse
                if(nums[i] < j){
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

}
