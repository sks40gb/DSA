package practice2;

import java.util.Arrays;

public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
        ShortestCommonSuperSequence o = new ShortestCommonSuperSequence();
        System.out.println(o.shortestCommonSuperSequence("abac", "cab")); //cabac
    }

    public String shortestCommonSuperSequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        String[][] dp = new String[m + 1][n + 1];
        return superSequence(s1, s2, m, n, dp);
    }

    private String superSequence(String s1, String s2, int m, int n, String[][] dp) {
        if (m <= 0) {
            return s2.substring(0, n);
        }
        if (n <= 0) {
            return s1.substring(0, m);
        }
        if(dp[m][n] != null){
            return dp[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return  dp[m][n] =superSequence(s1, s2, m - 1, n - 1, dp) + s1.charAt(m - 1);
        } else {
            String option1 = superSequence(s1, s2, m, n - 1, dp) + s2.charAt(n - 1);
            String option2 = superSequence(s1, s2, m - 1, n, dp) + s1.charAt(m - 1);
            return dp[m][n] = option1.length() > option2.length() ? option2 : option1;
        }
    }
}
