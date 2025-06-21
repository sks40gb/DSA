package t150.array_and_string;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock o = new BestTimeToBuyAndSellStock();
        int[] arr = {7,1,5,3,6,4};
        System.out.println(o.maxProfit(arr));
    }

    public int maxProfit(int[] stocks) {
        int minAmount = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < stocks.length; i++) {
            if(stocks[i] < minAmount){
                minAmount = stocks[i];
            }
            maxProfit = Math.max(maxProfit, stocks[i] - minAmount);
        }
        return maxProfit;
    }
}
