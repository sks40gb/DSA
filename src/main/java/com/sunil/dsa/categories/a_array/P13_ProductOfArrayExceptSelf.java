package com.sunil.dsa.categories.a_array;

import util.ArrayUtil;

/*
Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

 */
public class P13_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        P13_ProductOfArrayExceptSelf o = new P13_ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        // 1, 2, 3, 4
        // 1,  2,  6,  24
        // 24, 24, 12, 4
        //---------------------
        // 24,

        int[] result = o.productExceptSelf(nums);
        ArrayUtil.print1D(result);
    }

    public int[] productExceptSelf(int[] nums) {
//        return solution1(nums);
//        return solution2(nums);
        return solution3(nums);
    }

    public int[] solution1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int mult = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    mult = mult * nums[j];
                }
            }
            result[i] = mult;
        }
        return result;
    }

    public int[] solution2(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        leftProduct[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        int[] rightProduct = new int[n];
        rightProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            leftProduct[i] = leftProduct[i] * rightProduct[i];
        }
        return leftProduct;
    }


    public int[] solution3(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        leftProduct[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            leftProduct[i] = leftProduct[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        return leftProduct;
    }
}
