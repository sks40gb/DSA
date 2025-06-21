package com.sunil.dsa.categories.dp;

public class P22_Buy_And_Sell_I {

    public static void main(String[] args) {
        P22_Buy_And_Sell_I o = new P22_Buy_And_Sell_I();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(o.maxProfit(prices));
    }

    public int maxProfit(int[] stocks) {
        return solveBF(stocks);
    }

    public int solveBF(int[] stocks) {
        int max = 0;
        for (int i = 0; i < stocks.length; i++) {
            for (int j = i + 1; j < stocks.length; j++) {
                max = Math.max(max, stocks[j] - stocks[i]);
            }
        }
        return max;
    }

    public int solveOS(int[] stocks) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < stocks.length; i++) {
           min = Math.min(min, stocks[i]);
           maxProfit = Math.max(maxProfit, stocks[i] - min);
        }
        return maxProfit;
    }
}
