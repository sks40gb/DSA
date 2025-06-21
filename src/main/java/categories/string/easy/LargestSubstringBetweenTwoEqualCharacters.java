package categories.string.easy;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharacters {

    public static void main(String[] args) {
        String input = "abca";
        int result = new LargestSubstringBetweenTwoEqualCharacters().maxLengthBetweenEqualCharacters(input);
        System.out.println(result);
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int length = i - map.get(s.charAt(i)) - 1;
                max = Math.max(max, length);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        return max;
    }
}
