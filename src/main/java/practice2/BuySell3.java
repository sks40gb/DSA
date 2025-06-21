package practice2;

import java.util.Arrays;

public class BuySell3 {

    public static void main(String[] args) {
        BuySell3 o = new BuySell3();
        System.out.println(o.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})); //6
        System.out.println(o.maxProfit(new int[]{1, 2, 3, 4, 5})); //4
    }

    public int maxProfit(int[] stocks) {
        int limit = 4;
        int[][][] dp = new int[2][stocks.length + 1][limit + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        return makeTransaction(stocks, true, 0, 4, dp);
    }

    private int makeTransaction(int[] stocks, boolean buy, int index, int limit, int[][][] dp) {
        if (limit < 0) {
            return 0;
        }
        if (index >= stocks.length) {
            return 0;
        }
        int buyInt = buy ? 1 : 0;
        if(dp[buyInt][index][limit] != Integer.MIN_VALUE){
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
