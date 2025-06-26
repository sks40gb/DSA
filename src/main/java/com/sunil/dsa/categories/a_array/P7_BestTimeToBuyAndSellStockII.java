package com.sunil.dsa.categories.a_array;

/**
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 */
public class P7_BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        P7_BestTimeToBuyAndSellStockII o = new P7_BestTimeToBuyAndSellStockII();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(o.maxProfit(prices));
    }

    public int maxProfit(int[] stocks) {
        int profit = 0;
        for (int i = 1; i < stocks.length; i++) {
            if (stocks[i - 1] < stocks[i]) {
                profit = profit + (stocks[i] - stocks[i - 1]);
            }
        }
        return profit;
    }
}
