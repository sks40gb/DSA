package com.sunil.dsa.categories.z_dp;

public class P28_EditDistance {
    public static void main(String[] args) {
        P28_EditDistance o = new P28_EditDistance();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(o.minDistance(word1, word2));
        System.out.println(o.solveDP(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        return solve(word1, word2, 0, 0);
    }

    private int solve(String word1, String word2, int index1, int index2) {

        if (index1 >= word1.length() && index2 >= word2.length()) {
            return 0;
        }
        if (index1 >= word1.length()) {
            return word2.length() - index2;
        }
        if (index2 >= word2.length()) {
            return word1.length() - index1;
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            return solve(word1, word2, index1 + 1, index2 + 1);
        } else {
            int replace = solve(word1, word2, index1 + 1, index2 + 1);
            int remove = solve(word1, word2, index1 + 1, index2);
            int insert = solve(word1, word2, index1, index2 + 1);
            return 1 + Math.min(replace, Math.min(remove, insert));
        }
    }

    private int solveDP(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: convert remaining part of word1 to empty (deletion)
        for (int i = 0; i <= m; i++) {
            dp[i][n] = m - i;
        }

        // Base cases: convert empty to remaining part of word2 (insertion)
        for (int j = 0; j <= n; j++) {
            dp[m][j] = n - j;
        }

        // Bottom-up DP
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int replace = dp[i + 1][j + 1];
                    int remove = dp[i + 1][j];
                    int insert = dp[i][j + 1];
                    dp[i][j] = 1 + Math.min(replace, Math.min(remove, insert));
                }
            }
        }

        return dp[0][0];
    }

    private int solveSO(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] next = new int[n + 1];
        int[] current = new int[n + 1];

        // Base case: converting empty word1 to word2
        for (int j = 0; j <= n; j++) {
            next[j] = n - j;
        }

        for (int i = m - 1; i >= 0; i--) {
            // Base case: converting word1[i:] to empty word2
            current[n] = m - i;

            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    current[j] = next[j + 1];
                } else {
                    int insert = current[j + 1];
                    int remove = next[j];
                    int replace = next[j + 1];
                    current[j] = 1 + Math.min(replace, Math.min(remove, insert));
                }
            }

            // Move current to next for next iteration
            int[] temp = next;
            next = current;
            current = temp;
        }

        return next[0];
    }



}
