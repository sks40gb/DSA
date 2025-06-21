package practice2;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        PalindromicSubstrings o = new PalindromicSubstrings();
        System.out.println(o.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        return count(s, 0, s.length() - 1);
    }

    private int count(String s, int start, int end) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandFromCenter(s, i, i);
            count += expandFromCenter(s, i, i + 1);
        }
        return count;
    }

    private int expandFromCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            //count for each match
            count++;
            left--;
            right++;
        }
        return count;
    }
}
