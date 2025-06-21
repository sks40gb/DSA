package practice2;

public class BuySell {

    public static void main(String[] args) {
        BuySell o = new BuySell();
        System.out.println(o.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); //5
        System.out.println(o.maxProfit(new int[]{7, 6, 4, 3, 1})); //5
    }

    public int maxProfit(int[] stocks) {
        return makeTransaction(stocks, true, 0, 2);
    }

    private int makeTransaction(int[] stocks, boolean buy, int index, int limit) {
        if (limit < 0) {
            return 0;
        }
        if (index >= stocks.length) {
            return 0;
        }
        if (buy) {
            int take = makeTransaction(stocks, false, index + 1, limit - 1) - stocks[index];
            int dontBuy = makeTransaction(stocks, true, index + 1, limit);
            return Math.max(take, dontBuy);
        } else {
            int sell = makeTransaction(stocks, true, index + 1, limit - 1) + stocks[index];
            int dontSell = makeTransaction(stocks, false, index + 1, limit);
            return Math.max(sell, dontSell);
        }
    }
}
