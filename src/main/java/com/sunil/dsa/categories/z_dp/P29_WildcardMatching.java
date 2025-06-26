package com.sunil.dsa.categories.z_dp;

import java.util.Arrays;

public class P29_WildcardMatching {

    public static void main(String[] args) {
        P29_WildcardMatching o = new P29_WildcardMatching();
        String s = "aa";
        String p = "*";
        System.out.println(o.isMatch(s, p));
        System.out.println(o.solveDP(s, p));
        System.out.println(o.solveSO(s, p));
    }

    public boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    private boolean solve(String s, String p, int i1, int i2) {
        int m = s.length();
        int n = p.length();
        if (i1 == m && i2 == n) {
            return true;
        }
        if (i1 >= m) {
            while (i2 < n) {
                if (p.charAt(i2) != '*') {
                    return false;
                }
                i2++;
            }
            return true;
        }
        if (i2 >= n) {
            return false;
        }

        if (s.charAt(i1) == p.charAt(i2) || p.charAt(i2) == '?') {
            return solve(s, p, i1 + 1, i2 + 1);
        }
        if (p.charAt(i2) == '*') {
            return solve(s, p, i1, i2 + 1) || solve(s, p, i1 + 1, i2);
        }
        return false;
    }

    private boolean solveDP(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[m][n] = true;

        for (int i2 = n-1; i2 >= 0; i2--) {
            if (p.charAt(i2) == '*') {
                dp[m][i2] = dp[m][i2 + 1];
            } else {
                dp[m][i2] = false;
            }
        }

        for (int i1 = m - 1; i1 >= 0; i1--) {
            for (int i2 = n - 1; i2 >= 0; i2--) {
                if (s.charAt(i1) == p.charAt(i2) || p.charAt(i2) == '?') {
                    dp[i1][i2] = dp[i1 + 1][i2 + 1];
                }
                if (p.charAt(i2) == '*') {
                    dp[i1][i2] = dp[i1][i2 + 1] || dp[i1 + 1][i2];
                }
            }
        }
        return dp[0][0];
    }

    private boolean solveSO(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[] cur = new boolean[n + 1];
        boolean[] next = new boolean[n + 1];

        next[n] = true;

        for (int i2 = n-1; i2 >= 0; i2--) {
            if (p.charAt(i2) == '*') {
                next[i2] = next[i2 + 1];
            } else {
                next[i2] = false;
            }
        }

        for (int i1 = m - 1; i1 >= 0; i1--) {
            for (int i2 = n - 1; i2 >= 0; i2--) {
                if (s.charAt(i1) == p.charAt(i2) || p.charAt(i2) == '?') {
                    cur[i2] = next[i2 + 1];
                }
                if (p.charAt(i2) == '*') {
                    cur[i2] = cur[i2 + 1] || next[i2];
                }
            }
            next = cur.clone();
            Arrays.fill(cur, false); // Reset for next iteration
        }
        return next[0];
    }



}
