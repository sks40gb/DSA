package dp;

public class Knapsack {
    public static void main(String[] args) {
        int W = 4;
        int[] val = {1, 2, 3};
        int[] wt = {4, 5, 1};
        int result = new Knapsack().knapsack2(wt, val, W);
        System.out.println(result);
    }

    private int skapsack(int[] wt, int[] val, int w) {
        int n = wt.length;
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i < wt.length; i++) {
            for (int j = 1; j < w; j++) {
                //if weight is permissible
                if (j - wt[i] >= 0) {
                    dp[i][j] = Math.max(val[i] + dp[i - 1][j - wt[i]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }

    private int knapsack2(int[] wt, int[] val, int w) {
        int n = wt.length;
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }

    private int knapsack(int[] wt, int[] val, int w) {
        int n = wt.length;
        int[][] dp = new int[n + 1][w + 1];

        for (int j = 0; j <= w; j++) {
            dp[0][j] = j >= wt[0] ? val[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j >= wt[i]) {
                    dp[i][j] = Math.max(val[i] + dp[i - 1][j - wt[i]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n-1][w];
    }
}
