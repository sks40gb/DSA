package categories.string.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-palindrome/description/?envType=problem-list-v2&envId=ehkbkaxt
 */
public class LongestPalindrome {

    private static int longest(String s) {
        int evenCount = 0;

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(list.contains(c)){
                list.remove(c);
                evenCount++;
            }else{
                list.add(c);
            }
        }
        evenCount *= 2;
        return list.isEmpty() ? evenCount : evenCount + 1;
    }
}
