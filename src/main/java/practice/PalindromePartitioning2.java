package practice;

public class PalindromePartitioning2 {

    public int minCut(String s) {
        int n = s.length();
        if (n == 0) return 0;

        boolean[][] dp = new boolean[n][n];
        int[] cuts = new int[n];

        for (int i = 0; i < n; i++) {
            int minCuts = i;  // Maximum cuts possible
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (j == 0) {
                        minCuts = 0;
                    } else {
                        minCuts = Math.min(minCuts, cuts[j - 1] + 1);
                    }
                }
            }
            cuts[i] = minCuts;
        }

        return cuts[n - 1];
    }

    public static void main(String[] args) {
        PalindromePartitioning2 solution = new PalindromePartitioning2();
        System.out.println(solution.minCut("aab"));  // Output: 1
        System.out.println(solution.minCut("a"));    // Output: 0
        System.out.println(solution.minCut("ab"));   // Output: 1
    }
}
