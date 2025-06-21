package com.sunil.dsa.categories.array;

import java.util.LinkedHashMap;
import java.util.Map;

/*
https://leetcode.com/problems/integer-to-roman/description/

Example 1:

Input: num = 3749
Output: "MMMDCCXLIX"

Example 2:
Input: num = 58
Output: "LVIII"

 */
public class P17_IntegerToRoman {
    public static void main(String[] args) {
        P17_IntegerToRoman o = new P17_IntegerToRoman();
        System.out.println(o.intToRoman(3749));
    }

    public String intToRoman(int num) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        String result = "";
        for (String key : map.keySet()) {
            while (num >= map.get(key)) {
                result += key;
                num -= map.get(key);
            }
        }
        return result;
    }
}
