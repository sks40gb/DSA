package practice;

public class MaxProfit {

    public static void main(String[] args) {

        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        int result = maxProfit(arr,0,true);
        System.out.println(result);
    }

    private static int maxProfit(int[] arr, int index, boolean buy) {
        if(index >= arr.length){
            return 0;
        }
        int buyIt =  Integer.MIN_VALUE;
        int sellIt =  Integer.MIN_VALUE;

        if(buy){
            buyIt =  maxProfit(arr, index+1, false) - arr[index];
        }else{
            sellIt = maxProfit(arr, index+1, true) + arr[index];
        }

        int skip = maxProfit(arr, index+1, buy);
        return Math.max(skip,Math.max(buyIt,sellIt));
    }
}
