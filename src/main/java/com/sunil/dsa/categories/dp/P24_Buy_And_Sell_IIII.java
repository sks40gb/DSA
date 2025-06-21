package com.sunil.dsa.categories.dp;

public class P24_Buy_And_Sell_IIII {

    public static void main(String[] args) {
        P24_Buy_And_Sell_IIII o = new P24_Buy_And_Sell_IIII();
        int[] prices = {2, 4, 1};
        int k = 2;
        System.out.println(o.maxProfit(k, prices));
    }

    public int maxProfit(int k, int[] prices) {
        //    return solve(prices, k, 0, true, 0);
        //    return solveDP(prices, k);
        return solveSO(prices, k);
    }

    private int solve(int[] stocks, int k, int index, boolean buy, int transactions) {
        if (index >= stocks.length || transactions >= k) {
            return 0;
        }
        if (buy) {
            int buyIt = solve(stocks, k, index + 1, false, transactions) - stocks[index];
            int dontBuy = solve(stocks, k, index + 1, true, transactions);
            return Math.max(buyIt, dontBuy);
        } else {
            int sellIt = solve(stocks, k, index + 1, true, transactions + 1) + stocks[index];
            int dontSell = solve(stocks, k, index + 1, false, transactions);
            return Math.max(sellIt, dontSell);
        }
    }

    private int solveDP(int[] stocks, int k) {
        int n = stocks.length;
        int[][][] dp = new int[n + 1][2][k + 1];
        int TRUE = 0;
        int FALSE = 1;

        for (int index = n - 1; index >= 0; index--) {
            for (int buyIndex = 1; buyIndex >= 0; buyIndex--) {
                for (int transactions = k - 1; transactions >= 0; transactions--) {
                    boolean buy = buyIndex == 0;
                    if (buy) {
                        int buyIt = dp[index + 1][FALSE][transactions] - stocks[index];
                        int dontBuy = dp[index + 1][TRUE][transactions];
                        dp[index][buyIndex][transactions] = Math.max(buyIt, dontBuy);
                    } else {
                        int sellIt = dp[index + 1][TRUE][transactions + 1] + stocks[index];
                        int dontSell = dp[index + 1][FALSE][transactions];
                        dp[index][buyIndex][transactions] = Math.max(sellIt, dontSell);
                    }
                }
            }
        }
        return dp[0][TRUE][0];
    }

    private int solveSO(int[] stocks, int k) {
        int n = stocks.length;
        int[][] cur = new int[2][k + 1];
        int[][] next = new int[2][k + 1];
        int TRUE = 0;
        int FALSE = 1;

        for (int index = n - 1; index >= 0; index--) {
            for (int buyIndex = 1; buyIndex >= 0; buyIndex--) {
                for (int transactions = k - 1; transactions >= 0; transactions--) {
                    boolean buy = buyIndex == 0;
                    if (buy) {
                        int buyIt = next[FALSE][transactions] - stocks[index];
                        int dontBuy = next[TRUE][transactions];
                        cur[buyIndex][transactions] = Math.max(buyIt, dontBuy);
                    } else {
                        int sellIt = next[TRUE][transactions + 1] + stocks[index];
                        int dontSell = next[FALSE][transactions];
                        cur[buyIndex][transactions] = Math.max(sellIt, dontSell);
                    }
                }
            }
            next = cur;
        }
        return cur[TRUE][0];
    }

}
