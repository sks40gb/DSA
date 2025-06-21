package com.sunil.dsa.categories.dp;

public class P23_Buy_And_Sell_III {

    public static void main(String[] args) {
        P23_Buy_And_Sell_III o = new P23_Buy_And_Sell_III();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(o.maxProfit(prices));
    }

    public int maxProfit(int[] stocks) {
//        return solve(stocks, 0, true, 0);
//        return solveDP(stocks);
        return solveSO(stocks);
    }

    private int solve(int[] stocks, int index, boolean buy, int transactions) {
        if (index >= stocks.length || transactions >= 2) {
            return 0;
        }
        if (buy) {
            int buyIt = solve(stocks, index + 1, false, transactions) - stocks[index];
            int dontBuy = solve(stocks, index + 1, true, transactions);
            return Math.max(buyIt, dontBuy);
        } else {
            int sellIt = solve(stocks, index + 1, true, transactions + 1) + stocks[index];
            int dontSell = solve(stocks, index + 1, false, transactions);
            return Math.max(sellIt, dontSell);
        }
    }

    private int solveDP(int[] stocks) {
        int n = stocks.length;
        int[][][] dp = new int[n + 1][2][3];
        int TRUE = 0;
        int FALSE = 1;

        for (int index = n - 1; index >= 0; index--) {
            for (int buyIndex = 1; buyIndex >= 0; buyIndex--) {
                for (int transactions = 1; transactions >= 0; transactions--) {
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


    private int solveSO(int[] stocks) {
        int n = stocks.length;
        int[][] cur = new int[2][3];
        int[][] next = new int[2][3];
        int TRUE = 0;
        int FALSE = 1;

        for (int index = n - 1; index >= 0; index--) {
            for (int buyIndex = 1; buyIndex >= 0; buyIndex--) {
                for (int transactions = 1; transactions >= 0; transactions--) {
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
