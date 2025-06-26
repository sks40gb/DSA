package com.sunil.dsa.categories.a_array;

/**
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class P6_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        P6_BestTimeToBuyAndSellStock o = new P6_BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(o.maxProfit(prices));
    }

    public int maxProfit(int[] stocks) {
        int max = 0;
        int minSoFar = stocks[0];
        for (int i = 1; i < stocks.length; i++) {
            max = Math.max(max, stocks[i] - minSoFar);
            minSoFar = Math.min(minSoFar, stocks[i]);
        }
        return max;
    }
}
