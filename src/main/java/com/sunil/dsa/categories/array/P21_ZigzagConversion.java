package com.sunil.dsa.categories.array;

import util.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Input: s = "PAYPALISHIRING", numRows = 3

P   A   H   N
A P L S I I G
Y   I   R

Output: "PAHNAPLSIIGYIR"

 */
public class P21_ZigzagConversion {

    public static void main(String[] args) {
        P21_ZigzagConversion o = new P21_ZigzagConversion();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(o.convert(s, numRows));
    }

    public String convert(String s, int numRows) {
        boolean down = true;
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");

        int index = 1;
        while (index < s.length()) {
            if (down) {
                for (int j = 1; j <= numRows - 1 && index < s.length(); j++) {
                    arr[j] += s.charAt(index);
                    index++;
                }
                down = false;
            } else {
                for (int j = numRows - 2; j >= 0 && index < s.length(); j--) {
                    arr[j] += s.charAt(index);
                    index++;
                }
                down = true;
            }
        }
        StringBuilder result = new StringBuilder(String.valueOf(s.charAt(0)));
        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
        }
        return result.toString();
    }

}
