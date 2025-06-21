package dp2;

import javax.swing.plaf.IconUIResource;

public class P7_Knapsack {
    public static void main(String[] args) {
        P7_Knapsack o = new P7_Knapsack();
//        int[] values = {60, 100, 120};
//        int[] weights = {10, 20, 30};
//        int W = 50;

//        int[] values = {10, 20, 30};
//        int[] weights = {60, 70, 80};
//        int W = 50;

        int[] values = {15, 40, 60, 90};
        int[] weights = {1, 2, 3, 5};
        int W = 5;
        int result1 = o.knapsack(weights, values,values.length - 1, W);
        System.out.println(result1);

        int result2 = o.knapsackDP(weights, values, W);
        System.out.println(result2);

        int result3 = o.knapsackSO1(weights, values, W);
        System.out.println(result3);

        int result4 = o.knapsackSO2(weights, values, W);
        System.out.println(result4);
    }

    private int knapsack(int[] weights, int[] values, int i, int w) {

        if (w <= 0 || i < 0) {
            return 0;
        }
        int max = 0;
        //Take
        if (weights[i] <= w) {
            max = Math.max(max, values[i] + knapsack(weights, values,i - 1, w - weights[i]));
        }

        //Dont Take
        max = Math.max(max, knapsack(weights, values,i - 1, w));
        return max;
    }

    private int knapsackDP(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[][] dp = new int[n][W+1];

        for (int w = 0; w <= W; w++) {
            if (weights[0] <= w) {
                dp[0][w] = values[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= W; w++) {
                int max = 0;
                //Take
                if (weights[i] <= w) {
                    max = Math.max(max, values[i] + dp[i - 1][w - weights[i]]);
                }

                //Dont Take
                max = Math.max(max, dp[i - 1][w]);
                dp[i][w] = max;

            }
            
        }
        return dp[n-1][W];
    }

    private int knapsackSO1(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[] prev = new int[W + 1];  // Represents dp[i-1][w]
        int[] curr = new int[W + 1];  // Represents dp[i][w]

        // Initialize first row
        for (int w = 0; w <= W; w++) {
            if (weights[0] <= w) {
                prev[w] = values[0];
            }
        }

        // Build table row by row using two arrays
        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= W; w++) {
                int take = 0;
                if (weights[i] <= w) {
                    take = values[i] + prev[w - weights[i]];
                }
                int dontTake = prev[w];
                curr[w] = Math.max(take, dontTake);
            }
            // Copy curr to prev for next iteration
            System.arraycopy(curr, 0, prev, 0, W + 1);
        }

        return prev[W];
    }


    private int knapsackSO2(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[] dp = new int[W + 1];

        // Initialize first item
        for (int w = 0; w <= W; w++) {
            if (weights[0] <= w) {
                dp[w] = values[0];
            }
        }

        // Build DP table
        for (int i = 1; i < n; i++) {
            for (int w = W; w >= 0; w--) {  // Loop backward!
                if (weights[i] <= w) {
                    dp[w] = Math.max(dp[w], values[i] + dp[w - weights[i]]);
                }
            }
        }

        return dp[W];
    }



}
