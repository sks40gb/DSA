package practice2;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        LongestCommonSubsequence o = new LongestCommonSubsequence();
        System.out.println(o.longestCommonSubsequence("abcde", "ace")); //3
        System.out.println(o.longestCommonSubsequence("abc", "def")); //0
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return longest(s1, s2, m, n, dp);
    }

    public int longest(String s1, String s2, int m, int n, int[][] dp) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return dp[m][n] = 1 + longest(s1, s2, m - 1, n - 1, dp);
        } else {
            return dp[m][n] = Math.max(longest(s1, s2, m - 1, n, dp), longest(s1, s2, m, n - 1, dp));
        }
    }
}
