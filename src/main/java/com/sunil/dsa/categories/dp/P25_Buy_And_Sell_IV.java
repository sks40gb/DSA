package com.sunil.dsa.categories.dp;

public class P25_Buy_And_Sell_IV {

    public static void main(String[] args) {
        P25_Buy_And_Sell_IV o = new P25_Buy_And_Sell_IV();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(o.maxProfit(prices, fee));
    }

    public int maxProfit(int[] prices, int fee) {
        return solve(prices, fee, 0, true);
//        return solveDP(prices);
//        return solveSO(prices);
    }

    private int solve(int[] stocks, int fee, int index, boolean buy) {
        if (index >= stocks.length) {
            return 0;
        }
        if (buy) {
            int buyIt = solve(stocks, fee, index + 1, false) - stocks[index];
            int dontBuy = solve(stocks, fee, index + 1, true);
            return Math.max(buyIt, dontBuy);
        } else {
            int sellIt = solve(stocks, fee, index + 1, true) + stocks[index] - fee;
            int dontSell = solve(stocks, fee, index + 1, false);
            return Math.max(sellIt, dontSell);
        }
    }

    //solve(stocks,index,buy)
    private int solveDP(int[] stocks, int fee) {
        int n = stocks.length;
        int[][] dp = new int[n + 1][2];
        int TRUE = 0;
        int FALSE = 1;

        for (int index = n - 1; index >= 0; index--) {
            for (int buyIndex = 1; buyIndex >= 0; buyIndex--) {
                boolean buy = buyIndex == 0;
                if (buy) {
                    int buyIt = dp[index + 1][FALSE] - stocks[index];
                    int dontBuy = dp[index + 1][TRUE];
                    dp[index][buyIndex] = Math.max(buyIt, dontBuy);
                } else {
                    int sellIt = dp[index + 1][TRUE] + stocks[index] - fee;
                    int dontSell = dp[index + 1][FALSE];
                    dp[index][buyIndex] = Math.max(sellIt, dontSell);
                }
            }
        }
        return dp[0][TRUE];
    }


    private int solveSO(int[] stocks, int fee) {
        int n = stocks.length;
        int[] next = new int[2];
        int[] cur = new int[2];
        int TRUE = 0;
        int FALSE = 1;

        for (int index = n - 1; index >= 0; index--) {
            for (int buyIndex = 1; buyIndex >= 0; buyIndex--) {
                boolean buy = buyIndex == 0;
                if (buy) {
                    int buyIt = next[FALSE] - stocks[index];
                    int dontBuy = next[TRUE];
                    cur[buyIndex] = Math.max(buyIt, dontBuy);
                } else {
                    int sellIt = next[TRUE] + stocks[index] - fee;
                    int dontSell = next[FALSE];
                    cur[buyIndex] = Math.max(sellIt, dontSell);
                }
                next = cur;
            }
        }
        return cur[TRUE];
    }


}
