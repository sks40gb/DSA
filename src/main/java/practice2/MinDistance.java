package practice2;

import java.util.Arrays;

public class MinDistance {

    public static void main(String[] args) {
        int result = new MinDistance().minDistance("horse", "ros");
        System.out.println(result);

        result = new MinDistance().minDistance("intention", "execution");
        System.out.println(result);
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minDistance(word1, word2, m, n, dp);
    }

    private int minDistance(String word1, String word2, int m, int n, int[][] dp) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            return minDistance(word1, word2, m - 1, n - 1, dp);
        }
        int insert = minDistance(word1, word2, m, n - 1, dp);
        int delete = minDistance(word1, word2, m - 1, n, dp);
        int update = minDistance(word1, word2, m - 1, n - 1, dp);
        return dp[m][n] = 1 + Math.min(Math.min(delete, update), insert);
    }
}
