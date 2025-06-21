package categories.string.easy;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/description/?source=submission-ac
 */
public class ValidPalindrome2 {
    public static void main(String[] args) {
        String input = "abca";
        boolean result = new ValidPalindrome2().validPalindrome(input);
        System.out.println(result);
    }
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // Check if skipping one character from either side makes it a palindrome
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
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

