package com.sunil.dsa.patterns.windowsldiging.variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest Substring Without Repeating Characters
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

public class C_Longest_Substring_Without_Repeating {

    public static void main(String[] args) {

        String input =  "abcabcbb";
        int result = new C_Longest_Substring_Without_Repeating().solve(input);
        System.out.println(result);
    }

    private int solve(String input){

        List<Character> list = new ArrayList<>();
        int max = 0;
        for(int r=0; r < input.length(); r++){
            Character c = input.charAt(r);
            if(!list.contains(c)){
                list.add(c);
                max = Math.max(max, list.size());
            }else{
                while(list.contains(c)){
                    Character rChar = input.charAt(r);
                    list.remove(rChar);
                    r++;
                }
            }
        }
       return max;
    }
}
