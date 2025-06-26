package com.sunil.dsa.categories.z_dp;

public class P10_MinimumCostForTickets {
    public static void main(String[] args) {
        P10_MinimumCostForTickets o = new P10_MinimumCostForTickets();
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(o.mincostTickets(days, costs));
        System.out.println(o.minCostDP(days, costs));
    }

    public int mincostTickets(int[] days, int[] costs) {
        return minCost(days, costs, 0);
    }

    private int minCost(int[] days, int[] costs, int index) {
        if (index >= days.length) {
            return 0;
        }
        int day1 = costs[0] + minCost(days, costs, index + 1);
        int day7 = costs[1] + minCost(days, costs, nextIndex(days, index, 7));
        int day30 = costs[2] + minCost(days, costs, nextIndex(days, index, 30));
        return Math.min(day1, Math.min(day7, day30));
    }

    public int minCostDP(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1]; // dp[i] is min cost to travel from day[i] to end

        for (int i = n - 1; i >= 0; i--) {
            int day1 = costs[0] + dp[i + 1];
            int day7 = costs[1] + dp[nextIndex(days, i, 7)];
            int day30 = costs[2] + dp[nextIndex(days, i, 30)];
            dp[i] = Math.min(day1, Math.min(day7, day30));
        }

        return dp[0];
    }


    private int nextIndex(int[] days, int currentIndex, int duration) {
        int upcomingDay = days[currentIndex] + duration;
        while (currentIndex < days.length && days[currentIndex] < upcomingDay) {
            currentIndex++;
        }
        return currentIndex;
    }
}
