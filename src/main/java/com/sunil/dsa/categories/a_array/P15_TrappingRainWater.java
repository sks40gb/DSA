package com.sunil.dsa.categories.a_array;

/*
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].

In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 */
public class P15_TrappingRainWater {

    public static void main(String[] args) {
        P15_TrappingRainWater o = new P15_TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = o.trap(height);
        System.out.println(result);
    }

    public int trap(int[] height) {
        int n = height.length;

        int[] h = new int[n];

        //left to right
        int maxSoFar = 0;
        for (int i = 0; i < n; i++) {
            h[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, height[i]);
        }

        //right to left
        maxSoFar = 0;
        for (int i = n - 1; i >= 0; i--) {
            h[i] = Math.min(h[i], maxSoFar);
            maxSoFar = Math.max(maxSoFar, height[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] < h[i]) {
                result += h[i] - height[i];
            }
        }
        return result;
    }

}
