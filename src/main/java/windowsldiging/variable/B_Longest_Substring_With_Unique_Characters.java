package windowsldiging.variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the longest substring with k unique characters in a given string
 * Examples :
 *
 * "aabbcc", k = 1
 * Max substring can be any one from {"aa" , "bb" , "cc"}.
 * Max is "aabbcc" with length 2.
 *
 * "aabbcc", k = 2
 * Max substring can be any one from {"aabb" , "bbcc"}.
 * Max is "aabbcc" with length 4.
 *
 * "aabbcc", k = 3
 * There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
 * Max is "aabbcc" with length 6.
 *
 * "aaabbb", k = 3
 * There are only two unique characters, thus show error message.
 */

public class B_Longest_Substring_With_Unique_Characters {

    public static void main(String[] args) {
        String input = "aabbcc";
        int k = 1;
        int longest = new B_Longest_Substring_With_Unique_Characters().solve(input, k);
        System.out.println(longest);
    }

    int solve(String input, int k) {

        int max = 0;
        Map<Character, Integer> countMap = new HashMap<>();

        int l = 0;
        for (int r = 0; r < input.length(); r++) {
            addToMap(countMap, input.charAt(r));
            if (countMap.size() == k) {
                max = Math.max(max, r - l + 1);
            }
            while (countMap.size() > k) {
                removeFromMap(countMap, input.charAt(l));
                l++;
            }
        }
        return max;
    }

    private void addToMap(Map<Character, Integer> map, Character c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }

    private void removeFromMap(Map<Character, Integer> map, Character c) {
        if (map.get(c) == 1) {
            map.remove(c);
        } else {
            map.put(c, map.get(c) - 1);
        }
    }
}
