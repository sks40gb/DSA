package categories.string.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "cdd";
        List<List<String>> result = new PalindromePartitioning().partition(s);
        System.out.println(result);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        collectPartition(s, new ArrayList<>(), result);
        return result;
    }

    private void collectPartition(String s, List<String> current, List<List<String>> result) {

        if (s.isEmpty()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int index = 1; index <= s.length(); index++) {
            String leftS = s.substring(0, index);
            String rightS = s.substring(index);

            if (isPalindrome(leftS)) {
                current.add(leftS);
                collectPartition(rightS, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
