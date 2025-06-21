package practice;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        return longest(s, 0, s.length() - 1);
    }

    private int longest(String s, int i, int j) {
        // Base cases
        if (i > j) return 0;
        if (i == j) return 1;
        // Recursive cases
        if (s.charAt(i) == s.charAt(j)) {
            return 2 + longest(s, i + 1, j - 1);
        } else {
            return Math.max(longest(s, i + 1, j), longest(s, i, j - 1));
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        int n = s.length();
        int[][] dp = new int[n][n];

        // Initialize the DP table for substrings of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the DP table
        System.out.println("------------->");
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                System.out.printf("[%s,%s] ", i, j);
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
            System.out.println();
        }

        LongestPalindromicSubsequence solution = new LongestPalindromicSubsequence();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));  // Output: 4
        System.out.println(solution.longestPalindromeSubseq("cbbd"));   // Output: 2
    }
}
