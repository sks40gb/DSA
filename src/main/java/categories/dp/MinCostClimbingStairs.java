package categories.dp;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int result = new MinCostClimbingStairs().minCostClimbingStairs(cost);
        System.out.println(result);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        int min1 = minCost(cost, 0, dp);
        int min2 = minCost(cost, 1, dp);
        return Math.min(min1, min2);
    }

    private int minCost(int[] cost, int step, int[] dp ) {
        int len = cost.length;
        if (step >= len) {
            return 0;
        }
        if(dp[step] > -1){
            return dp[step];
        }
        int takeOne = minCost(cost, step + 1,dp);
        int takeTwo = minCost(cost, step + 2, dp);
        return dp[step] = Math.min(takeOne, takeTwo) + cost[step];
    }

}
