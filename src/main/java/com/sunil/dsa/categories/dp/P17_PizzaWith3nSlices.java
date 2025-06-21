package com.sunil.dsa.categories.dp;

public class P17_PizzaWith3nSlices {

    public static void main(String[] args) {
        P17_PizzaWith3nSlices o = new P17_PizzaWith3nSlices();
        int[] slices = {1, 2, 3, 4, 5, 6};
        System.out.println(o.maxSizeSlices(slices));
    }

    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int cnt = n / 3;
//        return Math.max(solve(slices, 0, n - 2, cnt), solve(slices, 1, n - 1, cnt));
        return Math.max(solveTab(slices, 0, n - 2, cnt), solveTab(slices, 1, n - 1, cnt));
    }

    private int solve(int[] slices, int start, int index, int cnt) {
        if (cnt == 0 || index < start) {
            return 0;
        }
        int take = slices[index] + solve(slices, start, index - 2, cnt - 1);
        int dontTake = solve(slices, start, index - 1, cnt);
        return Math.max(take, dontTake);
    }

    //My version
    private int solveTab1(int[] slices, int start, int end, int CNT) {
        int length = end - start + 1;
        int[][] dp = new int[length + 2][CNT + 1];
        for (int index = start + 2; index <= length; index++) {
            for (int cnt = 1; cnt <= CNT; cnt++) {
                int take = slices[index] + index - 2 >= 0 ? dp[index - 2][cnt - 1] : 0;
                int dontTake = dp[index - 1][cnt];
                dp[index][cnt] = Math.max(take, dontTake);
            }
        }
        return dp[end][CNT];
    }

    //Fixed version
    private int solveTab(int[] slices, int start, int end, int CNT) {
        int len = end - start + 1;
        int[][] dp = new int[len + 2][CNT + 1]; // +2 for safe dp[index - 2]

        for (int index = 1; index <= len; index++) {
            for (int cnt = 1; cnt <= CNT; cnt++) {
                int take = slices[start + index - 1] + ((index >= 2) ? dp[index - 2][cnt - 1] : 0);
                int dontTake = dp[index - 1][cnt];
                dp[index][cnt] = Math.max(take, dontTake);
            }
        }
        return dp[len][CNT];
    }

    private int solveSO(int[] slices, int start, int end, int CNT) {
        int len = end - start + 1;

        int[] prev2 = new int[CNT + 1];
        int[] prev1 = new int[CNT + 1];
        int[] curr = new int[CNT + 1];

        for (int index = 1; index <= len; index++) {
            for (int cnt = 1; cnt <= CNT; cnt++) {
                int take = slices[start + index - 1] + prev2[cnt - 1];
                int dontTake = prev1[cnt];
                curr[cnt] = Math.max(take, dontTake);
            }
            // Slide the windows
            prev2 = prev1;
            prev1 = curr;
            curr = new int[CNT + 1]; // reset for next iteration
        }

        return prev1[CNT];
    }

}
