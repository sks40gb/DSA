package categories.string.easy;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {
    public static void main(String[] args) {
        String s = "abcaa";
        String goal = "abcbb";
        boolean result = new BuddyStrings().buddyStrings(s, goal);
        System.out.println(result);
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            return hasDuplicateCharacters(s);
        }

        int firstMismatch = -1;
        int secondMismatch = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (firstMismatch == -1) {
                    firstMismatch = i;
                } else if (secondMismatch == -1) {
                    secondMismatch = i;
                } else {
                    return false;
                }
            }
        }

        return secondMismatch != -1 &&
                s.charAt(firstMismatch) == goal.charAt(secondMismatch) &&
                s.charAt(secondMismatch) == goal.charAt(firstMismatch);
    }

    private boolean hasDuplicateCharacters(String s) {
        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!charSet.add(c)) {
                return true;
            }
        }
        return false;
    }
}
