package practice2;

import java.util.Arrays;

public class BuyAndSellWithTransactionFee {

    public static void main(String[] args) {
        BuyAndSellWithTransactionFee o = new BuyAndSellWithTransactionFee();
        System.out.println(o.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2)); //8
        System.out.println(o.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3)); //6
    }

    public int maxProfit(int[] stocks, int fee) {
        int[][] dp = new int[2][stocks.length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return makeTransaction(stocks, true, fee, 0, dp);
    }

    private int makeTransaction(int[] stocks, boolean buy, int fee, int index, int[][] dp) {
        if (index >= stocks.length) {
            return 0;
        }
        int buyInt = buy ? 1 : 0;
        if (dp[buyInt][index] != Integer.MIN_VALUE) {
            return dp[buyInt][index];
        }
        if (buy) {
            int take = makeTransaction(stocks, false, fee, index + 1, dp) - stocks[index];
            int dontBuy = makeTransaction(stocks, true, fee, index + 1, dp);
            return dp[buyInt][index] = Math.max(take, dontBuy);
        } else {
            int sell = makeTransaction(stocks, true, fee, index + 1, dp) + stocks[index] - fee;
            int dontSell = makeTransaction(stocks, false, fee, index + 1, dp);
            return dp[buyInt][index] = Math.max(sell, dontSell);
        }
    }

}
