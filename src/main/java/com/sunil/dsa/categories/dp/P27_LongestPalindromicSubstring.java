package com.sunil.dsa.categories.dp;

import java.util.HashMap;
import java.util.Map;

public class P27_LongestPalindromicSubstring {

    public static void main(String[] args) {
        P27_LongestPalindromicSubstring o = new P27_LongestPalindromicSubstring();
        String s = "babad";
        System.out.println(o.longestPalindrome(s));
        System.out.println(o.solveString(s));
    }

    public String longestPalindrome(String s) {
//        return solve(s, 0, s.length() - 1);
        return solveDP(s);
    }

    private String solveBF(String s) {
        String maxString = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPoli(sub)) {
                    if (sub.length() > maxString.length()) {
                        maxString = sub;
                    }
                }
            }
        }
        return maxString;
    }

    private String solve(String s, int left, int right) {
        if (left == right) {
            return String.valueOf(s.charAt(left));
        }
        String sub = s.substring(left, right + 1);
        if (isPoli(sub)) {
            return sub;
        } else {
            String p = "";
            String leftS = solve(s, left + 1, right);
            String rightS = solve(s, left, right - 1);
            if (isPoli(leftS)) {
                p = leftS;
            }
            if (isPoli(rightS)) {
                p = p.length() > rightS.length() ? p : rightS;
            }
            return p;
        }

    }

    private String solveDP(String s) {
        int n = s.length();
        String[][] dp = new String[n + 1][n + 1];

        //base condition
        for (int i = 0; i < n; i++) {
            dp[i][i] = String.valueOf(s.charAt(i));
        }

        for (int left = n - 1; left >= 0; left--) {
            for (int right = left; right < n; right++) {
                String sub = s.substring(left, right + 1);
                if (isPoli(sub)) {
                    dp[left][right] = sub;
                } else {
                    String p = "";
                    String leftS = dp[left + 1][right];
                    String rightS = dp[left][right - 1];
                    if (isPoli(leftS)) {
                        p = leftS;
                    }
                    if (isPoli(rightS)) {
                        p = p.length() > rightS.length() ? p : rightS;
                    }
                    dp[left][right] = p;
                }

            }
        }
        return dp[0][n - 1];
    }

    private String solveString(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i); //odd expand
            int len2 = expand(s, i, i + 1);// even expand
            int len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    private boolean isPoli(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
