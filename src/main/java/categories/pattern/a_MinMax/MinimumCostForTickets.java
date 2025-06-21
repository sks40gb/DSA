package categories.pattern.a_MinMax;

import java.util.Arrays;

public class MinimumCostForTickets {

    public static void main(String[] args) {
        MinimumCostForTickets solution = new MinimumCostForTickets();
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = {2, 7, 15};
        System.out.println("Answer : " + solution.mincostTickets(days, costs)); // Output: 11
    }

    private int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return minCost(days, costs, 0, dp);
    }

    private int minCost(int[] days, int[] costs, int index, int[] dp) {
        if (index >= days.length) {
            return 0;
        }
        if (dp[index] >= 0) {
            return dp[index];
        }
        int cost1 = costs[0] + minCost(days, costs, getNextIndex(days, index, 1), dp);
        int cost7 = costs[1] + minCost(days, costs, getNextIndex(days, index, 7), dp);
        int cost30 = costs[2] + minCost(days, costs, getNextIndex(days, index, 30), dp);
        return dp[index] = Math.min(cost1, Math.min(cost7, cost30));
    }

    private int getNextIndex(int[] days, int currentIndex, int duration) {
        int maxDays = days[currentIndex] + duration;
        int nextIndex = days.length;
        for (int i = currentIndex; i < days.length; i++) {
            if (maxDays <= days[i]) {
                nextIndex = i;
                break;
            }
        }
        return nextIndex;
    }

}
