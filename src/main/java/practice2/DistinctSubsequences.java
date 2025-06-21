package practice2;

import java.util.Arrays;

public class DistinctSubsequences {

    public static void main(String[] args) {
        DistinctSubsequences o = new DistinctSubsequences();
        System.out.println(o.numDistinct("rabbbit", "rabbit")); //3
        System.out.println(o.numDistinct("babgbag", "bag"));    //5
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return distinct(s, t, s.length(), t.length(), dp);
    }

    public int distinct(String s, String t, int m, int n, int[][] dp ) {
        if (n == 0) {
            return 1;
        }
        if (m <= 0) {
            return 0;
        }
        int times = 0;
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            int take = distinct(s, t, m - 1, n - 1, dp);
            int dontTake = distinct(s, t, m - 1, n, dp);
            times += take + dontTake;
        } else {
            times += distinct(s, t, m - 1, n, dp);
        }
        return dp[m][n] = times;
    }
}
