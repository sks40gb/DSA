package categories.string.medium;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        int result = new LongestPalindromicSubsequence().longestPalindromeSubseq(s);
        System.out.println(result);
    }

    public int longestPalindromeSubseq(String s) {
        return maxPoli(s, 0, s.length() - 1);
    }

    public int maxPoli(String s, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return 1;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return 2 + maxPoli(s, left + 1, right - 1);
        } else {
            return Math.max(maxPoli(s, left + 1, right),
                    maxPoli(s, left, right - 1));
        }
    }


}
