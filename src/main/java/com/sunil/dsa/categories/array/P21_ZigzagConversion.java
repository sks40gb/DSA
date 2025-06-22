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
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

        for (int i = 0; i < s.length(); i++) {
            rows[currRow].append(s.charAt(i));
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

}
