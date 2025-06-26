package com.sunil.dsa.categories.z_dp;

public class P27_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        P27_LongestPalindromicSubsequence o = new P27_LongestPalindromicSubsequence();
        String s = "bbbab";
        System.out.println(o.longestPalindromeSubseq(s));
        System.out.println(o.solveDP(s));
    }

    public int longestPalindromeSubseq(String s) {
        return solve(s, 0, s.length() - 1);
    }


    private int solve(String s, int start, int end) {
        if (start == end) {
            return 1;
        }
        if (start > end) {
            return 0;
        }

        if (s.charAt(start) == s.charAt(end)) {
            return 2 + solve(s, start + 1, end - 1);
        } else {
            return Math.max(solve(s, start + 1, end), solve(s, start, end - 1));
        }
    }

    private int solveDP(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int start = n - 1; start >= 0; start--) {
            for (int end = start + 1; end < n; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 2 + dp[start + 1][end - 1];
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    private int solveSO(String s) {
        int n = s.length();
        int[] next = new int[n];  // dp[end]

        for (int start = n - 1; start >= 0; start--) {
            int[] cur = new int[n];
            cur[start] = 1; // base case: single character
            int prevDiagonal = 0; // this will simulate dp[start+1][end-1]

            for (int end = start + 1; end < n; end++) {
                int temp = next[end]; // store current dp[end] before it gets overwritten
                if (s.charAt(start) == s.charAt(end)) {
                    cur[end] = 2 + prevDiagonal;
                } else {
                    cur[end] = Math.max(next[end], cur[end - 1]);
                }
                prevDiagonal = temp; // move diagonal forward
            }
            next = cur;
        }
        return next[n - 1];
    }



}
