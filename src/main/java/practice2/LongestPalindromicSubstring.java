package practice2;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babaddtattarrattatddetartrateedredividerb";
        String result = longestPalindrome(s);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalidrome(sub)) {
                    if (sub.length() > result.length()) {
                        result = sub;
                    }
                }
            }
        }
        return result;
    }

    private static boolean isPalidrome(String s) {
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
