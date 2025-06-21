package dp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P3_WordBreak {

    public static void main(String[] args) {

        P3_WordBreak o = new P3_WordBreak();
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        List<String> list = new ArrayList<>(Arrays.asList(wordDict));
        System.out.println(o.wordBreak(s, list));
        System.out.println(o.solveDP(s, list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict, 0);
    }

    private boolean solve(String s, List<String> wordDict, int start) {
        int n = s.length();
        if (start == n) {
            return true;
        }
        boolean matched = false;
        for (int end = start + 1; end <= n; end++) {
            if (wordDict.contains(s.substring(start, end))) {
                matched = matched || solve(s, wordDict, end);
            }
        }
        return matched;
    }

    private boolean solveDP(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int start = n-1; start >=0 ; start--) {
            boolean matched = false;
            for (int end = start + 1; end <= n; end++) {
                if (wordDict.contains(s.substring(start, end))) {
                    matched = matched || dp[end];
                }
            }
            dp[start] = matched;
        }
        return dp[0];
    }
}