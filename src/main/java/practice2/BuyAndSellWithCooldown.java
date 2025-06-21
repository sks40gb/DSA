package practice2;

import java.util.Arrays;

public class BuyAndSellWithCooldown {

    public static void main(String[] args) {
        BuyAndSellWithCooldown o = new BuyAndSellWithCooldown();
        System.out.println(o.maxProfit(new int[]{2, 4, 1})); //2
        System.out.println(o.maxProfit(new int[]{3, 2, 6, 5, 0, 3})); //7
    }

    public int maxProfit(int[] stocks) {
        int[][] dp = new int[2][stocks.length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return makeTransaction(stocks, true, 0, dp);
    }

    private int makeTransaction(int[] stocks, boolean buy, int index, int[][] dp) {
        if (index >= stocks.length) {
            return 0;
        }
        int buyInt = buy ? 1 : 0;
        if (dp[buyInt][index] != Integer.MIN_VALUE) {
            return dp[buyInt][index];
        }
        if (buy) {
            int take = makeTransaction(stocks, false, index + 1, dp) - stocks[index];
            int dontBuy = makeTransaction(stocks, true, index + 1, dp);
            return dp[buyInt][index] = Math.max(take, dontBuy);
        } else {
            int sell = makeTransaction(stocks, true, index + 2,dp) + stocks[index];
            int dontSell = makeTransaction(stocks, false, index + 1, dp);
            return dp[buyInt][index] = Math.max(sell, dontSell);
        }
    }

}
