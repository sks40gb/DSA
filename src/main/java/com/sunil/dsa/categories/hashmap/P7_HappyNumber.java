package com.sunil.dsa.categories.hashmap;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/happy-number/description/

Example 1:
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:
Input: n = 2
Output: false
 */
public class P7_HappyNumber {

    public static void main(String[] args) {
        P7_HappyNumber o = new P7_HappyNumber();
        System.out.println(o.isHappy(19));
    }

    public boolean isHappy(int n) {

        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = squareSum(n);
        }
        return n == 1;
    }

    private int squareSum(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }


}
