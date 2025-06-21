package dp;

public class MinimumCostForTickets {

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        MinimumCostForTickets o = new MinimumCostForTickets();
        System.out.println(o.minCost(days, costs, 0));
        System.out.println(o.minCostDP(days, costs));
    }

    private int minCost(int[] days, int[] costs, int index) {
        if (index >= days.length) {
            return 0;
        }
        int day1 = costs[0] + minCost(days, costs, nextIndex(days, index, 1));
        int day7 = costs[1] + minCost(days, costs, nextIndex(days, index, 7));
        int day30 = costs[2] + minCost(days, costs, nextIndex(days, index, 30));
        return Math.min(day1, Math.min(day7, day30));
    }

    private int minCostDP(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        for (int index = n - 1; index >= 0; index--) {
            int day1 = costs[0] + dp[nextIndex(days, index, 1)];
            int day7 = costs[1] + dp[nextIndex(days, index, 7)];
            int day30 = costs[2] + dp[nextIndex(days, index, 30)];
            dp[index] = Math.min(day1, Math.min(day7, day30));
        }
        return dp[0];
    }

    private int nextIndex(int[] days, int index, int duration) {
        int maxDay = days[index] + duration;
        while (index < days.length && days[index] < maxDay) {
            index++;
        }
        return index;
    }

}
