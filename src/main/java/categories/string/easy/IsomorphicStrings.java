package categories.string.easy;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/isomorphic-strings/?envType=problem-list-v2&envId=ehkbkaxt
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        boolean result = new IsomorphicStrings().isIsomorphic(s, t);
        System.out.println(result);
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                }
            }
        }
        return true;
    }
}
