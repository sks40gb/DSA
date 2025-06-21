package dp;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        MinCostClimbingStairs o = new MinCostClimbingStairs();
        int result = o.minCostClimbingStairs(cost);
        System.out.println(result);
    }

    public int minCostDP(int[] cost, int step) {
        int[] dp = new int[step+2];
        dp[0] = 0;
        dp[1] = cost[1];
        dp[2] = cost[2];

        for (int i = 3; i < cost.length; i++) {
            int take = Math.min(dp[i], dp[step-1]);
            int dontTake = Math.min(dp[i], dp[step-2]);
            dp[i] = Math.min(take, dontTake);
        }
        return dp[dp.length-1];
    }

    public int minCostClimbingStairs(int[] cost) {
        int first = minCostDP(cost, cost.length - 1);
        int second = minCostDP(cost, cost.length - 2);
        return Math.min(first, second);
    }

    private int minCost(int[] cost, int step) {
        if (step < 0) {
            return 0;
        }
        if (step <= 1) {
            return cost[step];
        }
        int take = minCost(cost, step - 1);
        int dontTake = minCost(cost, step - 2);
        return Math.min(take, dontTake) + cost[step];
    }
}
