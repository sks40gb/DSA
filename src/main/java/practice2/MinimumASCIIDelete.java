package practice2;

import java.util.Arrays;

public class MinimumASCIIDelete {

    public static void main(String[] args) {
        MinimumASCIIDelete o = new MinimumASCIIDelete();
        System.out.println(o.minimumDeleteSum("sea", "eat")); //231
        System.out.println(o.minimumDeleteSum("delete", "leet")); //403
    }

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        return minimumAsciiSum(s1, s2, m, n, dp);
    }

    private int minimumAsciiSum(String s1, String s2, int m, int n, int[][] dp) {

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if (m <= 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += s2.charAt(i);
            }
            return sum;
        }

        if (n <= 0) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += s1.charAt(i);
            }
            return sum;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return dp[m][n] = minimumAsciiSum(s1, s2, m - 1, n - 1,dp);
        } else {
            return dp[m][n] = Math.min(minimumAsciiSum(s1, s2, m - 1, n, dp) + (int) s1.charAt(m - 1),
                    minimumAsciiSum(s1, s2, m, n - 1, dp) + (int) s2.charAt(n - 1));
        }
    }
}
