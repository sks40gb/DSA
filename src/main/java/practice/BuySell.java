package practice;

public class BuySell {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};

        int max = getMaxProfit(prices);
        System.out.println(max);
    }

    private static int getMaxProfit(int[] prices) {
        int max = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i=0; i < prices.length; i++){
            minValue = Math.min(minValue, prices[i]);
            max = Math.max(max, prices[i]-minValue);
        }
        return max;
    }


}
