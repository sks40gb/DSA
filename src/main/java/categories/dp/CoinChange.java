package categories.dp;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {2, 5};
        int amount = 11;
        int result = new CoinChange().coinChange(coins, amount);
        System.out.println(result);
    }

//    public int coinChange(int[] coins, int amount) {
//        int res =  coinChange(coins, amount);
//        return res == Integer.MAX_VALUE ? -1 : res;
//    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = coinChange(coins, amount- coins[i]);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res+1);
            }
        }
        return min;
    }
}
