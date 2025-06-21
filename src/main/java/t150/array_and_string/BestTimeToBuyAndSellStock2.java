package t150.array_and_string;

public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 o = new BestTimeToBuyAndSellStock2();
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(o.maxProfit(arr));
    }

    public int maxProfit(int[] stocks) {
        int profit = 0;
        for (int i = 1; i < stocks.length; i++) {
            if(stocks[i-1] < stocks[i]){
                profit += - stocks[i-1] + stocks[i];
            }
        }
        return profit;
    }
}
