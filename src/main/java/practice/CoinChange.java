package practice;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println(result);
    }

    private static int coinChange(int[] coins, int target) {
        if (target == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= target) {
                int res = coinChange(coins, target - coins[i]);
                if(res != -1){
                    min = Math.min(min, coinChange(coins, target - coins[i])) + 1;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
