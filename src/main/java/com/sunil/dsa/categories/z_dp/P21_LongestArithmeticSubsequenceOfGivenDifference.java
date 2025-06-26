package com.sunil.dsa.categories.z_dp;

import java.util.HashMap;
import java.util.Map;

public class P21_LongestArithmeticSubsequenceOfGivenDifference {

    public static void main(String[] args) {
        P21_LongestArithmeticSubsequenceOfGivenDifference o = new P21_LongestArithmeticSubsequenceOfGivenDifference();
        int[] arr = {1, 2, 3, 4};
        int difference = 1;
        System.out.println(o.longestSubsequence(arr, difference));

    }

    public int longestSubsequence(int[] arr, int difference) {
        int max =  0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, solve(arr, difference, i));
        }
        return max;
    }

    private int solve(int[] arr, int diff, int index) {
        if (index >= arr.length) {
            return 0;
        }
        int max = 1; // include current index

        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] - arr[index] == diff) {
                max = Math.max(max, 1 + solve(arr, diff, i));
            }
        }

        return max;
    }


    public int longestSubsequenceOS(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int max = 0;

        for (int num : arr) {
            int len = dp.getOrDefault(num - difference, 0) + 1;
            dp.put(num, len);
            max = Math.max(max, len);
        }

        return max;
    }

}


