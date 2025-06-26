package com.sunil.dsa.categories.z_dp;

public class P26_LongestCommonSubsequence {

    public static void main(String[] args) {
        P26_LongestCommonSubsequence o = new P26_LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(o.longestCommonSubsequence(text1, text2));
        System.out.println(o.solveDP(text1, text2));
        System.out.println(o.solveSO(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return solve(text1, text2, 0, 0);
    }

    private int solve(String text1, String text2, int index1, int index2) {
        if (index1 >= text1.length() || index2 >= text2.length()) {
            return 0;
        }
        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + solve(text1, text2, index1 + 1, index2 + 1);
        } else {
            return Math.max(solve(text1, text2, index1 + 1, index2), solve(text1, text2, index1, index2 + 1));
        }
    }

    private int solveDP(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int index1 = m - 1; index1 >= 0; index1--) {
            for (int index2 = n - 1; index2 >= 0; index2--) {
                if (text1.charAt(index1) == text2.charAt(index2)) {
                    dp[index1][index2] = 1 + dp[index1 + 1][index2 + 1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1 + 1][index2], dp[index1][index2 + 1]);
                }
            }
        }
        return dp[0][0];
    }

    private int solveSO(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] cur = new int[n + 1];
        int[] next = new int[n + 1];
        for (int index1 = m - 1; index1 >= 0; index1--) {
            for (int index2 = n - 1; index2 >= 0; index2--) {
                if (text1.charAt(index1) == text2.charAt(index2)) {
                    cur[index2] = 1 + next[index2 + 1];
                } else {
                    cur[index2] = Math.max(next[index2], cur[index2 + 1]);
                }
            }
            next = cur.clone();
        }
        return cur[0];
    }
}
