package practice2;

import java.util.Arrays;

public class BuySell4 {

    public static void main(String[] args) {
        BuySell4 o = new BuySell4();
        System.out.println(o.maxProfit(2, new int[]{2, 4, 1})); //2
        System.out.println(o.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3})); //7
    }

    public int maxProfit(int k, int[] stocks) {
        int limit = k * 2;
        int[][][] dp = new int[2][stocks.length + 1][limit + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        return makeTransaction(stocks, true, 0, limit, dp);
    }

    private int makeTransaction(int[] stocks, boolean buy, int index, int limit, int[][][] dp) {
        if (limit < 0) {
            return 0;
        }
        if (index >= stocks.length) {
            return 0;
        }
        int buyInt = buy ? 1 : 0;
        if (dp[buyInt][index][limit] != Integer.MIN_VALUE) {
            return dp[buyInt][index][limit];
        }
        if (buy) {
            int take = makeTransaction(stocks, false, index + 1, limit - 1, dp) - stocks[index];
            int dontBuy = makeTransaction(stocks, true, index + 1, limit, dp);
            return dp[buyInt][index][limit] = Math.max(take, dontBuy);
        } else {
            int sell = makeTransaction(stocks, true, index + 1, limit - 1, dp) + stocks[index];
            int dontSell = makeTransaction(stocks, false, index + 1, limit, dp);
            return dp[buyInt][index][limit] = Math.max(sell, dontSell);
        }
    }

}
